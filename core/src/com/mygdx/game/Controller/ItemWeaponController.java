package com.mygdx.game.Controller;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Model.Bow;
import com.mygdx.game.Model.LifeMagicBook;
import com.mygdx.game.Model.Staff;
import com.mygdx.game.Model.Sword;
import com.mygdx.game.Model.UsableItem;
import com.mygdx.game.Model.WisdomMagicBook;

public class ItemWeaponController extends ItemController{

	public ItemWeaponController(SpriteBatch batch, Map<String, Object> itemInfos) {
		super(batch, itemInfos);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createItem(Map<String,Object> itemInfos) {

		String name = (String) itemInfos.get("name");
		int power = Integer.parseInt( (String)itemInfos.get("power"));
		
		if(name.equals("sword")) {
			item = new Sword(name,power);
		}
		if(name.equals("staff")) {
			item = new Staff(name,power);
		}
		if(name.equals("bow")) {
			item = new Bow(name,power);
		}
		if(name.equals("lifeMagicBook")) {
			item= new LifeMagicBook(new Staff(name, power));
		}
		if(name.equals("wisdomMagicBook")) {
			item= new WisdomMagicBook(new Staff(name, power));
		}
	}
		
	
	
}
