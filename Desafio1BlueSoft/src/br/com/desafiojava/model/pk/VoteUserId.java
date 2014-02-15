package br.com.desafiojava.model.pk;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.desafiojava.model.Movie;

@Embeddable
public class VoteUserId implements Serializable {
	
   private static final long serialVersionUID = 1684508547840147866L;
	
    private String chaveUser;

	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name="movieId")
	private Movie movieId;
   
   public VoteUserId() {}
   
   public VoteUserId(String chaveUser, Movie movieId) {
	   this.chaveUser = chaveUser;
	   this.movieId = movieId;
   }

	public final String getChaveUser() {
		return chaveUser;
	}
	
	public final void setChaveUser(String chaveUser) {
		this.chaveUser = chaveUser;
	}

	public final Movie getMovieId() {
		return movieId;
	}

	public final void setMovieId(Movie movieId) {
		this.movieId = movieId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((chaveUser == null) ? 0 : chaveUser.hashCode());
		result = prime * result + ((movieId == null) ? 0 : movieId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof VoteUserId)) {
			return false;
		}
		VoteUserId other = (VoteUserId) obj;
		if (chaveUser == null) {
			if (other.chaveUser != null) {
				return false;
			}
		} else if (!chaveUser.equals(other.chaveUser)) {
			return false;
		}
		if (movieId != other.movieId) {
			return false;
		}
		return true;
	}   
}