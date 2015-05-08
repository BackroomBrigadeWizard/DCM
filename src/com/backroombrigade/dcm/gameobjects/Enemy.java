package com.backroombrigade.dcm.gameobjects;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.StateBasedGame;

import com.backroombrigade.dcm.utils.ObjectHandler;

public class Enemy extends Mob {

	protected Circle detectCircle;
	
	public Enemy(float x, float y, float width, float height, int id, String tag, GameContainer gc, StateBasedGame sbg, Graphics g, ObjectHandler objectHandler, int face) {
		super(x, y, width, height, id, tag, gc, sbg, g, objectHandler, face);
		setHealth(150);
		setMana(100);
		detectCircle = new Circle(x + 25, y + 25, 100);
	}

	@Override
	public void render() {
		g.setColor(Color.green);
		g.fillRoundRect(x, y, width, height, 5);
		g.setColor(Color.cyan);
		g.draw(detectCircle);
		
		g.drawString(health + "HP\n" + mana + "MP", x + 5, y - height + 5);
	}

	@Override
	public void update(int delta) {
		
		if(health <= 0){
			setAlive(false);
		}
		
		x += velX;
		y += velY;

		velX = 0;
		velY = 0;
		
		enemyCollsion();
		
		detectCircle.setCenterX(x + 25);
		detectCircle.setCenterY(y + 25);
	}

	private void enemyCollsion(){

		for(GameObject gameObject : objectHandler.getList()){
			
			if(gameObject.getTag().equalsIgnoreCase("player")){
				Player player = (Player)(gameObject);

				if(detectCircle.intersects(player.getWholeBounds())){
					if(getX() > player.getX()){
						//velX = -1;
						setX(getX() - 1);
					}
					
					if(getX() > player.getX()){
						//velX = 1;
						setX(getX() + 1);
					}
					
					if(getY() > player.getY()){
						//velY = 1;
						setY(getY() - 1);
					}
					
					if(getY() < player.getY()){
						//velY = -1;
						setY(getY() + 1);
					}
				}
				
				if(getBottemBounds().intersects(gameObject.getWholeBounds())){
					velY = 0;
					y = gameObject.getY() - gameObject.getHeight();
					player.modHealth(-1);
				}
				else if(getTopBounds().intersects(gameObject.getWholeBounds())){
					velY = 1;
					y = gameObject.getY() + gameObject.getHeight();
					player.modHealth(-1);
				}
				else if(getLeftBounds().intersects(gameObject.getWholeBounds())){
					velX = 0;
					x = gameObject.getX() + gameObject.getWidth();
					player.modHealth(-1);
				}
				else if(getRightBounds().intersects(gameObject.getWholeBounds())){
					velX = 0;
					x = gameObject.getX() - gameObject.getWidth();
					player.modHealth(-1);
				}
			}

		}
	}
}