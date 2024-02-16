package com.mygdx.game.Model;

public abstract class Item {
	protected String type;
	protected String name;
	protected String description;
	protected float weight;
	

	public abstract void actionWhenAdded(Player player);
	public abstract void actionWhenRemoved(Player player);
	
	public Item(String type,String name) {
		this.type=type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	

}
