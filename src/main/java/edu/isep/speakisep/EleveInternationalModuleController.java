package edu.isep.speakisep;

import java.awt.Desktop;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Module;
import edu.isep.JDBC.ModuleRepository;
import edu.isep.JDBC.UniversiteRepository;
import edu.isep.JDBC.User;
import edu.isep.JDBC.UserRepository;

@Controller

public class EleveInternationalModuleController {

	@RequestMapping(value = "/eleve_ajoutmodules", method = RequestMethod.POST)
	public String form(HttpServletRequest request,
			@RequestParam("universite") String universite,
			@RequestParam("description") String description,
			@RequestParam("lien") String lien) throws IOException, URISyntaxException
	{
		HttpSession session= request.getSession();
		User user =(User)session.getAttribute("user");

		//Récupération des données
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ModuleRepository repoM = ctx.getBean(ModuleRepository.class);
		UserRepository repoU = ctx.getBean(UserRepository.class);

		request.setAttribute("parcours", repoU.findOneParcours(user.getIdParcours()));
		request.setAttribute("respo", (repoU.findOneParcours(user.getIdParcours())).getMail());
		

		//Conversion en UTF-8
		try {
			universite = new String(universite.getBytes("iso-8859-1"), "utf8");
			description = new String(description.getBytes("iso-8859-1"), "utf8");
			lien = new String(lien.getBytes("iso-8859-1"), "utf8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		if(!universite.equals("") && !description.equals("") && !lien.equals("")){
			Module module = new Module(universite,description,lien,"en attente",null,user.getId(), user.getIdParcours());
			repoM.save(module);

			/*String mailrespo = repoU.findOneParcours(user.getIdParcours()).getMail();
			mailto(Arrays.asList(mailrespo), "Speakisep - Nouveaux modules à valider!",
					"De nouveaux modules d'élèves sont à valider. Connectez-vous vite sur la plateforme Speakisep.");*/
		}
		else{

		}

		return "redirect:eleve_international";
	}

	public static void mailto(List<String> recipients, String subject,
			String body) throws IOException, URISyntaxException {
		String uriStr = String.format("mailto:%s?subject=%s&body=%s",
				join(",", recipients), // use semicolon ";" for Outlook!
				urlEncode(subject),
				urlEncode(body));
		Desktop.getDesktop().browse(new URI(uriStr));
	}

	private static final String urlEncode(String str) {
		try {
			return URLEncoder.encode(str, "UTF-8").replace("+", "%20");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static final String join(String sep, Iterable<?> objs) {
		StringBuilder sb = new StringBuilder();
		for(Object obj : objs) {
			if (sb.length() > 0) sb.append(sep);
			sb.append(obj);
		}
		return sb.toString();
	}

	@RequestMapping("/eleve_international_module")

	public String module_eleve(HttpServletRequest request){

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UniversiteRepository repoUniv = ctx.getBean(UniversiteRepository.class);
		ModuleRepository repoM = ctx.getBean(ModuleRepository.class);
		
		HttpSession session= request.getSession();
		User user =(User)session.getAttribute("user");

		//Données envoyées à la view
		request.setAttribute("universite", repoUniv.findAll());
		
		
		int register=0;
		for (Module t : repoM.findAll()){
			if(t.getUserId() == (user.getId())){
				register=1;
				request.setAttribute("ModuleDone", register);
				break;
			}
			else{
				register=0;
			}
		}
		if (register==1){
			Module module= repoM.findOne(user.getId());
			request.setAttribute("module", module);
		}
		
		Date actuelle = new Date();
		 DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		 String dat = dateFormat.format(actuelle);
		 request.setAttribute("date", dat);
		//System.out.println("b  :"+dat);

		return "eleve/eleve_international_module";
	}
}
