package com.ratlab.topdownryan;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;

public class GameObject extends Rectangle {
    public float x;
    public float y;
    public float width;
    public float height;
    public float size;
    public Rectangle hitBox;

    public GameObject(int x, int y, int width, int height, float size) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.size = size;
        this.hitBox = new Rectangle(this.x, this.y, this.width, this.height);
    }

    public void Colishion() {
        if (this.GameObject.overlaps(coolGuy)) {
            coliding();
        }
    }

}