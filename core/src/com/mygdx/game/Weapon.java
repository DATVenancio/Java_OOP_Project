package com.mygdx.game;

public abstract class Weapon extends Item {
	private int power;
	

	public abstract void increaseAtribute(Player player);
	public abstract void decreaseAtribute(Player player);

	
	//gets ans sets
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}

	
	
	
}
