package com.ratlab.topdowntest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;
import java.util.Objects;

public class GameObject {
    public float x, y, width, height;
    public Texture texture;
    public Rectangle hitbox;

    public GameObject(float x, float y, float width, float height, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.hitbox = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public boolean colliderCheck() {
        for (Iterator<GameObject> iter = World.objs.iterator(); iter.hasNext(); ) {
            GameObject obj = iter.next();
            if (obj == this)
                continue;
            if (obj.hitbox.overlaps(this.hitbox)) {
                return true;
            }
        }
        return false;
    }

    public void move(String axis, float speed) {
        float tX = this.x, tY = this.y;
        if (Objects.equals(axis, "horizontal")) {
            this.x += speed;
            if (colliderCheck())
                this.x = tX;
        }
        else if (Objects.equals(axis, "vertical")) {
            this.y += speed;
            if (colliderCheck())
                this.y = tY;
        }
    }

    public void update() {
        this.physicsUpdate();
    }

    public void physicsUpdate() {
        // Implement physics code here
        this.hitbox.setPosition(this.x, this.y); // Sync the hitbox to the position
    }
}
