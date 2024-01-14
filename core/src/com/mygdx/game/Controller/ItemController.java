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

public abstract class ItemController {
	protected Texture itemTexture;
	protected ItemOnScreen itemOnScreen;
	protected Item item;
	
	public ItemController(SpriteBatch batch,Map<String,Object> itemInfos) {
		createItemOnScreen(batch,itemInfos);
		createItem(itemInfos);
		
	}
	private void createItemOnScreen(SpriteBatch batch, Map<String,Object> itemInfos) {
		Vector2 position = new Vector2(Integer.valueOf((String) itemInfos.get("positionX")),Integer.valueOf((String) itemInfos.get("positionY")));
		itemTexture = new Texture("../../build/resources/main/"+itemInfos.get("name")+".png");
		itemOnScreen = new ItemOnScreen(batch,itemTexture, position);
	}
	protected abstract void createItem(Map<String,Object> itemInfos);
	
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
