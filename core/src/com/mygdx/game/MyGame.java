package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGame extends Game {
	SpriteBatch batch;
//Preferences pref;


	
	@Override
	public void create () {
		Resource.load();
//		pref=Gdx.app.getPreferences("MyPreferences");
		batch = new SpriteBatch();
		setScreen(new Menu(this));

	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
Resource.disp();
	}

}
