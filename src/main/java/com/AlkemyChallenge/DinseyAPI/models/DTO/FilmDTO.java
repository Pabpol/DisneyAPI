package com.AlkemyChallenge.DinseyAPI.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "films")
public class FilmModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "realeaseDAte")
	private Date realeaseDAte;
	@Column(name = "calification")
	private Integer calification;
	@Column(name = "imgUrl")
	private String imgUrl;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<CharacterModel> charaters ;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getRealeaseDAte() {
		return realeaseDAte;
	}
	public void setRealeaseDAte(Date realeaseDAte) {
		this.realeaseDAte = realeaseDAte;
	}
	public Integer getCalification() {
		return calification;
	}
	public void setCalification(Integer calification) {
		this.calification = calification;
	}
	
	

	

	public List<CharacterModel> getCharaters() {
		return charaters;
	}
	public void setCharaters(List<CharacterModel> charaters) {
		this.charaters = charaters;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}


}
