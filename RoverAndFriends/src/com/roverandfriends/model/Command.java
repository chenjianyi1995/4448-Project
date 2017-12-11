package com.roverandfriends.model;

public interface Command {
	public void execute();
	public void undo();
}
