package com.ratlab.topdowntest;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;

import java.util.Iterator;
import java.util.Objects;

public class GameObject {
    public float x, y, width, height;
    public float[] velocity;
    public Texture texture;
    public Rectangle hitBox;

    public GameObject(float x, float y, float width, float height, Texture texture) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.texture = texture;
        this.velocity = new float[2];
        this.hitBox = new Rectangle(this.x + 5, this.y + 5, this.width - 5, this.height - 5);
    }

    public boolean colliderCheck() {
        for (GameObject obj : World.objs) {
            if (obj == this)
                continue;
            if (obj.hitBox.overlaps(this.hitBox)) {
                return true;
            }
        }
        return false;
    }

    public void move(String axis, float speed) {
        float tX = this.x, tY = this.y;
        if (Objects.equals(axis, "horizontal")) {
            this.hitBox.x += speed;
            if (colliderCheck()) {
                int adjust = 0;
                if (this.hitBox.x < tX)
                    adjust = -2;
                else
                    adjust = 2;
                this.hitBox.x = tX + adjust;
            }
            else
                this.x += speed;
        }
        else if (Objects.equals(axis, "vertical")) {
            this.hitBox.y += speed;
            if (colliderCheck()) {
                int adjustY = 0;
                if (this.hitBox.y < tY)
                    adjustY = -2;
                else
                    adjustY = 2;
                this.hitBox.y = tY + adjustY;
            }
            else
                this.y += speed;
        }
    }

    public void applyForce(String axis, float velocityVar) {
        if (Objects.equals(axis, "horizontal"))
            this.velocity[0] += velocityVar;
        else
            this.velocity[1] += velocityVar;
        System.out.println(this.velocity[0]);
    }

    public void update() {
        this.physicsUpdate();
    }

    public void physicsUpdate() {
        // Implement physics code here
        this.hitBox.setPosition(this.x, this.y); // Sync the hitBox to the position
        this.move("horizontal", this.velocity[0]);
        this.move("vertical", this.velocity[1]);
        for (int i = 0; i < this.velocity.length; i++) {
            if (this.velocity[i] > 0) {
                this.velocity[i] -= World.friction;
            }
            //System.out.println(this.velocity[i]);
        }
    }
}
