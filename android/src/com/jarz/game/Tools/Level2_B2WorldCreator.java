package com.jarz.game.Tools;

import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.jarz.game.Platformer;
import com.jarz.game.Screens.Level2;
import com.jarz.game.Screens.PlayScreen;
import com.jarz.game.Sprites.Brick;
import com.jarz.game.Sprites.Coin;
import com.jarz.game.Sprites.Enemies.Enemy;
import com.jarz.game.Sprites.Enemies.Goomba;


public class Level2_B2WorldCreator
{
    public Level2_B2WorldCreator(Level2 screen)
    {
        World world = screen.getWorld();
        TiledMap map = screen.getMap();
        //create body and fixture variables
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        Body body;

        //create ground bodies/fixtures
        for(MapObject object : map.getLayers().get(1).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Platformer.PPM, (rect.getY() + rect.getHeight() / 2) / Platformer.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Platformer.PPM, rect.getHeight() / 2 / Platformer.PPM);
            fdef.shape = shape;
            body.createFixture(fdef);
        }

        //create block bodies/fixtures
        for(MapObject object : map.getLayers().get(2).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Platformer.PPM, (rect.getY() + rect.getHeight() / 2) / Platformer.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Platformer.PPM, rect.getHeight() / 2 / Platformer.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = Platformer.OBJECT_BIT;
            body.createFixture(fdef);
        }

        //create spike bodies/fixtures
        for(MapObject object : map.getLayers().get(5).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect = ((RectangleMapObject) object).getRectangle();

            bdef.type = BodyDef.BodyType.StaticBody;
            bdef.position.set((rect.getX() + rect.getWidth() / 2) / Platformer.PPM, (rect.getY() + rect.getHeight() / 2) / Platformer.PPM);

            body = world.createBody(bdef);

            shape.setAsBox(rect.getWidth() / 2 / Platformer.PPM, rect.getHeight() / 2 / Platformer.PPM);
            fdef.shape = shape;
            fdef.filter.categoryBits = Platformer.OBJECT_BIT;
            body.createFixture(fdef);
        }

    }

}
