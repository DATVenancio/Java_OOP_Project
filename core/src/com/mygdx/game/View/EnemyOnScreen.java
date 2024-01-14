package com.mygdx.game.View;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EnemyOnScreen extends ElementOnScreen {
	public EnemyOnScreen(SpriteBatch batch,Texture image,Vector2 inicialPosition) {
		this.batch=batch;
		sprite= new  Sprite(image);
		position =inicialPosition;
		sprite.setScale(1);
	}


	public void draw() {
		sprite.setPosition(position.x, position.y);
		sprite.draw(batch);
	}
	




}
