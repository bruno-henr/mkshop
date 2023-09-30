package src.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player extends Entity {
    private BufferedImage[][] animations;

    private boolean left, up, right, down, jump;
    private boolean moving = false, attacking = false;

    public boolean isAttacking() {
        return attacking;
    }

    public void setAttacking(boolean attacking) {
        this.attacking = attacking;
    }

    public Player(float x, float y, int width, int height) {
        super(x, y, width, height);
    }

    public void render(Graphics g) {}

    public void changeDx(int dx) {
        this.x += dx;
    }

    public void changeDy(int dy) {
        this.y += dy;
    }
}
