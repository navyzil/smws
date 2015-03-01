package com.zil.samwise.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.samwise.mapper.CharacterMapper;
import com.zil.samwise.model.CharacterExample;
import com.zil.samwise.model.Character;

@Repository
public class CharacterDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(CharacterDao.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	public List<Character> showAllCharacters(){
		LOGGER.debug("showAllCharacters");
		CharacterExample example = new CharacterExample();
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		
		return characterMapper.selectByExample(example);
	}

}
