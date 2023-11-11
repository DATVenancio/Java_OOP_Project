package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.TimeUtils;

public class MyGdxGame extends ApplicationAdapter {
	private Menu menu;

	@Override
	public void create() {
		menu = new Menu();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		menu.render();
	}

	@Override
	public void resize(int width, int height) {
		menu.resize(width, height);
	}

	@Override
	public void pause() {
		menu.pause();
	}

	@Override
	public void resume() {
		menu.resume();
	}

	@Override
	public void dispose() {
		menu.dispose();
	}
}
