package com.AlkemyChallenge.DinseyAPI.models;

import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "geners")
public class GenresModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	private String name;
	private List<FilmModel> films;
	private String imgUrl;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<FilmModel> getFilms() {
		return films;
	}
	public void setFilms(List<FilmModel> films) {
		this.films = films;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



}
