package com.mygdx.game.Model;

public class StrengthDesignation implements Designation {

	public StrengthDesignation(Player player) {
		changeAttributes(player);
	}
	@Override
	public void changeAttributes(Player player) {
		// TODO Auto-generated method stub
		player.setStregth(5);
		player.setIntelligence(2);
		player.setSpeed(2);
		
	}

}
