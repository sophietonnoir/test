package edu.isep.speakisep;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.isep.JDBC.*;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

@Controller
public class LoginnController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@RequestMapping(value = "/loginn", method = RequestMethod.GET)
	public String showLoginForm(Model model){
		User form = new User();
		model.addAttribute("form", form);
		return "home";
	}

	@RequestMapping(value = "/loginn", method = RequestMethod.POST)
	public String submitForm(Model model,
							 @RequestParam("login") String login,
							 @RequestParam("password") String password,
							 @RequestParam("nom") String nom,
							 @RequestParam("nomFamille") String nomFamille,
							 @RequestParam("prenom") String prenom,
							 @RequestParam("type") String type,
							 @RequestParam("number") String number,
							 @RequestParam("mail") String mail,

							 HttpServletRequest request) {
		HttpSession session= request.getSession();
		String returnVal = "eleve_home";
		Md5 pwd = new Md5(password);
		User user = new User(login, pwd.codeGet(), nom, nomFamille, prenom, type, number, mail,0);
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		UserRepository repo = ctx.getBean(UserRepository.class);
		FicheRepository repoF=ctx.getBean(FicheRepository.class);
		request.getSession().setAttribute("loggedInUser", session);
		request.getSession().setAttribute("username", user.getPrenom());
//regarde si l'utilisateur est déjà inscrit dans la DB speakIsep
		int register=0;
		for (User t : repo.findAll()){
			if(t.getLogin().equals(user.getLogin())){
				user=t;
				register=1;
				if (type.equals("eleve")){
					returnVal= "eleve";
					request.getSession().setAttribute("eleveLoggedIn", type);
					request.getSession().setAttribute("user", user);
				} else if ( type.equals("admin") ){
					returnVal= "admin";
					request.getSession().setAttribute("adminLoggedIn", type);
					request.getSession().setAttribute("user", user);
				} else if ( type.equals("respo") ){
					returnVal= "respo";
					request.getSession().setAttribute("respoLoggedIn", type);
					request.getSession().setAttribute("user", user);
				}
				break;
			}
		}
		request.getSession().setAttribute("user", user);

		//Si l'utilisateur n'est pas inscrit, on l'enregistre lui+sa fiche
		if (register!=1){
			repo.save(user);
			Fiche fiche=new Fiche("",null,"","","","", "","", "", "", "", "","",user.getId());
			repoF.save(fiche);
			if (type.equals("eleve")){
				returnVal= "eleve_profil_modify";
				request.getSession().setAttribute("eleveLoggedIn", type);
				request.getSession().setAttribute("user", user);
			} else if ( type.equals("admin") ){
				returnVal= "admin";
				request.getSession().setAttribute("adminLoggedIn", type);
				request.getSession().setAttribute("user", user);
			} else if ( type.equals("respo") ){
				returnVal= "respo_profil_modify";
				request.getSession().setAttribute("respoLoggedIn", type);
				request.getSession().setAttribute("user", user);
			}

		}
		session.setAttribute("fiche",repoF.findOne(user));

        ReadCVS obj = new ReadCVS();
        obj.run(user);
		repo.findOne(user.getId());
		session= request.getSession();
		session.getAttribute("numero");

		//model.addAttribute("username", u1.getPrenom());

		return "redirect:"+returnVal;

	}
	public class Md5 {
		private String code;

		public Md5(String md5) {
			Passe(md5);
			// TODO Auto-generated constructor stub
		}

		public void Passe(String pass){
			byte[] passBytes = pass.getBytes();
			try {
				MessageDigest algorithm = MessageDigest.getInstance("MD5");
				algorithm.reset();
				algorithm.update(passBytes);
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(passBytes);
				BigInteger number = new BigInteger(1, messageDigest);
				this.code= number.toString(16);
			} catch (NoSuchAlgorithmException e) {
				throw new Error("invalid JRE: have not 'MD5' impl.", e);
			}
		}
		public String codeGet(){
			return code;
		}


	}

}

