package com.mygdx.game.View;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class ElementOnScreen extends ApplicationAdapter{
	public Vector2 position;
	public Sprite sprite;

	public boolean isCollidingWith(ElementOnScreen elementOnScreen) {
		if(sprite.getBoundingRectangle().overlaps(elementOnScreen.getSprite().getBoundingRectangle())) {
			return true;
		}
		return false;
	}
	
	public Vector2 getPosition() {
		return position;
	}
	public void setPosition(Vector2 position) {
		this.position = position;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}

}
