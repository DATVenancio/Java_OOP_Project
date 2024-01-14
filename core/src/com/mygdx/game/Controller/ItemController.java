package com.mygdx.game.Controller;

import java.util.Map;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Model.Bow;
import com.mygdx.game.Model.Enemy;
import com.mygdx.game.Model.Item;
import com.mygdx.game.Model.Staff;
import com.mygdx.game.Model.Sword;
import com.mygdx.game.Model.UsableItem;
import com.mygdx.game.View.EnemyOnScreen;
import com.mygdx.game.View.ItemOnScreen;

public class ItemController {
	private Texture itemTexture;
	private ItemOnScreen itemOnScreen;
	private Item item;
	
	public ItemController(SpriteBatch batch,Map<String,Object> itemInfos) {
		createItemOnScreen(batch,itemInfos);
		createItem(itemInfos);
		
	}
	private void createItemOnScreen(SpriteBatch batch, Map<String,Object> itemInfos) {
		Vector2 position = new Vector2(Integer.valueOf((String) itemInfos.get("positionX")),Integer.valueOf((String) itemInfos.get("positionY")));
		itemTexture = new Texture(itemInfos.get("name")+".png");
		itemOnScreen = new ItemOnScreen(batch,itemTexture, position);
	}
	private void createItem(Map<String,Object> itemInfos) {
		String type = (String) itemInfos.get("type");
		String name = (String) itemInfos.get("name");
		int power = Integer.parseInt( (String)itemInfos.get("power"));
		if(type.equals("usable")) {
			item = new UsableItem(name);
		}
		if(type.equals("sword")) {
			item = new Sword(name,power);
		}
		if(type.equals("staff")) {
			item = new Staff(name,power);
		}
		if(type.equals("bow")) {
			item = new Bow(name,power);
		}
		
	}
	
	
	
	
	
	

	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public ItemOnScreen getItemOnScreen() {
		return itemOnScreen;
	}

	public void setItemOnScreen(ItemOnScreen itemOnScreen) {
		this.itemOnScreen = itemOnScreen;
	}
	
	
	
	
}
