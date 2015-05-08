package com.backroombrigade.dcm.gameobjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.utils.ObjectHandler;

public abstract class Mob extends GameObject {

	protected int face;
	protected float velX, velY;
	protected int health, mana;
	
	public Mob(float x, float y, float width, float height, int id, String tag, GameContainer gc, StateBasedGame sbg, Graphics g, ObjectHandler objectHandler, int face) {
		super(x, y, width, height, id, tag, gc, sbg, g, objectHandler);
		this.face = face;
		velX = 0;
		velY = 0;
	}
	
	public abstract void render();
	public abstract void update(int delta);
	
	public void setFace(int face){
		this.face = face;
	}
	
	public int getFace(){
		return face;
	}
	
	public void setVelX(float velX){
		this.velX = velX;
	}
	
	public float getVelX(){
		return velX;
	}
	
	public void setVelY(float velY){
		this.velY = velY;
	}
	
	public float getVelY(){
		return velY;
	}
	
	public void setHealth(int health){
		this.health = health;
	}
	
	public int getHealth(){
		return health;
	}
	
	public void setMana(int mana){
		this.mana = mana;
	}
	
	public int getMana(){
		return mana;
	}
	
	public void modHealth(int amount){
		health += amount;
	}
	
	public void modMana(int amount){
		mana += amount;
	}

}
