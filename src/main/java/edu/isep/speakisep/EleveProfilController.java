package edu.isep.speakisep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class EleveProfilController {
	@Autowired
	@RequestMapping("/eleve_profil")
	
	public String Profil_respo(){
		return "eleve/eleve_profil";
	}
}
