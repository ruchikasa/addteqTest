package model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	private String username;

	public Users(String username) {
		super();
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + "]";
	}
}
