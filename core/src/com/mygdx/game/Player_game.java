package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player_game extends ElementOnScreen {

	private float playerSpeed = 500;
	private boolean playerStop = false;
	private int playerDiceResult = 0;
	private BitmapFont playerWriteOnScreen;

	public Player_game(Texture image) {
		sprite = new Sprite(image);
		position = new Vector2(1920, Gdx.graphics.getHeight()/2); //(Gdx.graphics.getWidth() / 2, sprite.getScaleY() * sprite.getHeight() / 2);
		sprite.setScale(1.5f);
	}

	public void Update() {
		//if (playerStop == false) {
		playerMovement();
		//} else {
		//	rollDice();
		//}
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

		/*if(Gdx.input.isKeyPressed(Keys.UP)) {
			position.y += Gdx.graphics.getDeltaTime() *playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Keys.DOWN)) {
			position.y -= Gdx.graphics.getDeltaTime() *playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Keys.LEFT)) {
			position.x -= Gdx.graphics.getDeltaTime() *playerSpeed;
		}
		if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
			position.x += Gdx.graphics.getDeltaTime() *playerSpeed;
		}

		checkFieldLimits();*/
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

	/*public void fightAgainstEnemy(SpriteBatch batch, int enemyLife) {
		playerWriteOnScreen = new BitmapFont();
		playerWriteOnScreen.setColor(Color.BLACK);

		playerWriteOnScreen.draw(batch, "Enemy Life: "+enemyLife, 300,450);
		playerWriteOnScreen.draw(batch, "You should get more them "+enemyLife+" in the dice to win", 300,400);
		playerWriteOnScreen.setColor(Color.GREEN);
		playerWriteOnScreen.draw(batch, "Press SPACE to roll the dice", 300,350);
		playerWriteOnScreen.setColor(Color.RED);
		playerWriteOnScreen.draw(batch, "DICE RESULT: ", 300,320);

		if(playerDiceResult>0) {
			playerWriteOnScreen.draw(batch, ""+playerDiceResult, 450,320);

			if(playerDiceResult>enemyLife) {
				playerWriteOnScreen.draw(batch, "YOU WON! ", 450,250);
			}else {
				playerWriteOnScreen.draw(batch, "YOU LOSE! ", 450,250);
			}
		}

	}

	public void rollDice() {
		if(Gdx.input.isKeyPressed(Keys.SPACE)) {
			playerDiceResult=(int)(Math.random() * 6 ) + 1;
		}
	}*/

	public boolean isPlayerStop() {
		return playerStop;
	}

	public void setPlayerStop(boolean playerStop) {
		this.playerStop = playerStop;
	}

}
