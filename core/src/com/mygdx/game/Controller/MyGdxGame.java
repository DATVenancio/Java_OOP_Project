package com.mygdx.game.Controller;

import com.badlogic.gdx.ApplicationAdapter;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.View.Menu;



//Classe initiale de la structure du fichier. Le projet initialise la classe et il se charge de démarrer le menu qui lancera plus tard le jeu
public class MyGdxGame extends ApplicationAdapter {
	private Menu menu;

	@Override
	public void create() {
		Gdx.graphics.setResizable(false);
		menu = new Menu();


	}

	@Override
	public void render() {
		ScreenUtils.clear(0, 0, 0, 1);
		OrthographicCamera camera = new OrthographicCamera();
		Viewport viewport = new FitViewport(1920,1080, camera);


		viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), true);
		menu.render();
	}

	@Override
	public void resize(int width, int height) {
		
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
