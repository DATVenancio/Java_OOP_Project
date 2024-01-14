package com.mygdx.game.Model;

public class LifeMagicBook extends MagicBook {

	public LifeMagicBook( Weapon weapon) {
		super(weapon.getName() , weapon.getPower(), weapon);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void increaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);
		player.setLife(player.getLife()+power);

	}

	@Override
	public void decreaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);
		player.setLife(player.getLife()-power);
	}

}
