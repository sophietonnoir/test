package edu.isep.speakisep;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Parcours;
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;


@Controller
public class AdminParcoursController {
	
	@RequestMapping(value = "/admin_parcours", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		//Récupération des repository
				AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
				ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);
				
				//Données envoyées à la view
				request.setAttribute("parcoursFound", repoParcours.findAll());
		return "admin/admin_parcours";
	}
	
	@RequestMapping(value = "/admin_parcoursRemove")
	public String deleteParcours(
		@RequestParam(value = "id", required = false) long id){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);
		Parcours parcours = repoParcours.findOne(id);
		
		repoParcours.delete(parcours);
		return "redirect:admin_parcours";
		
	}
	
}
