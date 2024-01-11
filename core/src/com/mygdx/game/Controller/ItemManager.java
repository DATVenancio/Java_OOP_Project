package com.mygdx.game.Controller;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.SortedIntList.Iterator;
import com.mygdx.game.Model.Item;
import com.mygdx.game.View.ItemOnScreen;

public class ItemManager {
	private ArrayList<ItemController> itemsController;
	private PlayerController playerController;
	
	public void configureItemManager(PlayerController playerController, ArrayList<ItemController> itemsController)
	{
		this.playerController=playerController;
		this.itemsController=itemsController;
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
	public void addItemToBag(Item item) {
		playerController.getPlayer().getBag().addItem(item);
	}
	

}
