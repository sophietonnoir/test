package edu.isep.speakisep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class EleveHomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EleveHomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/eleve", method = RequestMethod.GET)
	public String home() {

		
		return "eleve/home";
	}
	
}
