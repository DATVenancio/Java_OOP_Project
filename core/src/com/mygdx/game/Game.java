package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture background;
	Texture playerImage;
	Player_game player;

	//Texture enemy01Image;
	//Vector2 enemy01InicialPosition;
	//Enemy enemy01;

	@Override
	public void create () {

		Gdx.input.setInputProcessor(this);
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.requestRendering();

		batch = new SpriteBatch();
		background = new Texture("background.png");
		playerImage = new Texture("perso_forcehomme.png");
		player = new Player_game(playerImage);

		//enemy01Image = new Texture("enemy01_image.png");
		//enemy01InicialPosition = new Vector2(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
		//enemy01 = new Enemy(enemy01InicialPosition,enemy01Image);
		//enemy01.setDefense(3);
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
		player.draw(batch);
		//enemy01.draw(batch);

		//if(player.getSprite().getBoundingRectangle().overlaps(enemy01.getSprite().getBoundingRectangle())) {
		//	player.setPlayerStop(true);
		//	player.fightAgainstEnemy(batch,enemy01.getDefense());
		//}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		playerImage.dispose();
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
		player.playerMovement();
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
