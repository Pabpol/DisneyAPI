package com.AlkemyChallenge.DinseyAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.AlkemyChallenge.DinseyAPI.modelDTO.GenreDTO;

@Repository
public interface GenreRepository extends JpaRepository<GenreDTO, Long> {

}
