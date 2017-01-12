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
import edu.isep.JDBC.Universite;
import edu.isep.JDBC.UniversiteRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminUniversityEditController {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminUniversityEditController.class);
	
	@RequestMapping(value = "/admin_university_edit", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			@RequestParam(value="id", required=false) long id) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUni= ctx.getBean(UniversiteRepository.class);
		
		Universite universite=repoUni.findOne(id);
		
		request.setAttribute("universite",universite);
		
		return "admin/admin_university_edit";
	}
	
	@RequestMapping(value = "/admin_modifieruniv", method = RequestMethod.POST)
	public String modifier(HttpServletRequest request,
			@RequestParam("nom") String nom,
			@RequestParam("lien") String lien,
			@RequestParam("id") long id) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUni= ctx.getBean(UniversiteRepository.class);
		
		Universite universite=repoUni.findOne(id);
		
		try {
			lien = new String(lien.getBytes("iso-8859-1"), "utf8");
			nom = new String(nom.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!lien.equals("")){
			universite.setLienuniv(lien);
			repoUni.updateOne(universite);}
		
		if(!nom.equals("")){
			universite.setNomuniv(nom);
			repoUni.updateOne(universite);}
		
				return "redirect:admin_universities";
		
	}
}
