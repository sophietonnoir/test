package edu.isep.speakisep;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Temoignage;
import edu.isep.JDBC.Universite;
import edu.isep.JDBC.UniversiteRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminUniversityAddController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminUniversityAddController.class);
	@RequestMapping(value = "/admin_university_add", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		
		
		return "admin/admin_university_add";
	}
	@RequestMapping(value = "/admin_ajouteruniv", method = RequestMethod.POST)
	public String modifier(HttpServletRequest request,
			@RequestParam("nom") String nom,
			@RequestParam("lien") String lien) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUni= ctx.getBean(UniversiteRepository.class);
		
		try {
			lien = new String(lien.getBytes("iso-8859-1"), "utf8");
			nom = new String(nom.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!lien.equals("")&&(!nom.equals(""))){
			Universite universite = new Universite(nom,lien);
			repoUni.save(universite);
			}

		
				return "redirect:admin_universities";
		
	}
}
