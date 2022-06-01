package mybootapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class MyControler {

	/*
	 * Point d'entrée principal de l'application.
	 */
	@RequestMapping("")
	public ModelAndView login() {
		var model = new ModelAndView("login");
		System.out.println("load login");

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
