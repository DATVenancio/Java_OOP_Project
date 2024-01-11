package com.mygdx.game.Controller;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.View.EnemyOnScreen;
import com.mygdx.game.View.PlayerOnScreen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;
	Texture background;
	Texture accueil;
	Texture bag;
	Texture caracteristic;
	String chosenCharacter;
	
	
	PlayerController playerController;

	
	ArrayList <EnemyController>enemiesController = new ArrayList<EnemyController>();
	
	
	CombatManager combatManager = CombatManager.getInstance();
	
	
	
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
		accueil = new Texture("accueil.png");
		bag = new Texture("bag.png");
		caracteristic = new Texture("caracteristic.png");
		
		createPlayer();
		createEnemies();
		combatManager.configureCombatManager(playerController,enemiesController);

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
		batch.draw(accueil, 20, 860);
		batch.draw(bag,1600,800);
		batch.draw(caracteristic,1750,10);

		drawPlayer();
		drawEnemies();
		combatManagement();
		

		batch.end();
	}

	public void combatManagement() {
		combatManager.checkCombat();
	}

	
	public void drawPlayer() {
		playerController.getPlayerOnScreen().draw();
	}
	
	public void drawEnemies() {
		for(EnemyController enemyController:enemiesController) {
			enemyController.getEnemyOnScreen().draw();
		}
		
	}

	public void createPlayer() {
		playerController = new PlayerController(batch,chosenCharacter);
	}
	
	public void createEnemies() {
		enemiesController.add(new EnemyController(batch,"geant_nain.png",new Vector2(1100,800)));
		enemiesController.add(new EnemyController(batch,"griffon_harpie.png",new Vector2(1300,100)));
		enemiesController.add(new EnemyController(batch,"kraken_sirene.png",new Vector2(600,100)));
		enemiesController.add(new EnemyController(batch,"loup_elfe.png",new Vector2(600,800)));
		enemiesController.add(new EnemyController(batch,"serpent_dragon.png",new Vector2(400,420)));
	}

	@Override
	public void dispose () {
		if (batch != null) {
			batch.dispose();
			batch = null; // Optionnel : marquer comme null après libération
		}

		if (background != null) {
			background.dispose();
			background = null; // Optionnel : marquer comme null après libération
		}

		if (accueil != null) {
			accueil.dispose();
			accueil = null; // Optionnel : marquer comme null après libération
		}

		if (bag != null) {
			bag.dispose();
			bag = null; // Optionnel : marquer comme null après libération
		}

		if (caracteristic != null) {
			caracteristic.dispose();
			caracteristic = null; // Optionnel : marquer comme null après libération
		}
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
