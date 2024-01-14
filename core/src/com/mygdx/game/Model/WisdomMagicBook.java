package com.mygdx.game.Model;

public class WisdomMagicBook extends MagicBook {

	public WisdomMagicBook(Weapon weapon) {
		super(weapon.getName() , weapon.getPower(), weapon);
		// TODO Auto-generated constructor stub
	}
	@Override
	public void increaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);
		player.setWisdom(player.getWisdom()+power);

	}

	@Override
	public void decreaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);
		player.setWisdom(player.getWisdom()-power);
	}


}
