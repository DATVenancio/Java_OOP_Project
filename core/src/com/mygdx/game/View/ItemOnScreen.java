package com.mygdx.game.View;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class ItemOnScreen extends ElementOnScreen{
	public ItemOnScreen(SpriteBatch batch,Texture image,Vector2 inicialPosition) {
		this.batch=batch;
		sprite= new  Sprite(image);
		position =inicialPosition;
		sprite.setScale(1);
	}
	public void draw() {
		sprite.setPosition(position.x, position.y);
		sprite.setSize(100, 100);
		sprite.draw(batch);
		
	}
}
