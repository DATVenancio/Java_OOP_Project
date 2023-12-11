package com.mygdx.game.Controller;



import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Player;
import com.mygdx.game.View.PlayerOnScreen;

public class PlayerController {
	private PlayerOnScreen playerOnScreen;
	private Player player;

	public PlayerController(SpriteBatch batch,String chosenCharacter) {
		playerOnScreen = new PlayerOnScreen(batch);
		chooseCharacter(chosenCharacter);
	}
	
	public void chooseCharacter(String chosenCharacter) {
		
		choosePlayerSprite(chosenCharacter);
		choosePlayerAttributes(chosenCharacter);
		
		
	}
	
	
	public void choosePlayerSprite(String chosenCharacter) {
		Texture characterImage = new Texture(chosenCharacter+".png");
		playerOnScreen.setSprite(new Sprite(characterImage));
	}
	
	public void choosePlayerAttributes(String chosenCharacter){
		FileReader reader = new FileReader();
		Map<String,Object> characterInfo  = reader.readCharacterInfo(chosenCharacter);
		this.player = new Player(characterInfo);
	}
	
	public PlayerOnScreen getPlayerOnScreen() {
		return playerOnScreen;
	}

	public void setPlayerOnScreen(PlayerOnScreen playerOnScreen) {
		this.playerOnScreen = playerOnScreen;
	}

}
