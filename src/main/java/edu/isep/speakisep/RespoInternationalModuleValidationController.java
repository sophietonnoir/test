package edu.isep.speakisep;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Fiche;
import edu.isep.JDBC.Module;
import edu.isep.JDBC.ModuleRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

@Controller
public class RespoInternationalModuleValidationController {
	@RequestMapping(value = "/eleve_validationmodules", method = RequestMethod.POST)
	public String form_valider(HttpServletRequest request,
			@RequestParam("Commentaire") String Commentaire,
			@RequestParam(value="id", required=false) long id)
	{

		//Récupération des données
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ModuleRepository repoM = ctx.getBean(ModuleRepository.class);
		//System.out.println("a  :"+);	
		//Conversion en UTF-8
		try {
			Commentaire = new String(Commentaire.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		Module module= repoM.findOneId(id);
		module.setCommentaire(Commentaire);
		module.setStatut("valide");
		repoM.updateOne(module);
		
		/*String mailrespo = repoU.findOneParcours(user.getIdParcours()).getMail();
		mailto(Arrays.asList(mailrespo), "Speakisep - Nouveaux modules à valider!",
				"De nouveaux modules d'élèves sont à valider. Connectez-vous vite sur la plateforme Speakisep.");*/
		return "redirect:respo_international_module";
	}

	@RequestMapping(value = "/eleve_refusmodules", method = RequestMethod.POST)
	public String form_refus(HttpServletRequest request,
			@RequestParam("Commentaire") String Commentaire,
			@RequestParam(value="id", required=false) long id)
	{

		//Récupération des données
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ModuleRepository repoM = ctx.getBean(ModuleRepository.class);
		//System.out.println("a  :"+repoM.findOneId(id));	
		//Conversion en UTF-8
		try {
			Commentaire = new String(Commentaire.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}


		Module module= repoM.findOneId(id);



		module.setCommentaire(Commentaire);
		module.setStatut("refus");
		repoM.updateOne(module);

		return "redirect:respo_international_module";
	}

	@RequestMapping("/respo_validation_module")

	public String Validate_module_respo(HttpServletRequest request,
			@RequestParam(value="id", required=false) long id){

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoUser= ctx.getBean(UserRepository.class);
		ModuleRepository repoModule= ctx.getBean(ModuleRepository.class);

		User eleve=repoUser.findOne(id);
		Module module=repoModule.findOne(id);

		//System.out.println("id  :" + id);
		//Vérifie que l'id existe
		User userFound=repoUser.findOne(id);
		request.setAttribute("eleve",eleve);
		request.setAttribute("module",module);

		return "respo/respo_validation_module";
	}
}