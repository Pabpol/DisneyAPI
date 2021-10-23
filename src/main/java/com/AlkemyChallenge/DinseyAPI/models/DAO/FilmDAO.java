package com.AlkemyChallenge.DinseyAPI.models.DAO;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;


import com.AlkemyChallenge.DinseyAPI.models.DTO.FilmDTO;

public interface FilmDAO extends JpaRepository<FilmDTO, Long>{

	List<FilmDTO> findByTitle(String title);
	List<FilmDTO> findByOrderByRealeaseDateAsc();
	List<FilmDTO> findByOrderByRealeaseDateDesc();

	
	
}
