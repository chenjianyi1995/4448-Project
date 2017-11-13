package com.roverandfriends.model;



public class Friends {
	
	private int id;

	private String user;

	private String friendName;

	public Friends() {
		super();
	}

	public Friends(int id, String user, String friendName) {
		super();
		this.id = id;
		this.user = user;
		this.friendName = friendName;	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Friends other = (Friends) obj;
		if (id != other.id)
			return false;
		return true;
	}

	

}