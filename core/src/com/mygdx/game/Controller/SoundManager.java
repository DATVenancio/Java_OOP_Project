package com.mygdx.game.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

//Classe "Manager" utilisée pour centraliser le contrôle audio des phases
public class SoundManager {
	
	
	private static SoundManager instance;
	static Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("menuMusic.mp3"));
	static Music music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
	static Sound itemCollected = Gdx.audio.newSound(Gdx.files.internal("item.mp3"));
	static Sound monsterSound = Gdx.audio.newSound(Gdx.files.internal("monster.mp3"));
	static Sound winBattle = Gdx.audio.newSound(Gdx.files.internal("winBattle.mp3"));
	
	private SoundManager() {};

	
	public static SoundManager getInstance() {
		if(instance == null) {
			instance = new SoundManager();
		}
		return instance;
	}
	
	public void initialConfiguration() {
		menuMusic.stop();
		music.play();
		music.setLooping(true);
		music.setVolume(0.1f);
	}
	
	public void playMusic(boolean isPlaying) {
		if(isPlaying) {
			music.play();
		}else {
			music.pause();
		}
		
	}
	public void playMenuMusic() {
		menuMusic.setLooping(true);
		menuMusic.setVolume(0.5f);
		menuMusic.play();
		
	}
	
	
	public void playItemCollected() {
		itemCollected.play();
		
	}
	public void playMonsterSound() {
		monsterSound.play();
		
	}
	public void playWinBattle() {
		winBattle.play();
		
	}
}
