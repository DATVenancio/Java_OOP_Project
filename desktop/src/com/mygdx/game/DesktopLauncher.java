package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.Controller.MyGdxGame;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		/*float imageWidth = 1920;
		float imageHeight = 1080;

		float xFloat = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float yFloat = (Gdx.graphics.getHeight() - imageHeight) / 2;

		int x = Math.round(xFloat);
		int y = Math.round(yFloat);*/

		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setTitle("Le Royaume d'Oraculum");
		config.setWindowedMode(1920, 1000);  // Taille initiale de la fenêtre

		new Lwjgl3Application(new MyGdxGame(), config);
	}
}