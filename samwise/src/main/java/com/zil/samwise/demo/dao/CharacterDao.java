package com.zil.samwise.demo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zil.samwise.demo.mapper.CharacterMapper;
import com.zil.samwise.demo.model.Character;
import com.zil.samwise.demo.model.CharacterExample;

@Repository
public class CharacterDao {
	public static final Logger LOGGER = LoggerFactory.getLogger(CharacterDao.class);
	
	@Autowired
	private SqlSessionFactory sessionFactory;

	public List<Character> showAllCharacters(){
		CharacterExample example = new CharacterExample();
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		
		return characterMapper.selectByExample(example);
	}
	
	public Boolean createCharacter(Character character){
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		int result = characterMapper.insertSelective(character);
		if(result == 1){
			return true;
		}
		return false;
	}

	public Character showCharacter(Integer characterTableId) {
		CharacterMapper characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		characterMapper = sessionFactory.openSession().getMapper(CharacterMapper.class);
		
		return characterMapper.selectByPrimaryKey(characterTableId);
	}
	

}
