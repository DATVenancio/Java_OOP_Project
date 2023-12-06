package com.mygdx.game.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Model.Player;

public class PlayerOnScreen extends ElementOnScreen {
	
	
	private float playerSpeed = 200;
	private boolean playerStop = false;
	SpriteBatch batch;



	public PlayerOnScreen(SpriteBatch batch) {
		this.batch = batch;
		position = new Vector2(1920, Gdx.graphics.getHeight()/2); //(Gdx.graphics.getWidth() / 2, sprite.getScaleY() * sprite.getHeight() / 2);
		//sprite.setScale(1.0f);
	}

	public void Update() {

		playerMovement();

	}

	public void draw(SpriteBatch batch) {
		Update();
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
	}

	
	public void playerMovement() {
		float FIXED_DELTA_TIME = 1/20.0f;
		float speed = playerSpeed * FIXED_DELTA_TIME;
		//float deltaTime = Gdx.graphics.getDeltaTime();
		//float speed = playerSpeed * deltaTime;

		if (Gdx.input.isKeyPressed(Keys.UP)) {
			position.y += speed;
		}
		if (Gdx.input.isKeyPressed(Keys.DOWN)) {
			position.y -= speed;
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			position.x -= speed;
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			position.x += speed;
		}

		checkFieldLimits();
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



	public boolean isPlayerStop() {
		return playerStop;
	}

	public void setPlayerStop(boolean playerStop) {
		this.playerStop = playerStop;
	}

}
