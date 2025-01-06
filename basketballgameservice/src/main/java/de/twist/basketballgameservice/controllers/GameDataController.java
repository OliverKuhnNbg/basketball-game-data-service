package de.twist.basketballgameservice.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
public class GameDataController {
	
	@GetMapping(value="/")
	public String home() {
		return "home";
	}

	

}
