package edu.isep.speakisep;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Universite;
import edu.isep.JDBC.UniversiteRepository;

@Controller

public class RespoInternationalUniversiteController {
	@RequestMapping("/respo_international_universite")

	public String RespoInternationalUniversite(HttpServletRequest request){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repo=ctx.getBean(UniversiteRepository.class);
		request.setAttribute("universites", repo.findAll());
		System.out.println("a  :"+repo.findAll());
		for (Universite t : repo.findAll()){
			System.out.println(t.getNomuniv()+","+t.getLienuniv()+",");
		}
		return "respo/respo_international_universite";
	}
}
