package edu.isep.speakisep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RespoTemoignageController {
	private String promotion = "";
	private String nomEleve = "";
	private String nomParcours = "";
	private String statut = "";
	private String description = "";
	private Long temoignageId = 0L;

	@RequestMapping(value = "/respo_temoignage_confirm")
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

		return "redirect:respo_temoignage";
	}

	@RequestMapping(value = "/respo_temoignage", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//Récupération du responsable connecté
		HttpSession session = request.getSession();
		User responsable = (User) session.getAttribute("user");

		//Récupération des repository Fiche/Parcours/Temoignage/User
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		FicheRepository repoFiche = ctx.getBean(FicheRepository.class);
		ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);
		TemoignageRepository repoTemoignage = ctx.getBean(TemoignageRepository.class);
		UserRepository repoUser = ctx.getBean(UserRepository.class);

		//Récupération de la fiche et du parcours du responsable

		//Fiche respoFiche = repoFiche.findOne(responsable);
		Parcours parcours = repoParcours.findOne(responsable.getIdParcours());

		//Stockage des données recherchées dans data
		List<Temoignage> temoignagesFound = repoTemoignage.findAll(parcours.getNomparcours());
		List<String[]> data = new ArrayList<String[]>();
		List<Long> temoignagesId = new ArrayList<Long>();

		for (Temoignage temoignage : temoignagesFound) {
			User temoin = repoUser.findOne(temoignage.getUserId());
			Fiche temoinFiche = repoFiche.findOne(temoin);
			nomParcours = parcours.getNomparcours();
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

		return "respo/respo_temoignage";
	}

}
