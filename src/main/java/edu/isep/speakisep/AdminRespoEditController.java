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
import edu.isep.JDBC.ParcoursRepository;
import edu.isep.JDBC.Universite;
import edu.isep.JDBC.UniversiteRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

@Controller
public class AdminRespoEditController {

	@RequestMapping(value = "/admin_respoEdit", method = RequestMethod.GET)
	public String admin_edit(HttpServletRequest request,
			@RequestParam(value="id", required=false) long id) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoU= ctx.getBean(UserRepository.class);
		ParcoursRepository repoParcours = ctx.getBean(ParcoursRepository.class);

		//Données envoyées à la view
		request.setAttribute("parcours", repoParcours.findAll());
		
		User user=repoU.findOne(id);
		
		request.setAttribute("user",user);
		
		
		return "admin/admin_respoEdit";
	}
	
	@RequestMapping(value = "/admin_respoEdit", method = RequestMethod.POST)
	public String admin_respo(HttpServletRequest request,
			@RequestParam("id") long id,
			@RequestParam("nom") String nom,
			@RequestParam("parcours") long idParcours) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoU= ctx.getBean(UserRepository.class);
		
		User user=repoU.findOne(id);
		
		try {
			nom = new String(nom.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!nom.equals("")){
			user.setNom(nom);
			repoU.updateOne(user);}
		

			user.setIdParcours(idParcours);
			repoU.updateOne(user);
		
		return "redirect:admin_respo";
		
	}
	
}
