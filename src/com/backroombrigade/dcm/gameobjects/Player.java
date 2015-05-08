package com.backroombrigade.dcm.gameobjects;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.utils.ObjectHandler;

public class Player extends Mob{

	private Input input;

	public Player(float x, float y, float width, float height, int id, String tag, GameContainer gc, StateBasedGame sbg, Graphics g, ObjectHandler objectHandler, int face) {
		super(x, y, width, height, id, tag, gc, sbg, g, objectHandler, face);
		input = gc.getInput();
		setHealth(150);
		setMana(100);
	}

	@Override
	public void render() {
		g.setColor(Color.red);
		g.drawRect(x, y, width, height);

		g.drawString(health + "HP\n" + mana + "MP", x + 5, y - height + 5);
	}

	@Override
	public void update(int delta) {
		move();
		collsion();

		x += velX;
		y += velY;

		velX = 0;
		velY = 0;
		
		if(health <= 0){
			setAlive(false);
		}
	}

	private void collsion(){
		for(GameObject object : objectHandler.getList()){
			if(object.getTag().equalsIgnoreCase("Enemy")){
				Enemy enemy = (Enemy)(object);
				
				if(getBottemBounds().intersects(object.getWholeBounds())){
					velY = 1;
					y = object.getY() - object.getHeight();
					if(input.isKeyPressed(Input.KEY_ENTER)){
						enemy.modHealth(-5);
					}
				}
				else if(getTopBounds().intersects(object.getWholeBounds())){
					velY = 1;
					y = object.getY() + object.getHeight();
					if(input.isKeyPressed(Input.KEY_ENTER)){
						enemy.modHealth(-5);
					}
				}
				else if(getLeftBounds().intersects(object.getWholeBounds())){
					x = object.getX() + object.getWidth();
					if(input.isKeyPressed(Input.KEY_ENTER)){
						enemy.modHealth(-5);
					}
				}
				else if(getRightBounds().intersects(object.getWholeBounds())){
					x = object.getX() - object.getWidth();
					if(input.isKeyPressed(Input.KEY_ENTER)){
						enemy.modHealth(-5);
					}
				}
			}
		}
	}
	
	private void move(){
		if(input.isKeyDown(Input.KEY_W)){
			velY = - 2.5f;
		}
		if(input.isKeyDown(Input.KEY_A)){
			velX = - 2.5f;
		}
		if(input.isKeyDown(Input.KEY_S)){
			velY = 2.5f;
		}
		if(input.isKeyDown(Input.KEY_D)){
			velX = 2.5f;
		}
	}

}
