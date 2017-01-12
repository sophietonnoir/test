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
public class EleveInternationalController {
	
	private static final Logger logger = LoggerFactory.getLogger(EleveInternationalController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/eleve_international", method = RequestMethod.GET)
	public String home() {

		
		return "eleve/eleve_international";
	}
	
}
