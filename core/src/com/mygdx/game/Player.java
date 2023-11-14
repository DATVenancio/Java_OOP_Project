package com.mygdx.game;

public class Player {
	
	private String name;
	private int attackBonus;
	private int stregth;
	private int intelligence;
	private int speed;
	
	
	private Bag bag;
	private Designation designation;
	
	
	
	
	
	public void increaseAttackBonus(int increase) {
		this.attackBonus = this.attackBonus + increase;
	}
	public void decreaseAttackBonus(int decrease) {
		this.attackBonus = this.attackBonus - decrease;
	}
	
	
	
	
	//gets and sets

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getStregth() {
		return stregth;
	}
	public void setStregth(int stregth) {
		this.stregth = stregth;
	}
	
	
	public int getIntelligence() {
		return intelligence;
	}
	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}
	
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
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
