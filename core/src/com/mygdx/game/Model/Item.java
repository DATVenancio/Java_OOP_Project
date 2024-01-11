package com.mygdx.game.Model;

public abstract class Item {
	private String type;
	private float weight;
	protected String name;
	private String description;

	public abstract void actionWhenAdded(Player player);
	public abstract void actionWhenRemoved(Player player);
	
	
	public Item(String name) {
		this.name = name;
	}
	
	
	public void increaseBagTotalWeigth(Bag bag) {
		float current_total_weight = bag.getTotalWeight();
		bag.setTotalWeight(current_total_weight+this.weight);
	}
	public void decreaseBagTotalWeigth(Bag bag) {
		float current_total_weight = bag.getTotalWeight();
		bag.setTotalWeight(current_total_weight-this.weight);
	}
	
	
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weigth) {
		this.weight = weigth;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
