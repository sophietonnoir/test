package edu.isep.speakisep;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Universite;
import edu.isep.JDBC.UniversiteRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminUniversitiesController {

	private static final Logger logger = LoggerFactory.getLogger(AdminUniversitiesController.class);

	@RequestMapping(value = "/admin_universities", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repo=ctx.getBean(UniversiteRepository.class);
		request.setAttribute("universites", repo.findAll());
		System.out.println("a  :"+repo.findAll());
		for (Universite t : repo.findAll()){
			System.out.println(t.getNomuniv()+","+t.getLienuniv()+",");
		}
		return "admin/admin_universities";
	}


}
