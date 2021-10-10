package com.mygdx.tiledmapreader;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	public TiledWorld tiledWorld;
	public OrthographicCamera camera;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		tiledWorld = new TiledWorld("JsonFiles/TestWorldLibGdxReader.json");
		camera = new OrthographicCamera(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.translate(Gdx.graphics.getWidth()/2f,Gdx.graphics.getHeight()/2f);
	}

	@Override
	public void render () {
		camera.update();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT))
		{
			if(camera.position.x <= Gdx.graphics.getWidth()+Gdx.graphics.getWidth()/16f)
				camera.translate(new Vector2(10,0));
		}else if(Gdx.input.isKeyPressed(Input.Keys.LEFT))
		{
			if(camera.position.x > Gdx.graphics.getWidth()/2f)
				camera.translate(new Vector2(-10,0));
		}

		if(Gdx.input.isKeyPressed(Input.Keys.UP))
		{
			if(camera.position.y <= Gdx.graphics.getHeight()+Gdx.graphics.getHeight()/16f)
			camera.translate(new Vector2(0,10));
		}else if(Gdx.input.isKeyPressed(Input.Keys.DOWN))
		{
			if(camera.position.y > Gdx.graphics.getHeight()/2f)
			camera.translate(new Vector2(0,-10));
		}
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		tiledWorld.Draw(batch,5f);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		tiledWorld.dispose();
	}
}
