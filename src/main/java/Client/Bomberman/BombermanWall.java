package client.Bomberman;

import client.GUI.GUIComponent;

import java.awt.*;

public class BombermanWall {
    private int x;
    private int y;
    private int hSize;
    private int vSize;

    public BombermanWall(int x, int y, int hSize, int vSize) {
        this.x = x;
        this.y = y;
        this.hSize = hSize;
        this.vSize = vSize;
    }

    public void draw(Graphics g) {
        GUIComponent component = new GUIComponent(this.x * hSize, this.y * vSize, hSize, vSize);
        component.setBorder(true);
        component.setBackground(Color.BLACK);
        component.render((Graphics2D) g);
    }
}
