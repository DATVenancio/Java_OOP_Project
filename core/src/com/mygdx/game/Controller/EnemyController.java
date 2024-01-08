package com.mygdx.game.Controller;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.View.EnemyOnScreen;

public class EnemyController extends ApplicationAdapter implements InputProcessor {
	private Enemy enemy;
	private EnemyOnScreen enemyOnScreen;
	private Texture enemyTexture;
	
	public EnemyController(SpriteBatch batch,String enemyString,Vector2 position) {
		enemyTexture = new Texture(enemyString);
		enemyOnScreen = new EnemyOnScreen(batch,enemyTexture, position);
	}

	public EnemyOnScreen getEnemyOnScreen() {
		return enemyOnScreen;
	}

	public void setEnemyOnScreen(EnemyOnScreen enemyOnScreen) {
		this.enemyOnScreen = enemyOnScreen;
	}

	public void dispose () {
		enemyOnScreen.dispose();
		enemyTexture.dispose();
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
