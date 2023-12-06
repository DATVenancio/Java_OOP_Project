package com.mygdx.game.Model;

public abstract class Enemy {
	private String name;
	private int life;
	private int attack;
	private boolean alive;
	
	
	//gets and sets
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public boolean isAlive() {
		return alive;
	}
	public void setAlive(boolean alive) {
		this.alive = alive;
	}	
	
	
	
}
