package com.jarz.game.Tools;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.jarz.game.Platformer;
import com.jarz.game.Sprites.Enemies.Enemy;
import com.jarz.game.Sprites.InteractiveTileObject;
import com.jarz.game.Sprites.Player;

/**
 * This Class Handles ALL Contact between Player, Objects, and Enemies
 */
public class WorldContactListener implements ContactListener {
    @Override
    public void beginContact(Contact contact) {
        Fixture fixA = contact.getFixtureA();
        Fixture fixB = contact.getFixtureB();

        int cDef = fixA.getFilterData().categoryBits | fixB.getFilterData().categoryBits;

        switch (cDef){
            case Platformer.Player_HEAD_BIT | Platformer.BRICK_BIT:
            case Platformer.Player_HEAD_BIT | Platformer.COIN_BIT:
                if(fixA.getFilterData().categoryBits == Platformer.Player_HEAD_BIT)
                    ((InteractiveTileObject) fixB.getUserData()).onHeadHit((Player) fixA.getUserData());
                else
                    ((InteractiveTileObject) fixA.getUserData()).onHeadHit((Player) fixB.getUserData());
                break;
            case Platformer.ENEMY_HEAD_BIT | Platformer.Player_BIT:
                if(fixA.getFilterData().categoryBits == Platformer.ENEMY_HEAD_BIT)
                    ((Enemy)fixA.getUserData()).hitOnHead((Player) fixB.getUserData());
                else
                    ((Enemy)fixB.getUserData()).hitOnHead((Player) fixA.getUserData());
                break;
            case Platformer.ENEMY_BIT | Platformer.OBJECT_BIT:
                if(fixA.getFilterData().categoryBits == Platformer.ENEMY_BIT)
                    ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                else
                    ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
            case Platformer.Player_BIT | Platformer.ENEMY_BIT:
                if(fixA.getFilterData().categoryBits == Platformer.Player_BIT)
                    ((Player) fixA.getUserData()).hit((Enemy)fixB.getUserData());
                else
                    ((Player) fixB.getUserData()).hit((Enemy)fixA.getUserData());
                break;
            case Platformer.ENEMY_BIT | Platformer.ENEMY_BIT:
                ((Enemy)fixA.getUserData()).reverseVelocity(true, false);
                ((Enemy)fixB.getUserData()).reverseVelocity(true, false);
                break;
        }
    }

    @Override
    public void endContact(Contact contact) {
    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
