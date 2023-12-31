package com.mygdx.game.Controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.View.Menu_alternative;

public class MyGdxGame extends ApplicationAdapter {
	private Menu_alternative menu;

	@Override
	public void create() {
		menu = new Menu_alternative();
	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		menu.render();
	}

	@Override
	public void resize(int width, int height) {
		//menu.resize();
	}

	@Override
	public void pause() {
		//menu.pause();
	}

	@Override
	public void resume() {
		//menu.resume();
	}

	@Override
	public void dispose() {
		menu.dispose();
	}
}
