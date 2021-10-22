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
	@Column(name = "name")
	private String name;
	@Column(name ="imgUrl")
	private String imgUrl;
	@OneToMany(targetEntity = FilmModel.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "film_genere", referencedColumnName = "")
	private List<FilmModel> films;
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



	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}



}
