package com.mygdx.game;

import java.util.Random;
import java.util.Scanner;

public class Dice {
	private int amountOfSides;
	
	public Dice(int amountOfSides) {
		this.amountOfSides = amountOfSides;
	}
	
	
	public int rollDice() {
		Random rand = new Random();

		System.out.print("Roll the dice: ");
		Scanner scanner = new Scanner(System.in);
		scanner.next();
		int result =rand.nextInt(amountOfSides)+1;
		System.out.println(result);
		return result;
	}
	
	public int getAmountOfSides() {
		return amountOfSides;
	}

	public void setAmountOfSides(int amountOfSides) {
		this.amountOfSides = amountOfSides;
	}

	
}
