package edu.isep.speakisep;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Fiche;
import edu.isep.JDBC.FicheRepository;
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.Temoignage;
import edu.isep.JDBC.TemoignageRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminTemoignageController {
	private String promotion = "";
	private String nomEleve = "";
	private String nomParcours = "";
	private String statut = "";
	private String description = "";
	private Long temoignageId = 0L;
	
	@RequestMapping(value = "/admin_temoignage_confirm")
	public String confirmTemoignage(
			@RequestParam(value = "id", required = false) long id,
			@RequestParam(value = "c", required = false) String c) {
//Récupération des repository Fiche/Parcours/Temoignage/User
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		TemoignageRepository repoTemoignage = ctx.getBean(TemoignageRepository.class);
		Temoignage temoignage = repoTemoignage.findOne(id);

		if (c.equals("y")) {
			temoignage.setStatut("Validé");
			repoTemoignage.updateOne(temoignage);
		} else if (c.equals("n")) {
			repoTemoignage.delete(temoignage);
		}
		;

		return "redirect:admin_temoignage";
	}
	
	@RequestMapping(value = "/admin_temoignage", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		//Récupération des repository Fiche/Parcours/Temoignage/User
				AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
				FicheRepository repoFiche = ctx.getBean(FicheRepository.class);
				ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);
				TemoignageRepository repoTemoignage = ctx.getBean(TemoignageRepository.class);
				UserRepository repoUser = ctx.getBean(UserRepository.class);
				
				//Stockage des données recherchées dans data
				List<Temoignage> temoignagesFound = repoTemoignage.findAll();
				List<String[]> data = new ArrayList<String[]>();
				List<Long> temoignagesId = new ArrayList<Long>();
				
				for (Temoignage temoignage : temoignagesFound) {
					User temoin = repoUser.findOne(temoignage.getUserId());
					Fiche temoinFiche = repoFiche.findOne(temoin);
					nomParcours = temoignage.getNomparcours();
					nomEleve = temoin.getNom();
					promotion = temoinFiche.getPromotion();
					statut = temoignage.getStatut();
					description = temoignage.getDescriptem();
					temoignageId = temoignage.getId();
					System.out.println(temoignageId);
					temoignagesId.add(temoignageId);
					String[] a = {nomParcours, nomEleve, promotion, statut, description};
					data.add(a);
				}

				//Données envoyées à la view
				request.setAttribute("temoignages", data);
				request.setAttribute("temoignagesId", temoignagesId);

		return "admin/admin_temoignage";
	}
	
}
