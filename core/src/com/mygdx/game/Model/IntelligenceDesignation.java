package com.mygdx.game.Model;

public class IntelligenceDesignation implements Designation {
	public IntelligenceDesignation(Player player) {
		changeAttributes(player);
	}
	@Override
	public void changeAttributes(Player player) {
		// TODO Auto-generated method stubplayer
		player.setAtributes("Good with staffs!");
	}
}
