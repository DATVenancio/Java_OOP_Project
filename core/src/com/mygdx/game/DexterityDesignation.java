package com.mygdx.game;

public class DexterityDesignation implements Designation {
	public DexterityDesignation(Player player) {
		changeAttributes(player);
	}
	@Override
	public void changeAttributes(Player player) {
		// TODO Auto-generated method stub
		player.setStregth(2);
		player.setIntelligence(2);
		player.setSpeed(5);
	}
}
