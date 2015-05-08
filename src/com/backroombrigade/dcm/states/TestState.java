package com.backroombrigade.dcm.states;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.gameobjects.Enemy;
import com.backroombrigade.dcm.gameobjects.ObjectIDs;
import com.backroombrigade.dcm.gameobjects.ObjectTags;
import com.backroombrigade.dcm.gameobjects.Player;
import com.backroombrigade.dcm.utils.Camera;
import com.backroombrigade.dcm.utils.ObjectHandler;

public class TestState extends BasicGameState {
	
	ObjectHandler objectHandler;
	Camera camera;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		objectHandler = new ObjectHandler();
		objectHandler.add(new Player(100, 100, 64, 64, ObjectIDs.PLAYER_ID.getID(), ObjectTags.PLAYER_TAG.getTag(), gc, sbg, gc.getGraphics(), objectHandler, 0));
		objectHandler.add(new Enemy(25, 25, 64, 64, ObjectIDs.ENEMY_ID.getID(), ObjectTags.ENEMY_TAG.getTag(), gc, sbg, gc.getGraphics(), objectHandler, 0));
		camera = new Camera(0, 0);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawString("TEST STATE", 50, 50);
		
		g.translate(camera.getX(), camera.getY());
		{	
			objectHandler.render();
		}
		g.translate(-camera.getX(), -camera.getY());
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		objectHandler.update(delta);
		
		camera.update(objectHandler.getByTag("Player"));
	}

	@Override
	public int getID() {
		return States.TEST_STATE.getID();	
	}

}
