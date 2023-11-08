package com.mygdx.game;

public class Player {
	
	private String name;
	private int attackBonus;
	
	private Bag bag;
	private Designation designation;
	
	
	
	public void increaseAttackBonus(int increase) {
		this.attackBonus = this.attackBonus + increase;
	}
	public void decreaseAttackBonus(int decrease) {
		this.attackBonus = this.attackBonus - decrease;
	}
	
	
	//gets and sets
	public int getAttackBonus() {
		return attackBonus;
	}
	public void setAttackBonus(int attackBonus) {
		this.attackBonus = attackBonus;
	}
	public Bag getBag() {
		return bag;
	}
	public void setBag(Bag bag) {
		this.bag = bag;
	}
	public Designation getDesignation() {
		return designation;
	}
	public void setDesignation(Designation designation) {
		this.designation = designation;
	}
	
	
	
	
}
