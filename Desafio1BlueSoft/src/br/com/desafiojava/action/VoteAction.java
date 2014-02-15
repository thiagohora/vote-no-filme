package br.com.desafiojava.action;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.desafiojava.model.Movie;
import br.com.desafiojava.model.VoteUser;
import br.com.desafiojava.repository.MovieRepository;

@Namespace("/Vote")
public class VoteAction extends ActionDefault {

	public Map<String, Object> session;
	
	private MovieRepository movieRepository = new MovieRepository(this.getEntityManager());
	
	private Movie movieOpt1;
	private Movie movieOpt2;	
	private List<Movie> listMovie = movieRepository.listMovie();
	private long current;
	private String name;
	private String email;
	private List<VoteUser> listVoteUser;
	
	
	private Movie randomMovie(){
		Random Randomizer = new Random(); 
		Movie random = listMovie.get(Randomizer.nextInt(listMovie.size()));
		return random;
	}
	
	private void random(){
		
		this.session = ActionContext.getContext().getSession();
	
		if(this.session.size() == 0)
		{
			do
			{
				movieOpt1 = randomMovie();
				movieOpt2 = randomMovie();
			}
			while(movieOpt2.getId() == movieOpt1.getId());
			
			this.session.put("movieOpt1", movieOpt1);
			this.session.put("movieOpt2", movieOpt2);
			
			this.session.put("UUID", UUID.randomUUID());
			
		} else {
			 
			Movie movieAux1 =  (Movie)session.get("movieOpt1");
			Movie movieAux2 =  (Movie)session.get("movieOpt2");
			
			do
			{
				movieOpt1 = randomMovie();
				movieOpt2 = randomMovie();
			}
			while(movieOpt2.getId() == movieAux2.getId() ||
				  movieOpt2.getId() == movieAux1.getId() ||
				  movieOpt1.getId() == movieAux2.getId() ||
                  movieOpt1.getId() == movieAux1.getId() ||
                  movieOpt1.getId() == movieOpt2.getId()
                  );
			
			this.session.remove("movieOpt1");
			this.session.remove("movieOpt2");
			
			this.session.put("movieOpt1", movieOpt1);
			this.session.put("movieOpt2", movieOpt2);
		} 
		
	}
	
	@Action(value="createVote", results={
			@Result(name ="ok", location="/voto.jsp")
			})
	public String Vote(){
		
		this.session = ActionContext.getContext().getSession();
		
		this.random();
		movieRepository.voteMovie(this.current,this.session.get("UUID").toString());
		return "ok";
	}
	
	@Action(value="pageVote", results=@Result(name ="ok", location="/voto.jsp"))
	public String PageVote(){
		this.random();
		return "ok";
	}
	
	@Action(value="pageChart", results=@Result(name ="ok", location="/chart.jsp"  ))
	public String pageChart(){
		return "ok";
	}
	
	@Action(value="finished", results=@Result(name ="ok", location="/finishedVote.jsp"  ))
	public String finished(){
		return "ok";
	}

	public final Movie getMovieOpt1() {
		return movieOpt1;
	}

	public final void setMovieOpt1(Movie movieOpt1) {
		this.movieOpt1 = movieOpt1;
	}

	public final Movie getMovieOpt2() {
		return movieOpt2;
	}

	public final void setMovieOpt2(Movie movieOpt2) {
		this.movieOpt2 = movieOpt2;
	}

	public final long getCurrent() {
		return current;
	}

	public final void setCurrent(long current) {
		this.current = current;
	}

	public final List<Movie> getListMovie() {
		return listMovie;
	}

	public final void setListMovie(List<Movie> listMovie) {
		this.listMovie = listMovie;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final List<VoteUser> getListVoteUser() {
		this.session = ActionContext.getContext().getSession();		
		this.listVoteUser = movieRepository.listVoteUser(this.session.get("UUID").toString());
		return this.listVoteUser;
	}
	
}