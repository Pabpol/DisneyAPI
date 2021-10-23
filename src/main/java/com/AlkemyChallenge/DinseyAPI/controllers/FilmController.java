package com.AlkemyChallenge.DinseyAPI.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.AlkemyChallenge.DinseyAPI.models.DAO.FilmDAO;
import com.AlkemyChallenge.DinseyAPI.models.DTO.FilmDTO;

@RestController
public class FilmController {

	private final FilmDAO filmDAO;
	
	FilmController (FilmDAO filmDAO){
		this.filmDAO = filmDAO;
	}
	
	@PostMapping("/movies")
	public FilmDTO newFIlmDTO(@RequestBody FilmDTO newFilmDTO) {
		return filmDAO.save(newFilmDTO);
	}
	
	@GetMapping("/movies")
	public List<FilmDTO> all(){
		return filmDAO.findAll(); 
	}
	@RequestMapping("/movies/{name}")
	public List<FilmDTO> findByTitle(@PathVariable String name) {
		return filmDAO.findByTitle(name);
	}
//	@RequestMapping("/movies/{genre}")
//	public FilmDTO findByGenre(@PathVariable Long id) {
//		
//	}
	
	@RequestMapping("/movies/{order}")
	public List<FilmDTO> sortListAsc() {
		return filmDAO.findByOrderByRealeaseDateAsc();
	}
	@RequestMapping("/movies/{order}")
	public List<FilmDTO> sortListDesc() {
		return filmDAO.findByOrderByRealeaseDateDesc();
	}
	
	@PutMapping("/movies/{id}")
	public FilmDTO replaceFilmDTO(@RequestBody FilmDTO newFilmDTO, @PathVariable Long id) {
		return filmDAO.findById(id)		
		.map(filmDTO -> {
			filmDTO.setTitle(newFilmDTO.getTitle());
			filmDTO.setImgUrl(newFilmDTO.getImgUrl());
			filmDTO.setRealeaseDate(newFilmDTO.getRealeaseDate());
			filmDTO.setCalification(newFilmDTO.getCalification());
			filmDTO.setCharaters(newFilmDTO.getCharaters());	
			return filmDAO.save(newFilmDTO);
		}).orElseGet(()->{
			newFilmDTO.setId(id);
			return filmDAO.save(newFilmDTO);
		});
	}
	
	public void deleteFilm(@PathVariable Long id) {
		filmDAO.deleteById(id);
	}
	
}
