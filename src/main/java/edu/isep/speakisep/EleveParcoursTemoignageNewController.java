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
import edu.isep.JDBC.ModuleRepository;
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.Temoignage;
import edu.isep.JDBC.TemoignageRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

@Controller

public class EleveParcoursTemoignageNewController {
	@RequestMapping("/eleve_parcours_temoignage_new")	
	public String eleve_temoignage_new(HttpServletRequest request){
				//Récupération des repository
				AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
				ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);

				//Données envoyées à la view
				request.setAttribute("parcours", repoParcours.findAll());
				

		return "eleve/eleve_parcours_temoignage_new";
	}
	
	@RequestMapping(value = "/eleve_ajouttemoignage", method = RequestMethod.POST)
	public String form(HttpServletRequest request,
			@RequestParam("parcours") String parcours,
			@RequestParam("Commentaire") String Commentaire)
	{
		HttpSession session= request.getSession();
		User user =(User)session.getAttribute("user");

		//Récupération des données
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoU = ctx.getBean(UserRepository.class);
		TemoignageRepository repoTem = ctx.getBean(TemoignageRepository.class);
		
				//Conversion en UTF-8
				try {
					Commentaire = new String(Commentaire.getBytes("iso-8859-1"), "utf8");
					parcours = new String(parcours.getBytes("iso-8859-1"), "utf8");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}

				if(!parcours.equals("") && !Commentaire.equals("")){
					Temoignage temoignage = new Temoignage(Commentaire,user.getId(),parcours,"en attente");
					repoTem.save(temoignage);
				}
				
				System.out.println("b  :"+parcours);
		

		return "eleve/eleve_parcours";
	}
}
