package com.mygdx.game;

public class IntelligenceDesignation implements Designation {
	public IntelligenceDesignation(Player player) {
		changeAttributes(player);
	}
	@Override
	public void changeAttributes(Player player) {
		// TODO Auto-generated method stub
		player.setStregth(2);
		player.setIntelligence(5);
		player.setSpeed(2);
	}
}
