package com.roverandfriends.model;

public class ExecuteCommand {
	Command theCommand;
	public ExecuteCommand(Command newCommand) {
		theCommand = newCommand;
	}
	
	public void E_excute() {
		theCommand.execute();
	}
	
	public void E_undo() {
		theCommand.undo();
	}
}
