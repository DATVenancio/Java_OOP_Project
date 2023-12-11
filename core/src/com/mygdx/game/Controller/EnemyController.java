package com.mygdx.game.Controller;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.View.EnemyOnScreen;

public class EnemyController {
	private Enemy enemy;
	private EnemyOnScreen enemyOnScreen;
	
	public EnemyController(SpriteBatch batch,String enemyString,Vector2 position) {
		Texture enemyTexture = new Texture(enemyString);
		enemyOnScreen = new EnemyOnScreen(batch,enemyTexture, position);
	}

	public EnemyOnScreen getEnemyOnScreen() {
		return enemyOnScreen;
	}

	public void setEnemyOnScreen(EnemyOnScreen enemyOnScreen) {
		this.enemyOnScreen = enemyOnScreen;
	}
	
	
	
	
}
