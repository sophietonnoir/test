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
public class EleveProfilModifyController {
	@RequestMapping(value = "/eleve_modifierProfil", method = RequestMethod.POST)
	public String form(HttpServletRequest request,
			@RequestParam(value = "lmotiv", required = false) MultipartFile lmotiv,
			@RequestParam(value = "cv", required = false) MultipartFile cv,
			@RequestParam("actextra") String actextra,
			@RequestParam("competences") String competences,
			@RequestParam("notes") String notes,
			@RequestParam("apprenti") String apprenti,
			@RequestParam("adresse") String adresse,
			@RequestParam(value = "photo", required = false) MultipartFile photo)

	{
		HttpSession session= request.getSession();
		Relative_ROOT cst_path=new Relative_ROOT();
		String imageFolder="src/main/webapp/img/";
		String docFolder="src/main/webapp/doc/";
		String imagePath=cst_path.addRoot(imageFolder);
		String docPath=cst_path.addRoot(docFolder);
		//Récupération des données user/fiche
		User user =(User)session.getAttribute("user");
		System.out.println("ok :"+session.getAttribute("user"));
		Fiche fiche =(Fiche)session.getAttribute("fiche");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		FicheRepository repoF = ctx.getBean(FicheRepository.class);
		//Conversion en UTF-8
		try {
			adresse = new String(adresse.getBytes("iso-8859-1"), "utf8");
			apprenti = new String(apprenti.getBytes("iso-8859-1"), "utf8");
			competences = new String(competences.getBytes("iso-8859-1"), "utf8");
			actextra = new String(actextra.getBytes("iso-8859-1"), "utf8");
			notes = new String(notes.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!apprenti.equals("")){
			fiche.setCursus(apprenti);
			repoF.updateOne(fiche);}


		if(!competences.equals("")){
			fiche.setCompetences(competences);
			repoF.updateOne(fiche);}


		if(!actextra.equals("")){
			fiche.setActextra(actextra);
			repoF.updateOne(fiche);}

		if(!adresse.equals("")){
			fiche.setAdresse(adresse);
			repoF.updateOne(fiche);}


		if(!notes.equals("")){
			fiche.setNotes(notes);
			repoF.updateOne(fiche);}

		MultipartFile file = null;

		if(!photo.isEmpty()){
			file = photo;
			String filename = null;
			String full_file_name = null;
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
		}
		MultipartFile file1 = null;

		if(!lmotiv.isEmpty()){
			file1 = lmotiv;

			String filename1 = null;
			String full_file_name1 = null;
			filename1 = file1.getOriginalFilename();
			String[] tmpFile1 = filename1.split("\\.");
			String extension1 = tmpFile1[tmpFile1.length-1].toLowerCase();

			try {
				full_file_name1 = user.getLogin() + "Lmotiv." + extension1;
				BufferedOutputStream stream1 = new BufferedOutputStream(
						new FileOutputStream(new File( docPath+ full_file_name1)));
				FileCopyUtils.copy(file1.getInputStream(), stream1);
				stream1.close();
				fiche.setLettremotiv(full_file_name1);
				repoF.updateOne(fiche);

			}
			catch (Exception e) {

			}
		}
		MultipartFile file2 = null;

		if(!cv.isEmpty()){
			file2 = cv;
			String filename2 = null;
			String full_file_name2 = null;
			filename2 = file2.getOriginalFilename();
			String[] tmpFile2 = filename2.split("\\.");
			String extension2 = tmpFile2[tmpFile2.length-1].toLowerCase();

			try {
				full_file_name2 = user.getLogin() + "CV." + extension2;
				BufferedOutputStream stream2 = new BufferedOutputStream(
						new FileOutputStream(new File( docPath+ full_file_name2)));
				FileCopyUtils.copy(file2.getInputStream(), stream2);
				stream2.close();
				fiche.setCV(full_file_name2);
				repoF.updateOne(fiche);

			}
			catch (Exception e) {

			}
		}


		return "redirect:eleve_profil_validation";
	}
	@RequestMapping("/eleve_profil_modify")

	public String Profil_respo(HttpServletRequest request
			){

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		FicheRepository repoF = ctx.getBean(FicheRepository.class);
		HttpSession session= request.getSession();
		User user =(User)session.getAttribute("user");
		session.setAttribute("fiche",repoF.findOne(user));


		return "eleve/eleve_profil_modify";
	}
}
