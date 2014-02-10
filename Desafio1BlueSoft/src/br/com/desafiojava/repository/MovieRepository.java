package br.com.desafiojava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import br.com.desafiojava.model.Movie;

public class MovieRepository {
	
private EntityManager entityManager;
	
	public MovieRepository(EntityManager entityManager)	{
		this.entityManager = entityManager;
	}
	
	public Movie find(long id)	{
	  	Movie movie = this.entityManager.find(Movie.class,id);
	  	return movie;
	}
	
	public void voteMovie(long id){
		Movie movie = this.find(id);
		if(movie != null){
			movie.setPoints(movie.getPoints()+1);
			this.entityManager.persist(movie);
		}
	} 
	
	@SuppressWarnings("unchecked")
	public List<Movie> listMovie()	{
		return (List<Movie>)this.entityManager.createQuery("Select m from Movie m").getResultList(); 
	}
}
