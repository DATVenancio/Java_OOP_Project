package com.mygdx.game.Model;

public abstract class Weapon extends Item {
	private int power;
	
	
	public abstract void increaseAtribute(Player player);
	public abstract void decreaseAtribute(Player player);
	
	@Override
	public void actionWhenAdded(Player player) {
		// TODO Auto-generated method stub
		increaseAtribute(player);
		
	}

	@Override
	public void actionWhenRemoved(Player player) {
		// TODO Auto-generated method stub
		decreaseAtribute(player);
	}

	
	//gets and sets
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	
	
	
}
