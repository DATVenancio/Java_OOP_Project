package com.mygdx.game.Model;

import java.util.Map;

public class Player {
	
	private String name;
	private String atributes;
	
	
	private int stregth;
	private int intelligence;
	private int wisdom;
	private int ruse;
	private int speed;
	private int attackBonus;
	private int life;
	
	
	
	
	private Bag bag;
	private Designation designation;
	//Classe pour contrôler le joueur dans le backend
	public Player() {}
	
	public Player(Map<String,Object> characterInfo) {
		this.name = characterInfo.get("name").toString();
		this.stregth = Integer.parseInt( characterInfo.get("strength").toString());
		this.intelligence = Integer.parseInt( characterInfo.get("intelligence").toString());
		this.wisdom = Integer.parseInt( characterInfo.get("wisdom").toString());
		this.ruse = Integer.parseInt( characterInfo.get("ruse").toString());
		this.speed = Integer.parseInt(  characterInfo.get("speed").toString());
		this.attackBonus = Integer.parseInt(characterInfo.get("attackBonus").toString());
		this.life = Integer.parseInt(  characterInfo.get("life").toString());
		
		chooseDesignation(characterInfo.get("designation").toString());
		designation.changeAttributes(this);
		
		this.bag = new Bag(this);

	}
	
	
	
	public void increaseAttackBonus(int increase) {
		this.attackBonus = this.attackBonus + increase;
	}
	public void decreaseAttackBonus(int decrease) {
		this.attackBonus = this.attackBonus - decrease;
	}
	
	public void chooseDesignation(String chosenDesignation){
		if(chosenDesignation.equals("strength")) {
			this.designation = new StrengthDesignation();
		}
		else if(chosenDesignation.equals("intelligence")) {
			this.designation = new IntelligenceDesignation();
		}else {
			this.designation = new DexterityDesignation();
		}
	}
	
	
	
	//gets and sets

	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		if(life>0) {
			this.life = life;
		}
		else {
			this.life=0;
		}
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

	public int getWisdom() {
		return wisdom;
	}

	public void setWisdom(int wisdom) {
		this.wisdom = wisdom;
	}

	public int getRuse() {
		return ruse;
	}

	public void setRuse(int ruse) {
		this.ruse = ruse;
	}

	public String getAtributes() {
		return atributes;
	}

	public void setAtributes(String atributes) {
		this.atributes = atributes;
	}
	
	
	
	
	
	
}
