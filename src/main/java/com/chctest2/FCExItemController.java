package com.chctest2;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class FCExItemController {

	private static Logger myLogger = Logger
			.getLogger(FCExItemController.class.getName());

	
	@GetMapping("/")
	public String formCustomLoad(Model model) {

		if (!model.containsAttribute("fcexitem")) {
			model.addAttribute("fcexitem", new FCExItem());
		}
		model.addAttribute("action", "/addfc");
		return "index";
	}
	
	@PostMapping(value = "/addfc")
	public String addFCExItem(@Valid FCExItem fcexitem, BindingResult result, RedirectAttributes redirectAttr) {
 
		if (result.hasErrors()) {redirectAttr.addFlashAttribute("org.springframework.validation.BindingResult.fcexitem",result);

			redirectAttr.addFlashAttribute("fcexitem", fcexitem);

			return "redirect:/addfc";
		}
		myLogger.info("===========>>>>>>>>>>> IN CARD CONTROLLER  fcexitem.first = "+fcexitem.getFirst());
		return "redirect:/";
	}
	
}
