 package com.mygdx.game.Controller;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Dice;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.Player;
import com.mygdx.game.View.CombatManagerVisual;

public class CombatManager extends ApplicationAdapter implements InputProcessor {
	
	private static CombatManager instance;
	private CombatManagerVisual combatManagerOnScreen = new CombatManagerVisual();
	private PlayerController playerController;
	private EnemyController currentEnemy;
	private ArrayList<EnemyController> enemiesController;
	private Dice dice6Sides = new Dice(6);
	
	
	private boolean inCombat=false;
	private boolean enemyHasDied = false;
	private boolean playerHasDied = false;
	private boolean playerHasWon = false;

	

	private CombatManager() {};
	
	public static CombatManager getInstance() {
		if(instance == null) {
			instance = new CombatManager();
		}
		return instance;
	}

	public void configureCombatManager(SpriteBatch batch,PlayerController playerController, ArrayList<EnemyController> enemiesController)
	{
		this.combatManagerOnScreen.setBatch(batch);
		this.playerController=playerController;
		this.enemiesController=enemiesController;
	}
	public void checkCombat() {
		
		if(playerHasWon) {
			combatManagerOnScreen.showDiceResult(3);
		}

		if(!playerHasDied()) {
			playerWon();
			checkEnemyHasDied();
			checkEnemyCollision();
			if(inCombat) {
				checkDiceRoll();
				checkCurrentEnemyLifeState();
				checkPlayerLifeState();
				checkPlayerWon();
				
			}
		}
		
	}
	public void playerWon() {
		if(playerHasWon) {
			waitInMilisec(3000);
			combatManagerOnScreen.showWinGameImage();
		}
	}
	public boolean playerHasDied() {
		if(playerHasDied) {
			waitInMilisec(6000);
			combatManagerOnScreen.showLoseGameImage();
			Game.endGame();
			return true;
		}
		return false;
	}
	public void checkEnemyHasDied() {
		if(enemyHasDied) {
			waitInMilisec(3000);
			setInitialCombatConfiguration();
			playerController.unfreezePlayer();
			enemyHasDied=false;
		}
	}
	public void checkEnemyCollision() {
		for(EnemyController enemyController:enemiesController) {
			if(combatManagerOnScreen.playerColidesWithEnemy(playerController.getPlayerOnScreen(),enemyController.getEnemyOnScreen())) {
				combatManagerOnScreen.showBattleImage(playerController.getPlayer(),enemyController.getEnemy());
				playerController.freezePlayer();
				inCombat=true;
				currentEnemy=enemyController;
			}		
		}
	}

	public void checkCurrentEnemyLifeState() {
		if(currentEnemy.getEnemy().getLife()<=0) {
			reloadBattleImage();
			killCurrentEnemy();
		}
	}
	
	public void checkPlayerLifeState() {
		if(playerController.getPlayer().getLife()<=0) {
			reloadBattleImage();
			playerHasDied=true;
		}
	}
	public void checkPlayerWon() {
		if(allEnemiesDied()  && ItemManager.allRelicsCollected() ) {
			reloadBattleImage();
			playerHasWon=true;
		}
	}
	
	public void reloadBattleImage() {
		combatManagerOnScreen.showBattleImage(playerController.getPlayer(),currentEnemy.getEnemy());
		
	}
	public void killCurrentEnemy() {
		enemiesController.remove(currentEnemy);
		currentEnemy.dispose();
		enemyHasDied=true;
		
	}

	public void setInitialCombatConfiguration() {
		combatManagerOnScreen.restartDiceResult();
		inCombat=false;
	}
	public void dispose() {
		// pour la libération mémoire
		
	}
	
	public void checkDiceRoll() {
		int diceResult=0;
		if(Gdx.input.isKeyJustPressed(Keys.SPACE)) {
			diceResult = dice6Sides.rollDice();
			combatManagerOnScreen.showDiceResult(diceResult);
			createTurn(diceResult);
		}

	}
	
	
	public boolean createTurn(int diceResult) {
		
		hurtEnemy(diceResult);
		if(currentEnemy.getEnemy().isAlive()) {
			hurtPlayer();
		}
		
		return true;
	}
	
	public void hurtEnemy(int diceResult) {
		int enemyLife = currentEnemy.getEnemy().getLife();
		int playerAttack = playerController.getPlayer().getAttackBonus() + diceResult;
		currentEnemy.getEnemy().setLife(enemyLife-playerAttack);
		
	}
	public void hurtPlayer() {
		int playerLife = playerController.getPlayer().getLife();
		int enemyAttack = currentEnemy.getEnemy().getAttack();
		playerController.getPlayer().setLife(playerLife-enemyAttack);
	}
	public boolean allEnemiesDied() {
		for(EnemyController enemyController:enemiesController) {
			if(enemyController.getEnemy().isAlive()) {
				return false;
			}
		}
		return true;
	}

	

	public void waitInMilisec(int milisec) {
		try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
		
	}
	
	//gets and sets
	
	
	
	
	public PlayerController getPlayerController() {
		return playerController;
	}

	public boolean isPlayerHasWon() {
		return playerHasWon;
	}

	public void setPlayerHasWon(boolean playerHasWon) {
		this.playerHasWon = playerHasWon;
	}

	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}
	
	


	public CombatManagerVisual getCombatManagerOnScreen() {
		return combatManagerOnScreen;
	}

	public void setCombatManagerOnScreen(CombatManagerVisual combatManagerOnScreen) {
		this.combatManagerOnScreen = combatManagerOnScreen;
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
