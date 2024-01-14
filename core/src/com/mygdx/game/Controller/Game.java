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

public class Game extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture background;
	private Texture accueil;
	private Texture bag;
	private Texture caracteristic;
	private Texture lifeAndAttack;
	private String chosenCharacter;
	static boolean playerHasDied = false;
	static boolean playerWon=false;
	private boolean isPaused = false;
	
	private PlayerController playerController;
	
	private ArrayList <EnemyController>enemiesController = new ArrayList<EnemyController>();
	
	private CombatManager combatManager = CombatManager.getInstance();
	private ItemManager itemManager= new ItemManager();
	
	private ArrayList<Command> commands = new ArrayList<Command>();
	
	
	public Game(String chosenCharacter) {
		this.chosenCharacter = chosenCharacter;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		graphicsConfiguration();
		
		createPlayer();
		createManagers();
		createTextures();
		createEnemies();
		itemManager.createItems();
		
		
		createCommands();
	}

	@Override
	public void render () {
		
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		
		drawCanvas();
		drawPlayer();
		drawEnemies();
		
		checkEndGame();
		
		combatManagement();
		itemManagement();
		checkPlayerWin();
		
		
		if(itemManager.allRelicsCollected() && combatManager.allEnemiesDied()) {
			System.out.println("oi");
			combatManager.getCombatManagerOnScreen().showWinGameImage();
		}
		
		batch.end();
		
		checkCommands();
		
	}
	

	@Override
	public void dispose () {
		
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
		
	}
	
	private void createCommands() {
		commands.add(new PauseGame(this));
		commands.add(new QuitGame(this));
	}
	private void checkCommands() {
		for(Command command:commands) {
			command.execute();
		}
	}
	
	public void createManagers(){
		combatManager.configureCombatManager(batch,playerController,enemiesController);
		itemManager.configureItemManager(batch,playerController);
	}
	
	public void graphicsConfiguration(){
		Gdx.graphics.setContinuousRendering(true);
		Gdx.graphics.requestRendering();
		Gdx.graphics.setResizable(false);
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
	}
	
	public void createTextures() {
		background = new Texture("background.png");
		accueil = new Texture("../../bin/main/accueil.png");
		bag = new Texture("../../bin/main/bag.png");
		caracteristic = new Texture("../../bin/main/caracteristic.png");
		lifeAndAttack = new Texture("../../bin/main/life_attack_image.png");
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
		batch.draw(accueil, 20, 900);
		batch.draw(bag,0,0);
		batch.draw(caracteristic,1300,0,600,223);
		batch.draw(lifeAndAttack,1425,800,400,200);
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
	
	public void combatManagement() {
		combatManager.checkCombat();
	}
	public void itemManagement() {
		itemManager.checkItemCollision();
		itemManager.drawItems();
	}
	
	public static void endGame() {
		playerHasDied = true;
	}
	public void checkEndGame() {
		if(playerHasDied) {
			try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {

	            e.printStackTrace();
	        }
			System.exit(0);
		}else if(playerWon) {
			
			try {
	            Thread.sleep(10000);
	        } catch (InterruptedException e) {

	            e.printStackTrace();
	        }
			System.exit(0);
		}
	}
	private boolean checkPlayerWin() {
		if(itemManager.allRelicsCollected() && combatManager.allEnemiesDied()){
			System.out.println("finalise");
			combatManager.setPlayerHasWon(true);
			playerWon=true;
			return true;
		}
		return false;

	}

	
	
	
	public boolean isPlayerWon() {
		return playerWon;
	}

	public void setPlayerWon(boolean playerWon) {
		this.playerWon = playerWon;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public PlayerController getPlayerController() {
		return playerController;
	}

	
	
}
