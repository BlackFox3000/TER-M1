package mybootapp.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class MyControler {

	/*
	 * Récupérer un message particulier dans le fichier de configuration pour ne pas
	 * utiliser de constantes dans le code.
	 */
	@Value("${application.message:Hello World}")
	private String message;

	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView index() {
		var model = new ModelAndView("index");
		System.out.println("load index");

		return model;
	}

//	@Controller
//	// TODO: 28/05/2022   : implémenter les bonnes redirections
//	public class DefaultController {
//		@RequestMapping("/succeslogin")
//		public String defaultAfterLogin(HttpServletRequest request) {
//			if (request.isUserInRole("ROLE_ADMIN")) {
//				return "redirect:/admin/space";
//			}
//			return "redirect:/user/space";
//		}
//	}

}
