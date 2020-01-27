package Client.Bomberman;

import Client.GUI.GUIComponent;
import java.awt.*;

public class BombermanPlayer {
    private int x;
    private int y;
    private final int hSize;
    private final int vSize;
    private final int hMargin;
    private final int vMargin;

    public BombermanPlayer(Color color, int x, int y, int hSize, int vSize) {
        this.x = x;
        this.y = y;
        this.hSize = hSize;
        this.vSize = vSize;
        this.hMargin = (int) (hSize * 0.1);
        this.vMargin = (int) (vSize * 0.1);
    }

    public void move(int horizontal, int vertical) {
        this.x += horizontal;
        this.y += vertical;
        System.out.println("new pos " + x + " " + y);
    }

    public void draw(final Graphics g) {
        final GUIComponent component = new GUIComponent(this.x * hSize + hMargin, this.y * vSize + vMargin,
                hSize - (hMargin * 2), vSize - (vMargin * 2));
        component.setBorder(true);
        component.setBackground(Color.BLUE);
        component.render((Graphics2D) g);
    }
}
