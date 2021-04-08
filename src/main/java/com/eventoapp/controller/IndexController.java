package com.eventoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Class IndexController
 */
@Controller
public class IndexController {

	/**
	 * Method index
	 */
	@RequestMapping("/")
	public String index(){
		return "index";
	}
}

