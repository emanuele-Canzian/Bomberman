package Client.GUI;

import java.awt.*;

public class GUIComponent {

    private int x, y, width, height;
    private Color background, borderColor;
    private boolean border;

    public GUIComponent(int width, int height) {
        this(0, 0, width, height);
    }

    public GUIComponent(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getBackground() {
        return background;
    }

    public void setBackground(Color background) {
        this.background = background;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public boolean isBorder() {
        return border;
    }

    public void setBorder(boolean border) {
        this.border = border;
    }


    public void revalidate() {

    }

    public void render(Graphics2D g) {
        if(!border) {
            g.setColor(background);
            g.fillRect(x, y, width, height);
        } else {
            g.setColor(background);
            g.fillRect(x+1, y+1, width-1, height-1);
            g.setColor(borderColor);
            g.drawRect(x, y, width-1, height-1);
        }
    }
}
