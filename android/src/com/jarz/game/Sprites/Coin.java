package com.jarz.game.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.jarz.game.Platformer;
import com.jarz.game.Scenes.HUD;
import com.jarz.game.Screens.PlayScreen;


/**
 * Created by Randy on 11/26/2017.
 */

public class Coin extends InteractiveTileObject
{
    private static TiledMapTileSet tileSet;
    private final int BLANK_COIN = 28;

    public Coin(PlayScreen screen, MapObject object)
    {
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(Platformer.COIN_BIT);
    }

    @Override
    public void onHeadHit(Player player)
    {
        if(getCell().getTile().getId() != BLANK_COIN)
        {
            GAM.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            HUD.addScore(100);
        }
        else
            GAM.manager.get("audio/sounds/bump.wav", Sound.class).play();
    }

}
