package com.mygdx.game.Controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.View.PlayerOnScreen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture background;
	String chosenCharacter;
	PlayerOnScreen playerOnScreen;
	PlayerController playerController;

	
	
	public Game(String chosenCharacter) {
		this.chosenCharacter = chosenCharacter;
	}
	
	@Override
	public void create () {

		Gdx.input.setInputProcessor(this);
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.requestRendering();

		batch = new SpriteBatch();
		background = new Texture("background.png");
		
		
		
		
		playerOnScreen = new PlayerOnScreen(batch);
		playerController = new PlayerController();
		playerController.setPlayerOnScreen(playerOnScreen);
		playerController.chooseCharacter(chosenCharacter);

	}

	@Override
	public void render () {

		float imageWidth = background.getWidth();
		float imageHeight = background.getHeight();

		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		batch.draw(background, x, y);
		playerOnScreen.draw(batch);


		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();

	}

	@Override
	public boolean keyDown(int keycode) {
		handleInput(keycode, true);
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		handleInput(keycode, false);
		return true;
	}

	private void handleInput(int keycode, boolean isKeyPressed) {
		// Appel à la méthode playerMovement du joueur avec la touche et l'état de pression
		//playerOnScreen.playerMovement();
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchCancelled(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}

	
}
