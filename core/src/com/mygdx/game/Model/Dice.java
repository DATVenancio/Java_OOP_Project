package com.mygdx.game.Model;

import java.util.Random;
import java.util.Scanner;

public class Dice {
	private int amountOfSides;
	
	public Dice(int amountOfSides) {
		this.amountOfSides = amountOfSides;
	}
	
	
	public int rollDice() {
		Random rand = new Random();
		int result =rand.nextInt(amountOfSides)+1;
		return result;
	}
	
	public int getAmountOfSides() {
		return amountOfSides;
	}

	public void setAmountOfSides(int amountOfSides) {
		this.amountOfSides = amountOfSides;
	}

	
}
