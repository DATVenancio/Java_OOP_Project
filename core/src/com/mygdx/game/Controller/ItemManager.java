package com.mygdx.game.Controller;

import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SortedIntList.Iterator;
import com.mygdx.game.Model.Item;
import com.mygdx.game.View.ItemOnScreen;

public class ItemManager {
	private ArrayList<ItemController> itemsController = new ArrayList<ItemController>();
	private PlayerController playerController;
	private SpriteBatch batch;
	
	public void configureItemManager(SpriteBatch batch,PlayerController playerController)
	{
		this.batch=batch;
		this.playerController=playerController;
	}
	
	public void checkItemCollision() {
		
		ItemController itemToRemove=null;
		for(ItemController itemController:itemsController) {
			if(itemController.getItemOnScreen().isCollidingWith(playerController.getPlayerOnScreen())) {
				addItemToBag(itemController.getItem());
				itemToRemove=itemController;
			}
		}
		if(itemToRemove!=null) {
			itemsController.remove(itemToRemove);
		}
	}
	
	public void createItems() {
		FileReader reader = new FileReader();
		ArrayList<Map<String,Object>> items = reader.readPhase01Items();

		for(Map<String,Object> item:items) {
			if(item.get("type").toString().equals("usable")){
				itemsController.add(new ItemUsableController(batch,item));
			}
			else if(item.get("type").toString().equals("weapon")) {
				itemsController.add(new ItemWeaponController(batch,item));
			}
				
		}
	}
	
	
	public boolean allRelicsCollected() {
		for(ItemController itemController:itemsController) {
			if(itemController.getItem().getType().equals(String.valueOf("usable"))){
				return false;
			}
		}
		return true;
	}
	public void drawItems() {
		for(ItemController itemController:itemsController) {
			itemController.getItemOnScreen().draw();
		}
	}
	
	public void addItemToBag(Item item) {
		playerController.getPlayer().getBag().addItem(item);
	}
	

}
