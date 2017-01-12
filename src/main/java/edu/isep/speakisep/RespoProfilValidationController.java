package edu.isep.speakisep;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RespoProfilValidationController {

	@RequestMapping(value = "/respo_profil_validation", method = RequestMethod.GET)
	public String RespoProfilValidation() {

		
		return "respo/respo_profil_validation";
	}
	
}
