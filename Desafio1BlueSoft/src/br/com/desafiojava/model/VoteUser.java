package br.com.desafiojava.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import br.com.desafiojava.model.pk.VoteUserId;

@Entity
public class VoteUser  implements Serializable {
	
	private static final long serialVersionUID = -8957440229738353544L;

	@EmbeddedId
	private VoteUserId voteUserId;
		
	private int points;
	
	public final VoteUserId getVoteUserId() {
		return voteUserId;
	}

	public final void setVoteUserId(VoteUserId voteUserId) {
		this.voteUserId = voteUserId;
	}

	public final int getPoints() {
		return points;
	}
	
	public final void setPoints(int points) {
		this.points = points;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + points;
		result = prime * result
				+ ((voteUserId == null) ? 0 : voteUserId.hashCode());
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
		if (!(obj instanceof VoteUser)) {
			return false;
		}
		VoteUser other = (VoteUser) obj;
		if (points != other.points) {
			return false;
		}
		if (voteUserId == null) {
			if (other.voteUserId != null) {
				return false;
			}
		} else if (!voteUserId.equals(other.voteUserId)) {
			return false;
		}
		return true;
	}
}