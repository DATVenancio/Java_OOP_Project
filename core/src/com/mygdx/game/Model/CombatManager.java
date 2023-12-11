 package com.mygdx.game.Model;

public class CombatManager {
	private static CombatManager instance;
	
	private Player player;
	
	private CombatManager() {};
	
	public static CombatManager getInstance() {
		if(instance == null) {
			instance = new CombatManager();
		}
		return instance;
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
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	
	
	
}
