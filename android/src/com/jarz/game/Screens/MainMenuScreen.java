package com.jarz.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.jarz.game.Platformer;

/**
 * Created by user on 12/4/2017.
 */

public class MainMenuScreen implements Screen
{
    Platformer game;

    Texture exitButtonActive;
    Texture exitButtonInactive;
    Texture playButtonActive;
    Texture playButtonInactive;
    Texture highScoreButtonActive;
    Texture highScoreButtonInactive;

    private final int BUTTON_WIDTH = 300;
    private final int BUTTON_HEIGHT = 150;

    public MainMenuScreen(Platformer game)
    {
        this.game = game;
        exitButtonActive = new Texture("menubuttons/exitactive.png");
        exitButtonInactive = new Texture("menubuttons/exitinactive.png");
        playButtonActive = new Texture("menubuttons/playactive.png");
        playButtonInactive = new Texture("menubuttons/playinactive.png");
        highScoreButtonActive = new Texture("menubuttons/scoresactive.png");
        highScoreButtonInactive = new Texture("menubuttons/scoresinactive.png");

    }

    @Override
    public void show()
    {

    }
    //Handles Inputs from the Player (Allows Movement)
    public void handleInput(float dt)
    {
        if(Gdx.input.isKeyPressed(Input.Keys.UP))
        {
            this.dispose();
            game.setScreen(new PlayScreen(game));
        }
    }
    @Override
    public void render(float delta)
    {
        //Clears Screen
        Gdx.gl.glClearColor(0,0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        game.batch.begin();

        if(Gdx.input.getX() < 100 ) {
            game.batch.draw(exitButtonActive, game.V_WIDTH /2 - BUTTON_WIDTH /2, 100, BUTTON_WIDTH, BUTTON_HEIGHT);
        }
        else
            game.batch.draw(exitButtonInactive, game.V_WIDTH /2 - BUTTON_WIDTH /2, 100, BUTTON_WIDTH, BUTTON_HEIGHT);

        game.batch.end();

        handleInput(delta);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
