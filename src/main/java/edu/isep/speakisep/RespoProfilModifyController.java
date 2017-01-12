package edu.isep.speakisep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.isep.JDBC.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;

@Controller
public class RespoProfilModifyController {

	@RequestMapping(value = "/form_modifierProfil", method = RequestMethod.POST)
	public String form(	HttpServletRequest request,
						   @RequestParam(value ="nomParcours", required = false) String nomParcours,
						   @RequestParam(value ="numSalle",required = false) String numSalle,
						   @RequestParam(value = "photo", required = false) MultipartFile photo)

	{

		HttpSession session= request.getSession();
		Relative_ROOT cst_path=new Relative_ROOT();

		//Récupération des données user/fiche
		User user =(User)session.getAttribute("user");
		Fiche fiche =(Fiche)session.getAttribute("fiche");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ParcoursRepository repoP = ctx.getBean(ParcoursRepository.class);
		UserRepository repoU = ctx.getBean(UserRepository.class);
		FicheRepository repoF = ctx.getBean(FicheRepository.class);
		//Conversion en UTF-8
		try {
			nomParcours = new String(nomParcours.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (!nomParcours.equals("")){
			long parcoursId = repoP.findOne(nomParcours).getId();
			//System.out.println("a  :"+nomParcours);
			user.setIdParcours(parcoursId);
			repoU.updateOne(user);
		}
		if(!numSalle.equals("")){
			fiche.setNumsalle(numSalle);
			repoF.updateOne(fiche);}

		MultipartFile file = null;
		if(photo != null)
			file = photo;


		String filename = null;
		String full_file_name = null;
		String imageFolder="src/main/webapp/img/";
		String imagePath=cst_path.addRoot(imageFolder);


		filename = file.getOriginalFilename();
		String[] tmpFile = filename.split("\\.");
		String extension = tmpFile[tmpFile.length-1].toLowerCase();

		try {
			full_file_name = user.getLogin() + "." + extension;
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File( imagePath+ full_file_name)));
			FileCopyUtils.copy(file.getInputStream(), stream);
			stream.close();

			fiche.setPhoto(full_file_name);
			repoF.updateOne(fiche);

		}
		catch (Exception e) {

		}


		return "redirect:respo_profil_validation";
	}



	@RequestMapping("/respo_profil_modify")

	public String Profil_respo(){
		return "respo/respo_profil_modify";
	}
}
