package com.backroombrigade.dcm;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.states.States;
import com.backroombrigade.dcm.states.TestState;

public class EngineMain extends StateBasedGame {

	private static int width = 1280, height = 720;
	private static final String TITLE= "DCM";
	private static AppGameContainer app;
	
	public EngineMain(String name) {
		super(name);
		this.addState(new TestState());
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(States.TEST_STATE.getID()).init(gc, this);
		this.enterState(States.TEST_STATE.getID());
	}

	public static void main(String[] args){
		try {
			app = new AppGameContainer(new EngineMain(TITLE));
			app.setDisplayMode(width, height, false);
			app.setMaximumLogicUpdateInterval(60);
			app.setTargetFrameRate(60);
			app.setAlwaysRender(true);
			app.setUpdateOnlyWhenVisible(false);
			app.setVSync(true);
			app.setShowFPS(false);
			app.start();
		} 
		catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static int getWidth(){
		return width;
	}
	
	public static int getHeight(){
		return height;
	}
	
}
