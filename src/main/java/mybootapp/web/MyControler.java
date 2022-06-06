package mybootapp.web;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	@RequestMapping(value = {"/home"})
	public ModelAndView homePage(){
		var model = new ModelAndView("home");
		System.out.println("load home page");

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
