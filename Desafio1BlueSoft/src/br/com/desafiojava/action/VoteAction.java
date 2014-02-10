package br.com.desafiojava.action;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.opensymphony.xwork2.ActionContext;

import br.com.desafiojava.model.Movie;
import br.com.desafiojava.repository.MovieRepository;

@Namespace("/Vote")
public class VoteAction extends ActionDefault {

	private MovieRepository movieRepository = new MovieRepository(this.getEntityManager());
	private Movie movieOpt1;
	private Movie movieOpt2;
	private List<Movie> listMovie = movieRepository.listMovie(); 
	private long current;
	private String name;
	private String email;
	
	public Map<String, Object> session;
	
	private Movie randomMovie(){
		Random Randomizer = new Random(); 
		Movie random = listMovie.get(Randomizer.nextInt(listMovie.size()));
		return random;
	}
	
	private void random(){
		
		Map<String, Object> session = ActionContext.getContext().getSession();
	
		if(session.size() == 0)
		{
			do
			{
				movieOpt1 = randomMovie();
				movieOpt2 = randomMovie();
			}
			while(movieOpt2.getId() == movieOpt1.getId());
			
			session.put("movieOpt1", movieOpt1);
			session.put("movieOpt2", movieOpt2);
			
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
			
			session.remove("movieOpt1");
			session.remove("movieOpt2");
			
			session.put("movieOpt1", movieOpt1);
			session.put("movieOpt2", movieOpt2);
		}
		
	}
	
	@Action(value="createVote", results={
			@Result(name ="ok", location="/voto.jsp")
			})
	public String Vote(){
		movieRepository.voteMovie(this.current);
		this.random();
		return "ok";
	}
	
	@Action(value="pageVote", results=@Result(name ="ok", location="/voto.jsp"  ))
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
	
}