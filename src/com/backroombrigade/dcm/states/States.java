package com.backroombrigade.dcm.states;

public enum States {

	SPASH_SCREEN(0),
	MAIN_MENU_STATE(1),
	TEST_STATE(100);
	
	private int id;
	
	private States(int id){
		this.id = id;
	}
	
	public int getID(){
		return id;
	}
	
}
