package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class QuitGame implements Command {
	private Game game;
	public QuitGame(Game game) {
		this.game = game;
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		if (Gdx.input.isKeyPressed(Keys.ESCAPE)) {
			System.exit(0);
		}
	}

}
