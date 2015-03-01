package com.zil.samwise.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zil.samwise.dao.CharacterDao;
import com.zil.samwise.model.Character;

@Service
public class CharacterService {
	public static final Logger LOGGER = LoggerFactory.getLogger(CharacterService.class);
	
	@Autowired
	private CharacterDao characterDao;

	@Transactional(isolation=Isolation.READ_COMMITTED, propagation=Propagation.SUPPORTS)
	public List<Character> showAllCharacters(){
		LOGGER.debug("Service-showAllCharacters");
		return characterDao.showAllCharacters();

	}

}
