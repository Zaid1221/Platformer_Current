package com.jarz.game.Tools;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

/**
 * Created by Randy on 12/4/2017.
 */

public class GameAssetManager
{
    public final AssetManager manager = new AssetManager();


    public void loadAssets()
    {
        manager.load("audio/music/BY8bit.mp3", Music.class);
        manager.load("audio/music/Mario.ogg", Music.class);
        manager.load("audio/music/cutman.mp3", Music.class);
        manager.load("audio/sounds/breakblock.wav", Sound.class);
        manager.load("audio/sounds/coin.wav", Sound.class);
        manager.load("audio/sounds/bump.wav", Sound.class);
        manager.load("audio/sounds/stomp.wav", Sound.class);
    }

    public void dispose()
    {
        manager.dispose();
    }
}
