package com.backroombrigade.dcm.gameobjects;

public enum ObjectIDs {

	PLAYER_ID(0),
	ENEMY_ID(4);
	
	private int id;
	
	private ObjectIDs(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
}
