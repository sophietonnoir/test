package edu.isep.speakisep;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.Temoignage;
import edu.isep.JDBC.TemoignageRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminRespoController {

		private static final String SQL_INNER = "SELECT * from parcours INNER JOIN user WHERE parcours.IDPARCOURS=user.IDPARCOURS AND user.type='respo'";
		
		@RequestMapping(value = "/admin_respo", method = RequestMethod.GET)
		
		public String eleve_parcours_responsable(HttpServletRequest request){
			//Récupération des repository
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
			ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);
			UserRepository repoUser = ctx.getBean(UserRepository.class);

			//Données envoyées à la view
			request.setAttribute("parcoursFound", repoParcours.findAllBySql(SQL_INNER));
			request.setAttribute("respoFound", repoUser.findAllBySql(SQL_INNER));
		return "admin/admin_respo";
	}
		
		@RequestMapping(value = "/admin_respo_delete")
		public String deleteTemoignage(
			@RequestParam(value = "id", required = false) long id){
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
			UserRepository repoUser = ctx.getBean(UserRepository.class);
			User user = repoUser.findOne(id);
			
			repoUser.delete(user);
			return "redirect:admin_respo";
			
		}
				
	
}
