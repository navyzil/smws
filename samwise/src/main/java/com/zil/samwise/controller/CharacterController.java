package com.zil.samwise.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zil.samwise.model.Character;
import com.zil.samwise.service.CharacterService;

@Controller
@RequestMapping("/character")
public class CharacterController {
	private static final Logger LOGGER = LoggerFactory.getLogger(CharacterController.class);
	
	@Autowired
	private CharacterService characterService;
	
	@RequestMapping(value="/all", method=RequestMethod.GET)
	@ResponseBody
	public List<Character> showAllCharacters(){
		LOGGER.debug("controller-showAllCharacters");
		return characterService.showAllCharacters();
	}
}
