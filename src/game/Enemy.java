package game;

import java.awt.Color;

public class Enemy extends Entity {
    static final double SPEEDMULTIPLIER = 0.05;
    static final double ENENMYSIZE = .03;
    static final double XMULTIPLIER = 0.9;
    static final double YMULTIPLIER = 0.8;
    static final double YMINIMUM = .15;
    static final double CANVASBOTTOM = 0.0;
    static final double CANVASTOP = 1.0;
    private double xSpeed;
    private double ySpeed;
    private long lastFired;

    public Enemy() {
        super(Math.random() * XMULTIPLIER, Math.random() * YMULTIPLIER + YMINIMUM, ENENMYSIZE, Color.RED);
        xSpeed = Math.random() * SPEEDMULTIPLIER;
        ySpeed = Math.random() * SPEEDMULTIPLIER;
        lastFired = System.currentTimeMillis();
    }

    public void move() {
        bounceOffWall();
        setXPosition(this.getXPosition() + xSpeed);
        setYPosition(this.getYPosition() + ySpeed);
    }

    private void bounceOffWall() {
        if (this.getXPosition() < CANVASBOTTOM) {
            xSpeed = -xSpeed;
        }
        if (this.getXPosition() > CANVASTOP) {
            xSpeed = -xSpeed;
        }
        if (this.getYPosition() > CANVASTOP) {
            ySpeed = -ySpeed;
        }
        if (this.getYPosition() < 0.15) {
            ySpeed = -ySpeed;
        }
    }

    public boolean isFiring() {
        long now = System.currentTimeMillis();
        if (now - lastFired > 1000) {
            lastFired = now;
            return true;
        } else {
            return false;
        }
    }

}
