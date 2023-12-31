 package com.mygdx.game.Controller;

import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Dice;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.Player;

public class CombatManager {
	SpriteBatch batch;
	Texture battle_1;
	private static CombatManager instance;
	
	private PlayerController playerController;
	private ArrayList<EnemyController> enemiesController;
	
	private CombatManager() {};
	
	public static CombatManager getInstance() {
		if(instance == null) {
			instance = new CombatManager();
		}
		return instance;
	}

	public void configureCombatManager(PlayerController playerController, ArrayList<EnemyController> enemiesController)
	{
		this.playerController=playerController;
		this.enemiesController=enemiesController;
	}
	public void checkCombat() {
		batch = new SpriteBatch();
		battle_1 = new Texture("battle_geant.png");

		for(EnemyController enemyController:enemiesController) {
			if(playerController.getPlayerOnScreen().getSprite().getBoundingRectangle().overlaps(enemyController.getEnemyOnScreen().getSprite().getBoundingRectangle())) {
				batch.begin();

				batch.draw(battle_1, 800, 200);

				batch.end();
				System.out.println("colide!");
			}
				
		}
	}
	
	
	
	
	public boolean createTurn(Dice dice,Enemy enemy) {

		/*
		while(enemyIsAlive(enemy)) {
			int playerAttack = dice.rollDice()+player.getAttackBonus();
			int enemyLife = enemy.getLife();
			
			if(playerAttack>=enemyLife) {
				killEnemy(enemy);
			}else {
				hurtEnemy(enemy);
				hurtPlayer(enemy.getAttack());
			}
			
			if(playerIsDead()) {
				return false;
			}
		}
		return true;
		*/
		return true;
	}

	

	
	//gets and sets
	
	public PlayerController getPlayerController() {
		return playerController;
	}

	public void setPlayerController(PlayerController playerController) {
		this.playerController = playerController;
	}

	
	
	
}
