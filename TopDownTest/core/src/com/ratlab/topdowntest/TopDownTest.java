package com.ratlab.topdowntest;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

public class TopDownTest extends ApplicationAdapter {
	SpriteBatch batch;
	Texture ratTexture;
	GameObject rat, npc;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		World.objs = new Array<GameObject>();

		ratTexture = new Texture("bird.png");
		rat = new GameObject(20, 20, 68, 48, ratTexture);
		npc = new GameObject(50, 50, 68, 48, ratTexture);
		World.objs.add(rat);
		World.objs.add(npc);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0.5f, 0.5f, 1);

		int speed = 3;
		if (Gdx.input.isKeyPressed(Input.Keys.W))
			rat.move("vertical", speed);
		if (Gdx.input.isKeyPressed(Input.Keys.S))
			rat.move("vertical", -speed);
		if (Gdx.input.isKeyPressed(Input.Keys.A))
			rat.move("horizontal", -speed);
		if (Gdx.input.isKeyPressed(Input.Keys.D))
			rat.move("horizontal", speed);
		if (Gdx.input.isKeyPressed(Input.Keys.ESCAPE))
			Gdx.app.exit();

		batch.begin();
		for (GameObject obj : World.objs)
			batch.draw(obj.texture, obj.x, obj.y, obj.width, obj.height);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		ratTexture.dispose();
	}
}
