package br.com.desafiojava.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.desafiojava.model.Movie;
import br.com.desafiojava.model.VoteUser;
import br.com.desafiojava.model.pk.VoteUserId;

public class MovieRepository {
	
private EntityManager entityManager;
	
	public MovieRepository(EntityManager entityManager)	{
		this.entityManager = entityManager;
	}
	
	public Movie find(long id)	{
	  	Movie movie = this.entityManager.find(Movie.class,id);
	  	return movie;
	}
	
	public VoteUser find(VoteUserId id)	{
		VoteUser voteUser = this.entityManager.find(VoteUser.class,id);
	  	return voteUser;
	}
	
	public void voteMovie(long id, String uuid) {
		Movie movie = this.find(id);
		VoteUserId voteUserId = new VoteUserId(uuid,movie);
		VoteUser voteUser = this.find(voteUserId);
		
		if(voteUser == null)
		{
			voteUser = new VoteUser();
		}
		
		movie.setPoints(movie.getPoints()+1);
		voteUser.setVoteUserId(voteUserId);
		voteUser.setPoints(voteUser.getPoints()+1);
		this.entityManager.persist(movie);
		this.entityManager.flush();
		this.entityManager.persist(voteUser);
		this.entityManager.flush();
	}
	
	@SuppressWarnings("unchecked")
	public List<Movie> listMovie()	{
		return (List<Movie>)this.entityManager.createQuery("Select m from Movie m").getResultList(); 
	}
	
	public List<VoteUser> listVoteUser(String uuid)	{
		TypedQuery<VoteUser> typedQuery = this.entityManager.createQuery("Select m from VoteUser m where m.voteUserId.chaveUser = :uuid order by m.points desc",VoteUser.class);
		typedQuery.setParameter("uuid", uuid);
		List<VoteUser> resultList = typedQuery.getResultList();
		return resultList;
	}
}