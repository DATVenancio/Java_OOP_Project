package com.mygdx.game.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.EnemyController;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.Player;

public class CombatManagerOnScreen {
	private Texture battle_image;
	private Texture battle_result_image;
	private Texture lose_game_image;
	private SpriteBatch batch;
	private BitmapFont font = new BitmapFont();
	private String diceResult=" ";

	public boolean playerColidesWithEnemy(PlayerOnScreen playerOnSCreen, EnemyOnScreen enemyOnScreen) {
		if(playerOnSCreen.getSprite().getBoundingRectangle().overlaps(enemyOnScreen.getSprite().getBoundingRectangle())) {
			return true;
		}
		return false;
	}
	
	public void showBattleImage(Player player, Enemy enemy) {
		battle_image = new Texture("../assets/battle_"+enemy.getName()+".png");
		battle_result_image = new Texture("../assets/battle_result2.png");
		batch.draw(battle_result_image, 800, 500);
		
		batch.draw(battle_image, 800, 200);
		font.draw(batch, diceResult, 1000, 750);
		
		
		font.draw(batch, String.valueOf(player.getLife()), 850, 500);
		font.draw(batch, String.valueOf(player.getAttackBonus()), 850, 420);
		
		
		font.draw(batch, String.valueOf(enemy.getLife()), 1090, 500);
		font.draw(batch, String.valueOf(enemy.getAttack()), 1090, 420);
		battle_image.dispose();
		
		
		
		
		battle_result_image.dispose();
		//font.dispose();

	}
	public void showDiceResult(int diceResult) {
		this.diceResult=String.valueOf(diceResult);

	}
	public void restartDiceResult() {
		this.diceResult=" ";
	}

	public void showLoseGameImage() {
		lose_game_image = new Texture("../assets/lose_game_image.png");
		
		float imageWidth = lose_game_image.getWidth();
		float imageHeight = lose_game_image.getHeight();
		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;
		
		batch.draw(lose_game_image, x, y);
	}
	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public void dispose() {
		battle_image.dispose();
		font.dispose();
	}
	
	
	
	
}
