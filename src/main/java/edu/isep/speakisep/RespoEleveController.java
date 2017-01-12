package edu.isep.speakisep;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.isep.JDBC.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RespoEleveController {
	private static final String SQL_INNER = "SELECT * from user INNER JOIN fiche WHERE fiche.userId=user.userId AND user.type='eleve' order by fiche.promotion,user.nomFamille";

	@RequestMapping("/respo_eleve")
	public String Respo_eleves(
			HttpServletRequest request
	){
		HttpSession session= request.getSession();
		User user =(User)session.getAttribute("user");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repoUser=ctx.getBean(UserRepository.class);
		FicheRepository repoFiche=ctx.getBean(FicheRepository.class);

		request.setAttribute("eleves", repoUser.findAllBySql(SQL_INNER));
		request.setAttribute("elevedeMonParcours", repoUser.findAll(user.getIdParcours()));
		request.setAttribute("promotions",repoFiche.findAllPromo());
		request.setAttribute("fiches",repoFiche.findAllBySql(SQL_INNER));

		for (Object a :repoFiche.findAllPromo() ){
			System.out.println(a);
		}
		System.out.println(repoUser.findAllBySql(SQL_INNER));
		System.out.println(repoFiche.findAllBySql(SQL_INNER));

		return "respo/respo_eleve";

	}
}
