package com.mygdx.game.Controller;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Bow;
import com.mygdx.game.Model.Staff;
import com.mygdx.game.Model.Sword;
import com.mygdx.game.Model.UsableItem;

public class ItemUsableController extends ItemController {

	public ItemUsableController(SpriteBatch batch, Map<String, Object> itemInfos) {
		super(batch, itemInfos);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void createItem(Map<String,Object> itemInfos) {
		String type = (String) itemInfos.get("type");
		String name = (String) itemInfos.get("name");
		
		item = new UsableItem(type,name);
	}

}
