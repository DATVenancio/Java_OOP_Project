package com.mygdx.game;

import java.util.ArrayList;

public class Bag {
	private int capacity;
	private int amountOfItems;
	private float totalWeight;
	
	private Player player;
	private ArrayList<Item> items = new ArrayList<Item>();
	

	
	
	public void addItem(Item item) {
		if(amountOfItems<capacity) {
			items.add(item);
			amountOfItems++;
			increaseTotalWeigth(item.getWeight());
			item.actionWhenAdded(player);
		}
	}
	
	public void removeItem(Item item) {
		
		if(amountOfItems>0) {
			items.remove(item);
			amountOfItems--;
			decreaseTotalWeigth(item.getWeight());
			item.actionWhenRemoved(player);
		}
	}
	
	
	
	
	
	
	public void increaseTotalWeigth(float itemWeigth) {
		this.totalWeight += itemWeigth;
	}
	public void decreaseTotalWeigth(float itemWeigth) {
		this.totalWeight -= itemWeigth;
	}
	
	
	
	//gets and sets
	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}
	

	
	
	public ArrayList<Item> getItems() {
		return items;
	}


	public void setItems(ArrayList<Item> items) {
		this.items = items;
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
