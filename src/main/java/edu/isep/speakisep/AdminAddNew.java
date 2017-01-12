package edu.isep.speakisep;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.isep.JDBC.Config;
import edu.isep.JDBC.Parcours;
import edu.isep.JDBC.ParcoursRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

/**
 * Handles requests for the application home page.
 */
@Controller
public class AdminAddNew {
	
	private static final Logger logger = LoggerFactory.getLogger(AdminAddNew.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin_AddNew", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		ParcoursRepository repo1=ctx.getBean(ParcoursRepository.class);
		request.setAttribute("parcours", repo1.findAll());
		System.out.println("a  :"+repo1.findAll());
		for (Parcours t : repo1.findAll()){
			System.out.println(t.getNomparcours()+","+t.getDescription()+",");
		}
		return "admin/admin_AddNew";
	}

	@RequestMapping(value = "/form_AddNew", method = RequestMethod.POST)
	public String form(HttpServletRequest request,
					   @RequestParam(value = "addParcours", required = false) MultipartFile csvFile)

	{
		Relative_ROOT cst_path=new Relative_ROOT();
		MultipartFile file = null;

		if(!csvFile.isEmpty()){
			file = csvFile;

			String filename = null;
			String imageFolder="src/main/resources/parcours/";
			String imagePath=cst_path.addRoot(imageFolder);
			filename = file.getOriginalFilename();
			try {
				System.out.print(imagePath);

				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File( imagePath+ filename)));
				FileCopyUtils.copy(file.getInputStream(), stream);
				stream.close();

			}
			catch (Exception e) {

			}
		}
		return "admin/home";}
	
}
