package br.com.desafiojava.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity 
public class Movie {

	@GeneratedValue @Id
	private long id;
	
	private String name;
	
	private int points;

	public Movie() {
		
	}

	public final long getId() {
		return id;
	}

	public final void setId(long id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final int getPoints() {
		return points;
	}

	public final void setPoints(int points) {
		this.points = points;
	}	
}
