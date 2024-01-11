package com.mygdx.game.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Model.UsableItem;
import com.mygdx.game.View.EnemyOnScreen;
import com.mygdx.game.View.PlayerOnScreen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class Game extends ApplicationAdapter implements InputProcessor {
	private SpriteBatch batch;
	private Texture background;
	private Texture accueil;
	private Texture bag;
	private Texture caracteristic;
	private Texture lifeAndAttack;
	private String chosenCharacter;
	static boolean playerHasDied = false;
	
	private PlayerController playerController;
	
	private ArrayList <EnemyController>enemiesController = new ArrayList<EnemyController>();
	private ArrayList <ItemController>itemsController = new ArrayList<ItemController>();
	
	private CombatManager combatManager = CombatManager.getInstance();
	private ItemManager itemManager= new ItemManager();
	
	public Game(String chosenCharacter) {
		this.chosenCharacter = chosenCharacter;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		graphicsConfiguration();
		createTextures();
		createPlayer();
		createEnemies();
		createItems();
		createManagers();
	}

	@Override
	public void render () {

		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		
		drawCanvas();
		drawPlayer();
		drawEnemies();
		drawItems();
		checkEndGame();
		combatManagement();
		itemManagement();
		
		
		
		if(Gdx.input.isKeyJustPressed(Keys.A)) {
			System.out.println(playerController.getPlayer().getBag().getItems());
			//playerController.getPlayer().getBag().addItem(new UsableItem("teste"));
			//System.out.println(playerController.getPlayer().getBag().getItems());
		}
		
		
		
		/*

		batch.end();
		*/
		batch.end();
	}
	

	@Override
	public void dispose () {
		/*
		batch.dispose();
		background.dispose();
		accueil.dispose();
		bag.dispose();
		caracteristic.dispose();
		playerController.dispose();
		for(EnemyController enemyController:enemiesController) {
			enemyController.getEnemyOnScreen().dispose();
		}
		combatManager.dispose();
		*/
	}
	
	public void createManagers(){
		combatManager.configureCombatManager(batch,playerController,enemiesController);
		itemManager.configureItemManager(playerController, itemsController);
	}
	
	public void graphicsConfiguration(){
		Gdx.input.setInputProcessor(this);
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.requestRendering();
		Gdx.graphics.setResizable(false);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
	}
	
	public void createTextures() {
		background = new Texture("background.png");
		accueil = new Texture("../assets/accueil.png");
		bag = new Texture("../assets/bag.png");
		caracteristic = new Texture("../assets/caracteristic.png");
		lifeAndAttack = new Texture("../assets/life_attack_image.png");
	}
	
	public void createPlayer() {
		playerController = new PlayerController(batch,chosenCharacter);
	}
	
	public void drawCanvas() {
		float imageWidth = background.getWidth();
		float imageHeight = background.getHeight();
		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;
		batch.draw(background, x, y);
		batch.draw(accueil, 20, 860);
		batch.draw(bag,0,642);
		batch.draw(caracteristic,0,0,213,642);
		batch.draw(lifeAndAttack,1450,800,400,200);
		playerController.getPlayerOnScreen().drawCaracteristics(playerController.getPlayer());
		playerController.getPlayerOnScreen().drawItemsNames(playerController.getPlayer());
	}
	
	
	public void drawPlayer() {
		playerController.getPlayerOnScreen().draw();
	}
	
	public void createEnemies() {
		
		FileReader reader = new FileReader();
		ArrayList<Map<String,Object>> enemies = reader.readPhase01Enemies();

		for(Map<String,Object> enemy:enemies) {
			enemiesController.add(new EnemyController(batch,enemy));	
		}
		
	}
	
	public void drawEnemies() {
		for(EnemyController enemyController:enemiesController) {
			enemyController.getEnemyOnScreen().draw();
		}
		
	}
	
	public void createItems() {
		FileReader reader = new FileReader();
		ArrayList<Map<String,Object>> items = reader.readPhase01Items();

		for(Map<String,Object> item:items) {
			itemsController.add(new ItemController(batch,item));	
		}
	}
	
	public void drawItems(){
		for(ItemController itemController:itemsController) {
			itemController.getItemOnScreen().draw();
		}
	}
	public void combatManagement() {
		combatManager.checkCombat();
	}
	public void itemManagement() {
		itemManager.checkItemCollision();
	}
	
	public static void endGame() {
		playerHasDied = true;
	}
	public void checkEndGame() {
		if(playerHasDied) {
			try {
	            Thread.sleep(3000);
	        } catch (InterruptedException e) {

	            e.printStackTrace();
	        }
			System.exit(0);
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
