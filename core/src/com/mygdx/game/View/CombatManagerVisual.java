package com.mygdx.game.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Controller.EnemyController;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.Player;

public class CombatManagerVisual {
	private Texture battleImage;
	private Texture battleResultImage;
	private Texture loseGameImage;
	private Texture winGameImage;
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
		battleImage = new Texture("../../bin/main/battle_"+enemy.getName()+".png");
		battleResultImage = new Texture("../../bin/main/battle_result2.png");
		batch.draw(battleResultImage, 800, 500);
		
		batch.draw(battleImage, 800, 200);
		font.draw(batch, diceResult, 1000, 750);
		
		
		font.draw(batch, String.valueOf(player.getLife()), 850, 500);
		font.draw(batch, String.valueOf(player.getAttackBonus()), 850, 420);
		
		
		font.draw(batch, String.valueOf(enemy.getLife()), 1090, 500);
		font.draw(batch, String.valueOf(enemy.getAttack()), 1090, 420);
		battleImage.dispose();
		
		
		
		
		battleResultImage.dispose();
		//font.dispose();

	}
	public void showDiceResult(int diceResult) {
		this.diceResult=String.valueOf(diceResult);

	}
	public void restartDiceResult() {
		this.diceResult=" ";
	}

	public void showLoseGameImage() {
		loseGameImage = new Texture("../../bin/main/lose_game_image.png");
		
		float imageWidth = loseGameImage.getWidth();
		float imageHeight = loseGameImage.getHeight();
		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;
		
		batch.draw(loseGameImage, x, y);
	}
	
	public void showWinGameImage() {
		winGameImage = new Texture("../../bin/main/win_game_image.png");
		
		float imageWidth = winGameImage.getWidth();
		float imageHeight = winGameImage.getHeight();
		float x = (Gdx.graphics.getWidth() - imageWidth) / 2;
		float y = (Gdx.graphics.getHeight() - imageHeight) / 2;
		
		batch.draw(winGameImage, x, y);
	}
	
	//gets and sets
	public SpriteBatch getBatch() {
		return batch;
	}

	public void setBatch(SpriteBatch batch) {
		this.batch = batch;
	}
	
	public void dispose() {
		battleImage.dispose();
		font.dispose();
	}
	
	
	
	
}
