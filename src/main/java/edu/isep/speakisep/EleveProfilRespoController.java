package edu.isep.speakisep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class EleveProfilRespoController {

	@RequestMapping("/eleve_profilRespo")
	public String Profil_respo(HttpServletRequest request,
			@RequestParam(value="id", required=false) long id){
		//Récupération des repository
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoUser= ctx.getBean(UserRepository.class);
		FicheRepository repoFiche= ctx.getBean(FicheRepository.class);
		ParcoursRepository repoParc= ctx.getBean(ParcoursRepository.class);

		//Récupération des données database user/fiche/parcours
		User responsable=repoUser.findOne(id);
		Fiche respoFiche=repoFiche.findOne(responsable);
		Parcours respoParcours=repoParc.findOne(responsable.getIdParcours());

		//Données envoyées à la view
		request.setAttribute("respo",responsable);
		request.setAttribute("respoFiche",respoFiche);
		request.setAttribute("respoParcours",respoParcours);

		return "eleve/eleve_profilRespo";
	}

}
