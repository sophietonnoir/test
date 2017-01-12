package edu.isep.speakisep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.FicheRepository;
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RespoProfilController {
	@RequestMapping("/respo_profil")

	public String Profil_respo(	HttpServletRequest request
			){
		//Récupération des repository
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ParcoursRepository repo=ctx.getBean(ParcoursRepository.class);
		FicheRepository repoF=ctx.getBean(FicheRepository.class);

		//Récupération des données de l'utilisateur
		HttpSession session= request.getSession();
		User user=(User)session.getAttribute("user");

		//Données envoyées à la view
		if ((user.getIdParcours())!=0){
			session.setAttribute("parcours",repo.findOne(user.getIdParcours()));
		}
		session.setAttribute("Allparcours", repo.findAll());
		session.setAttribute("fiche",repoF.findOne(user));
		return "respo/respo_profil";
	}
}