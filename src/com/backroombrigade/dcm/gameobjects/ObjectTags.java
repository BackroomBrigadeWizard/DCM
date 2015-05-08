package com.backroombrigade.dcm.gameobjects;

public enum ObjectTags {

	PLAYER_TAG("Player"),
	ENEMY_TAG("Enemy");
	
	private String tag;
	
	private ObjectTags(String tag){
		this.tag = tag;
	}
	
	public String getTag(){
		return tag;
	}
	
}
