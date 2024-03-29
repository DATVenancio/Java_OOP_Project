package com.mygdx.game.Controller;



import java.util.Map;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Player;
import com.mygdx.game.View.PlayerOnScreen;

public class PlayerController extends ApplicationAdapter implements InputProcessor {
	private PlayerOnScreen playerOnScreen;
	private Player player;
	private Texture characterImage;

	public PlayerController(SpriteBatch batch,String chosenCharacter) {
		playerOnScreen = new PlayerOnScreen(batch);
		createPlayer(chosenCharacter);
	}
	
	public void createPlayer(String chosenCharacter) {
		choosePlayerSprite(chosenCharacter);
		choosePlayerAttributes(chosenCharacter);
	}

	public void choosePlayerSprite(String chosenCharacter) {
		characterImage = new Texture(chosenCharacter+".png");
		playerOnScreen.setSprite(new Sprite(characterImage));
	}
	
	public void choosePlayerAttributes(String chosenCharacter){
		InformationReader reader = new InformationReader();
		Map<String,Object> characterInfo  = reader.readCharacterInfo(chosenCharacter);

		this.player = new Player(characterInfo);
	}

	
	
	public void freezePlayer() {
		playerOnScreen.setPlayerFreeze(true);
	}
	public void unfreezePlayer() {
		playerOnScreen.setPlayerFreeze(false);
	}
	
	
	
	public PlayerOnScreen getPlayerOnScreen() {
		return playerOnScreen;
	}

	public void setPlayerOnScreen(PlayerOnScreen playerOnScreen) {
		this.playerOnScreen = playerOnScreen;
	}
	
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void dispose() {
		// pour la libération mémoire
		characterImage.dispose();
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
