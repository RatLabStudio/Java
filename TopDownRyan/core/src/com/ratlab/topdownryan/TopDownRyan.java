package com.ratlab.topdownryan;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class TopDownRyan extends ApplicationAdapter {
	SpriteBatch batch;
	private Rectangle nerd;
	Texture nerdImg;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		nerdImg = new Texture("Nerd.png");

		nerd = new Rectangle();
		nerd.x = 400;
		nerd.y = 400;
		nerd.width = 100;
		nerd.height = 100;
		//font.setColor(Color.WHITE);
	}

	@Override
	public void render () {
		ScreenUtils.clear(new Color(Color.SKY));

		if (Gdx.input.isKeyPressed(Input.Keys.W)){
			nerd.y += 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.A)){
			nerd.x -= 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.S)){
			nerd.y -= 5;
		}

		if (Gdx.input.isKeyPressed(Input.Keys.D)){
			nerd.x += 5;
		}


		batch.begin();
		batch.draw(nerdImg, nerd.x, nerd.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nerdImg.dispose();
	}
}
