package com.mygdx.game.Model;

public abstract class MagicBook extends Weapon {
	protected Weapon weapon;
	public MagicBook(String name, int power, Weapon weapon) {
		super(name, power);
		this.weapon=weapon;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void increaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);

	}

	@Override
	public void decreaseAtribute(Player player) {
		// TODO Auto-generated method stub
		weapon.increaseAtribute(player);
	}

}
