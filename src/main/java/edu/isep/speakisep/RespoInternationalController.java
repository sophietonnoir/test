package edu.isep.speakisep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RespoInternationalController {
	@Autowired
	@RequestMapping("/respo_international")

	public String showInternational() {
		return "respo/respo_international";
	}

}