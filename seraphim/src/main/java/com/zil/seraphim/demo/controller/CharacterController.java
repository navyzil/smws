package com.zil.seraphim.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zil.seraphim.demo.model.Character;
import com.zil.seraphim.demo.service.CharacterService;

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
	
	@RequestMapping(value="", method=RequestMethod.GET)
	@ResponseBody
	public Character showCharacter(@RequestParam("id") Integer characterTableId){//(@PathVariable("id") Integer characterTableId){
		
		return characterService.showCharacter(characterTableId);
	}
	
	@RequestMapping(value="", method=RequestMethod.PUT)
	@ResponseBody
	public Boolean createNewCharacter(@RequestParam("characterId") String characterId,
									  @RequestParam("characterLevel") String characterLevel,
									  @RequestParam("characterName") String characterName){

		Character character = new Character();
		character.setCharacterId(characterId);
		character.setCharacterLevel(characterLevel);
		character.setCharacterName(characterName);
		
		return characterService.createCharacter(character);
	}
	
}
