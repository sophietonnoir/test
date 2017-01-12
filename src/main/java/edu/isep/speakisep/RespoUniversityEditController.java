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
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RespoUniversityEditController {
	
	private static final Logger logger = LoggerFactory.getLogger(RespoUniversityEditController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/respo_university_edit", method = RequestMethod.GET)
	public String home(HttpServletRequest request,
			@RequestParam(value="id", required=false) long id) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUni= ctx.getBean(UniversiteRepository.class);
		
		Universite universite=repoUni.findOne(id);
		
		request.setAttribute("universite",universite);
		
		return "respo/respo_university_edit";
	}
	
	@RequestMapping(value = "/respo_modifieruniv", method = RequestMethod.POST)
	public String modifier(HttpServletRequest request,
			@RequestParam("lien") String lien,
			@RequestParam("id") long id) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUni= ctx.getBean(UniversiteRepository.class);
		
		Universite universite=repoUni.findOne(id);
		
		try {
			lien = new String(lien.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!lien.equals("")){
			universite.setLienuniv(lien);
			repoUni.updateOne(universite);}
				return "redirect:respo_international_universite";
		
	}
	
	
}
