package com.mygdx.game.Model;

import java.util.Map;

public class Player {
	
	private String name;
	
	
	private int stregth;
	private int intelligence;
	private int speed;
	
	private int attackBonus;
	private int life;
	
	
	
	
	private Bag bag;
	private Designation designation;
	
	public Player() {}
	
	public Player(Map<String,Object> characterInfo) {
		this.name = characterInfo.get("name").toString();
		this.stregth = Integer.parseInt( characterInfo.get("strength").toString());
		this.intelligence = Integer.parseInt( characterInfo.get("intelligence").toString());
		this.speed = Integer.parseInt(  characterInfo.get("speed").toString());
		this.attackBonus = Integer.parseInt(characterInfo.get("attackBonus").toString());
		this.life = Integer.parseInt(  characterInfo.get("life").toString());
	}
	
	
	
	public void increaseAttackBonus(int increase) {
		this.attackBonus = this.attackBonus + increase;
	}
	public void decreaseAttackBonus(int decrease) {
		this.attackBonus = this.attackBonus - decrease;
	}
	
	
	
	
	//gets and sets

	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	
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
