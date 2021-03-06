package com.AlkemyChallenge.DinseyAPI.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AlkemyChallenge.DinseyAPI.modelDTO.CharacterDTO;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterDTO, Long> {

	public abstract List<CharacterDTO> findByName(String name);
	public abstract List<CharacterDTO> findByAge(Integer age);
	
	
}
