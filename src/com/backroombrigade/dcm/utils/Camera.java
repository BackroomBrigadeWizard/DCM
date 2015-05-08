package com.backroombrigade.dcm.utils;

import com.backroombrigade.dcm.EngineMain;
import com.backroombrigade.dcm.gameobjects.GameObject;

public class Camera {

	private float x, y;
	
	public Camera(float x, float y){
		this.x = x;
		this.y = y;
	}
	
	public void update(GameObject target){
		x = -target.getX() + EngineMain.getWidth() / 2;
		y = -target.getY() + EngineMain.getHeight() / 2;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}
