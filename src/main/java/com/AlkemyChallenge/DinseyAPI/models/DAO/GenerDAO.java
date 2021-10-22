package com.AlkemyChallenge.DinseyAPI.models.DAO;

import org.springframework.data.repository.CrudRepository;

import com.AlkemyChallenge.DinseyAPI.models.DTO.GenreDTO;

public interface GenerDAO extends CrudRepository<GenreDTO, Long> {

}
