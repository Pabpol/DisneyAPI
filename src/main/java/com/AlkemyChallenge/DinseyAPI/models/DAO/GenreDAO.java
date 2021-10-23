package com.AlkemyChallenge.DinseyAPI.models.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.AlkemyChallenge.DinseyAPI.models.DTO.GenreDTO;

public interface GenreDAO extends JpaRepository<GenreDTO, Long> {

}
