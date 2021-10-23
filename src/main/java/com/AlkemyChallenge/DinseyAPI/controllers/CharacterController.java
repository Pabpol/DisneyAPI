package com.AlkemyChallenge.DinseyAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlkemyChallenge.DinseyAPI.models.DAO.CharacterDAO;
import com.AlkemyChallenge.DinseyAPI.models.DTO.CharacterDTO;

@RestController
public class CharacterController {

	private final CharacterDAO characterDAO;

	public CharacterController(CharacterDAO characterDAO) {
		this.characterDAO = characterDAO;
	}

	@PostMapping("/characters")
	public CharacterDTO newCharacter(@RequestBody CharacterDTO newCharacterDTO) {
		return characterDAO.save(newCharacterDTO);
	}

	@RequestMapping("/characters")
	public List<CharacterDTO> all() {
		return characterDAO.findAll();
	}

	@RequestMapping("/characters/{name}")
	public List<CharacterDTO> findByName(@PathVariable String name) {
		return characterDAO.findByName(name);
	}

	@RequestMapping("/characters/{age}")
	public List<CharacterDTO> findByAge(@PathVariable Integer age) {
		return characterDAO.findByAge(age);
	}

	@PutMapping("/characters/{id}")
	public CharacterDTO replaceCharacter(@RequestBody CharacterDTO newCharacterDTO, @PathVariable Long id) {

		return characterDAO.findById(id).map(character -> {
			character.setName(newCharacterDTO.getName());
			character.setAge(newCharacterDTO.getAge());
			character.setImgURL(newCharacterDTO.getImgURL());
			character.setStory(newCharacterDTO.getStory());
			character.setFilms(newCharacterDTO.getFilms());

			return characterDAO.save(character);
		}).orElseGet(() -> {
			newCharacterDTO.setId(id);
			return characterDAO.save(newCharacterDTO);
		});
	}

	@RequestMapping("/characters")
	public void deleteCharacter(@PathVariable Long id) {
		characterDAO.deleteById(id);
	}
}
