package com.mygdx.game.View;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Model.Item;
import com.mygdx.game.Model.Player;

public class PlayerOnScreen extends ElementOnScreen {
	
	
	private float playerSpeed = 200;
	private boolean playerFreeze = false;
	private SpriteBatch batch;
	private boolean isFlipped=false;
	private BitmapFont font = new BitmapFont();



	public PlayerOnScreen(SpriteBatch batch) {
		this.batch = batch;
		position = new Vector2(1920, Gdx.graphics.getHeight()/2); //(Gdx.graphics.getWidth() / 2, sprite.getScaleY() * sprite.getHeight() / 2);
		//sprite.setScale(1.0f);
	}

	public void Update() {
		
		
		if(!playerFreeze) playerMovement();

	}

	public void draw() {
		Update();
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
	}
	public void dispose() {
		
		batch.dispose();
	}

	
	public void playerMovement() {

		float deltaTime = Gdx.graphics.getDeltaTime();
		float speed = playerSpeed * deltaTime;

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			position.y += speed;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			position.y -= speed;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			position.x -= speed;
			turnLeft();
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			position.x += speed;
			turnRight();
		}

		checkFieldLimits();
	}
	public void turnLeft() {
		if(!isFlipped) {
			sprite.flip(true, false);
			isFlipped=true;
		}
	}
	
	public void turnRight() {
		if(isFlipped) {
			sprite.flip(true, false);
			isFlipped=false;
		}
	}
	
	
	public void checkFieldLimits() {
		checkLeftLimit();
		checkRightLimit();
		checkDownLimit();
		checkTopLimit();
	}
	public void checkLeftLimit() {
		if(position.x<=0) {
			position.x=0;
		}
	}
	public void checkDownLimit() {
		if(position.y<=0) {
			position.y=0;
		}
	}
	public void checkRightLimit() {
		if(position.x>=Gdx.graphics.getWidth()-sprite.getWidth()*sprite.getScaleX()) {
			position.x=Gdx.graphics.getWidth()-sprite.getWidth()*sprite.getScaleX();
		}
	}
	public void checkTopLimit() {
		if(position.y>=Gdx.graphics.getHeight()-sprite.getHeight()*sprite.getScaleY()) {
			position.y=Gdx.graphics.getHeight()-sprite.getHeight()*sprite.getScaleY();
		}
	}

	public void drawCaracteristics(Player player) {
		font.draw(batch, String.valueOf(player.getStregth()), 1375, 75);
		font.draw(batch, String.valueOf(player.getIntelligence()), 1478, 75);
		font.draw(batch, String.valueOf(player.getWisdom()), 1586, 75);
		font.draw(batch, String.valueOf(player.getRuse()), 1694, 75);
		font.draw(batch, String.valueOf(player.getStregth()), 1800, 75);
		
		font.draw(batch, String.valueOf(player.getLife()), 1500,900);
		font.draw(batch, String.valueOf(player.getAttackBonus()), 1700,900);
		
	}
	public void drawItemsNames(Player player) {
		ArrayList<Item> items = player.getBag().getItems();
		if(items.size()>0) {
			font.setColor(Color.BLACK);
			int initialY = 240;
			for (Item item:items) {
				font.draw(batch,item.getName(), 45, initialY);
				initialY-=20;
			}
			
			font.setColor(Color.WHITE);
		}
		
		


		
		
		font.draw(batch, String.valueOf(player.getLife()), 1500,900);
		font.draw(batch, String.valueOf(player.getAttackBonus()), 1700,900);
		
	}


	public boolean isPlayerFreeze() {
		return playerFreeze;
	}

	public void setPlayerFreeze(boolean playerStop) {
		this.playerFreeze = playerStop;
	}

	
	
}
