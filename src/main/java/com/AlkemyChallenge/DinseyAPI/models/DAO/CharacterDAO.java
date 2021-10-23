package com.AlkemyChallenge.DinseyAPI.models.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AlkemyChallenge.DinseyAPI.models.DTO.CharacterDTO;


public interface CharacterDAO extends JpaRepository<CharacterDTO, Long> {

	List<CharacterDTO> findByName(String name);
	List<CharacterDTO> findByAge(Integer age);
	
	
}
