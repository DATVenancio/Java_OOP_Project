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
	private long startTime;
	private boolean showMenu1 = true;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		menu1Texture = new Texture("menu1.jpg");
		menu2Texture = new Texture("menu2.jpg");
		startTime = TimeUtils.millis();
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
