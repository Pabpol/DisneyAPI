package com.AlkemyChallenge.DinseyAPI.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.AlkemyChallenge.DinseyAPI.models.DTO.FilmDTO;

public interface FilmDAO extends CrudRepository<FilmDTO, Long>{

}
