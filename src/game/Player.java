package game;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player extends Entity {
    static final double STARTINGX = 0.5;
    static final double STARTINGY = 0.05;
    static final double PLAYERSIZE = 0.03;
    static final double PLAYERMOVEMENTAMOUNT = 0.01;
    static final double FIRERATE = 500;
    private long lastFired;

    public Player() {
        super(STARTINGX, STARTINGY, PLAYERSIZE, Color.BLACK);
        lastFired = System.currentTimeMillis();
    }

    public void move() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            setXPosition(this.getXPosition() - PLAYERMOVEMENTAMOUNT);
        }
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            setXPosition(this.getXPosition() + PLAYERMOVEMENTAMOUNT);
        }
    }

    public boolean isFiring() {
        long now = System.currentTimeMillis();
        if (now - lastFired > FIRERATE && StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
            lastFired = now;
            return true;
        } else {
            return false;
        }
    }
}
