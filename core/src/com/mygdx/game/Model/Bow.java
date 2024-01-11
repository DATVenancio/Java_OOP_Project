package com.mygdx.game.Model;

public class Bow extends Weapon {

	public Bow(String name, int power) {
		super(name,power);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increaseAtribute(Player player) {
		// TODO Auto-generated method stub
		if(player.getDesignation().getClass().getName() == DexterityDesignation.class.getName()) {
			player.increaseAttackBonus(this.getPower());
		}
	}

	@Override
	public void decreaseAtribute(Player player) {
		// TODO Auto-generated method stub
		if(player.getDesignation().getClass().getName() == DexterityDesignation.class.getName()) {
			player.decreaseAttackBonus(this.getPower());
		}
	}

}
