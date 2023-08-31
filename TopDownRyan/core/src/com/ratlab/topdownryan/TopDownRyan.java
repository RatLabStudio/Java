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
	private GameObject nerd;
	private GameObject coolGuy;
	Texture nerdImg;
	Texture coolGuyImg;
	private float scaling = 1;

	private boolean canMoveX;
	private boolean canMoveY;

	@Override
	public void create () {
		batch = new SpriteBatch();
		nerdImg = new Texture("Nerd.png");
		coolGuyImg = new Texture("cool.png");

		nerd = new GameObject(400, 400, 100, 100, scaling);

		nerd = new GameObject(400, 400, 100, 100, scaling);

		//font.setColor(Color.WHITE);
	}

	public void coliding(){
		nerd.x = nerd.x - 1;
		nerd.y = nerd.y -1;
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


		if (Gdx.input.isKeyPressed(Input.Keys.UP)){
			coolGuy.y += 5;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			coolGuy.x -= 5;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			coolGuy.y -= 5;
		}
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			coolGuy.x += 5;
		}


		batch.begin();//fix make shorter
		batch.draw(nerdImg, nerd.x, nerd.y, nerd.width / 2f, nerd.height / 2f, nerd.width, nerd.height, scaling, scaling, 0, 0, 0, nerdImg.getWidth(), nerdImg.getHeight(), false, false);

		batch.draw(coolGuyImg, coolGuy.x, coolGuy.y);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		nerdImg.dispose();
		coolGuyImg.dispose();
	}
}
