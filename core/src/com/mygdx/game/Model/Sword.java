package com.mygdx.game.Model;

public class Sword extends Weapon {

	@Override
	public void increaseAtribute(Player player) {
		// TODO Auto-generated method stub
		if(player.getDesignation().getClass().getName() == StrengthDesignation.class.getName()) {
			player.increaseAttackBonus(this.getPower());
		}
	}

	@Override
	public void decreaseAtribute(Player player) {
		// TODO Auto-generated method stub
		if(player.getDesignation().getClass().getName() == StrengthDesignation.class.getName()) {
			player.decreaseAttackBonus(this.getPower());
		}
	}

}
