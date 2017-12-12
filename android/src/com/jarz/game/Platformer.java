package com.jarz.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.jarz.game.Screens.Level2;
import com.jarz.game.Screens.MainMenuScreen;
import com.jarz.game.Screens.PlayScreen;
import com.jarz.game.Tools.GameAssetManager;

public class Platformer extends Game {
	public SpriteBatch batch;
	public static final int V_WIDTH = 400;//Virtual Width
	public static final int V_HEIGHT = 208;//Virtual Height
	public static final float PPM = 100; //Pixels Per Meter
    public GameAssetManager GAM = new GameAssetManager();

	//Box2D Collision Bits
	public static final short NOTHING_BIT = 0; //No Collision
	public static final short GROUND_BIT = 1;
	public static final short Player_BIT = 2;
	public static final short BRICK_BIT = 4;
	public static final short COIN_BIT = 8;
	public static final short DESTROYED_BIT = 16;
	public static final short OBJECT_BIT = 32;
	public static final short ENEMY_BIT = 64;
	public static final short ENEMY_HEAD_BIT = 128;
	public static final short Player_HEAD_BIT = 512;

	@Override
	public void create () //Start Game
	{
		batch = new SpriteBatch();
		setScreen(new Level2(this));
	}

	@Override
	public void dispose()
    {
		super.dispose();
		batch.dispose();
		GAM.dispose();
	}

	@Override
	public void render ()
	{
		super.render();
	}

}
