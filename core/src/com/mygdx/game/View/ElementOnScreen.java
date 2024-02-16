package com.mygdx.game.View;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

//Classe de base pour tous les éléments insérés visuellement sur le plateau de jeu (joueur, ennemis, items)

public class ElementOnScreen extends ApplicationAdapter{
	protected Vector2 position;
	protected Sprite sprite;
	protected SpriteBatch batch;

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
