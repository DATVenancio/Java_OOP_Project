package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

public class PauseGame implements Command {
	private Game game;
	private boolean isPaused=false;
	private PlayerController playerController;
	SoundManager soundManger = SoundManager.getInstance();
	
	
	
	public PauseGame(Game game) {
		this.game = game;
		this.playerController=game.getPlayerController();
	}
	@Override
	public void execute() {
		if (Gdx.input.isKeyPressed(Keys.P)) {
			isPaused=!isPaused;
			soundManger.playMusic(!isPaused);
			playerController.getPlayerOnScreen().setPlayerFreeze(isPaused);
			waitInMilisec(100);
		}
		
	}
	
	public void waitInMilisec(int milisec) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
