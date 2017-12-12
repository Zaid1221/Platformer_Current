package com.jarz.game.Sprites;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.jarz.game.Platformer;
import com.jarz.game.Scenes.HUD;
import com.jarz.game.Screens.PlayScreen;

/**
 * Created by Randy on 11/26/2017.
 */

public class Brick extends InteractiveTileObject
{
    public Brick(PlayScreen screen, MapObject object)
    {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(Platformer.BRICK_BIT);
    }

    @Override
    public void onHeadHit(Player player)
    {
        setCategoryFilter(Platformer.DESTROYED_BIT);
        getCell().setTile(null);
        HUD.addScore(200);
        GAM.manager.get("audio/sounds/breakblock.wav", Sound.class).play();
    }

}
