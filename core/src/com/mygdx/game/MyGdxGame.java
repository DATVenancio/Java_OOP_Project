package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture menu1Texture;
	private Texture menu2Texture;
	private Texture menu3Texture;
	private long startTime;
	private boolean showMenu1 = true;
	private MyGameInputProcessor inputProcessor; // Ajout de l'instance de MyInputProcessor
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menu1Texture = new Texture("menu1.jpg");
		menu2Texture = new Texture("menu2.jpg");
		menu3Texture = new Texture("menu3.jpg");
		startTime = TimeUtils.millis();

		// Initialisation de l'instance de MyInputProcessor
		inputProcessor = new MyGameInputProcessor() {

			@Override
			protected void afficherMenu3() {
				showMenu1 = false;

				float imageWidth = menu3Texture.getWidth();
				float imageHeight = menu3Texture.getHeight();

				float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
				float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

				batch.draw(menu3Texture, x, y);
			}

			@Override
			public boolean keyDown(int keycode) {
				return false;
			}

			@Override
			public boolean keyUp(int keycode) {
				return false;
			}

			@Override
			public boolean keyTyped(char character) {
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
		};
		Gdx.input.setInputProcessor(inputProcessor);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();

		float imageWidth = menu1Texture.getWidth();
		float imageHeight = menu1Texture.getHeight();

		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;

		long currentTime = TimeUtils.millis();
		long elapsedTime = currentTime - startTime;

		if (showMenu1 && elapsedTime < 5000) {
			batch.draw(menu1Texture, x, y);
		} else {
			showMenu1 = false;
			batch.draw(menu2Texture, x, y);
		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		menu1Texture.dispose();
		menu2Texture.dispose();
	}
}
