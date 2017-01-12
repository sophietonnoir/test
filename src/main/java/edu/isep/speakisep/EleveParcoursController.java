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
public class EleveParcoursController {
	
	private static final Logger logger = LoggerFactory.getLogger(EleveParcoursController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/eleve_parcours", method = RequestMethod.GET)
	public String home() {
		return "eleve/eleve_parcours";
	}
	
}
