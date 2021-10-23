package com.AlkemyChallenge.DinseyAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.AlkemyChallenge.DinseyAPI.models.DAO.GenreDAO;
import com.AlkemyChallenge.DinseyAPI.models.DTO.GenreDTO;

@RestController
public class GenreController {
	
	
	private final GenreDAO genreDAO; 
	
	
	
	GenreController(GenreDAO genreDAO) {
		this.genreDAO = genreDAO;
	}



	@GetMapping("/genre")
	public List<GenreDTO> all(){
		return genreDAO.findAll();
	}
	
	@GetMapping("/genre/{id}")
	public GenreDTO one(@PathVariable Long id) {
		return genreDAO.getById(id);
	}
	
	@PostMapping("/genre")
	public GenreDTO newGenreDTO(@RequestBody GenreDTO newGenreDTO) {
		return genreDAO.save(newGenreDTO);
	}
	@DeleteMapping("/genre/{id}")
	public void deleteGenreDTO(@PathVariable Long ID) {
		genreDAO.deleteById(ID);
	}
}
