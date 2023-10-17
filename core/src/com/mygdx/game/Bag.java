package com.mygdx.game;

import java.util.ArrayList;

public class Bag {
	private int capacity;
	private int amountOfItems;
	private float totalWeight;
	private ArrayList<Item> items = new ArrayList<Item>();
	
	
	public void addItem(Item item) {
		if(amountOfItems<=capacity) {
			items.add(item);
		}	
	}
	
	//gets and sets
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
	public int getAmountOfItems() {
		return amountOfItems;
	}

	public void setAmountOfItems(int amountOfItems) {
		this.amountOfItems = amountOfItems;
	}

	public float getTotalWeight() {
		return totalWeight;
	}
	public void setTotalWeight(float totalWeight) {
		this.totalWeight = totalWeight;
	}
	
	
	
}
