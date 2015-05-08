package com.backroombrigade.dcm.gameobjects;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.utils.ObjectHandler;

public abstract class GameObject {

	protected float x, y, width, height;
	protected boolean alive;
	protected int id;
	protected String tag;
	protected GameContainer gc;
	protected StateBasedGame sbg;
	protected Graphics g;
	protected ObjectHandler objectHandler;
	
	public GameObject(float x, float y, float width, float height, int id, String tag, GameContainer gc, StateBasedGame sbg, Graphics g, ObjectHandler objectHandler){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.id = id;
		this.tag = tag;
		this.gc = gc;
		this.sbg = sbg;
		this.g = g;
		this.objectHandler = objectHandler;
		
		alive = true;
	}
	
	public abstract void render();
	public abstract void update(int delta);
	
	public void setX(float x){
		this.x = x;
	}
	
	public void setY(float y){
		this.y = y;
	}
	
	public void setAlive(boolean alive){
		this.alive = alive;
	}
	
	public float getX(){
		return x;
	}
	
	public float getY(){
		return y;
	}
	
	public float getWidth(){
		return width;
	}
	
	public float getHeight(){
		return height;
	}
	
	public boolean getAlive(){
		return alive;
	}
	
	public int getID(){
		return id;
	}
	
	public String getTag(){
		return tag;
	}
	
	public GameContainer getGC(){
		return gc;
	}
	
	public StateBasedGame getSBG(){
		return sbg;
	}
	
	public Graphics getG(){
		return g;
	}
	
	public ObjectHandler getObjectHandler(){
		return objectHandler;
	}
	
	public Rectangle getWholeBounds(){
		return new Rectangle(x, y, width, height);
	}
	
	public Rectangle getTopBounds(){
		return new Rectangle((x + width / 2) - width / 4, y, width / 2, height / 2);
	}
	
	public Rectangle getLeftBounds(){
		return new Rectangle(x, (y + height / 1.2f) - height / 1.35f, width / 4, height / 1.2f);
	}
	
	public Rectangle getBottemBounds(){
		return new Rectangle((x + width / 2) - width / 4, y + height - height / 2, width / 2, height / 2);
	}
	
	public Rectangle getRightBounds(){
		return new Rectangle((x + width) - width / 4, (y + height / 1.2f) - height / 1.35f, width / 4, height / 1.2f);
	}
	
}
