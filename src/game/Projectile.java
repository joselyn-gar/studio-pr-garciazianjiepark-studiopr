package game;

import java.awt.Color;

public class Projectile extends Entity {
    static final double PROJECTILESIZE = 0.01; // for any final variable/magic number make the name in all capitals
    static final double CANVASBOTTOM = 0.0;
    static final double CANVASTOP = 1.0;

    public Projectile(double x, double y, Color color) {
        super(x, y, PROJECTILESIZE, color);
    }

    public void moveUp() {
        setYPosition(this.getYPosition() + PROJECTILESIZE);
    }

    public void moveDown() {
        setYPosition(this.getYPosition() - PROJECTILESIZE);
    }

    public boolean isOutOfBounds() {
        return this.getYPosition() > CANVASTOP || this.getYPosition() < CANVASBOTTOM;
    }

}
