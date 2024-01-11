package com.mygdx.game.Model;

public class Enemy {
	private String name;
	private int life;
	private int attack;
	private boolean alive;
	
	
	public Enemy(String name, int life, int attack) {
		this.name=name;
		this.life=life;
		this.attack=attack;
		this.alive=true;
	}
	
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
		if(life>0) {
			this.life = life;
		}else {
			this.life=0;
			this.alive=false;
		}
		
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
