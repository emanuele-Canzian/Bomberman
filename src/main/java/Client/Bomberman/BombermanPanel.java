package client.Bomberman;

import client.GUI.GUIComponent;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class BombermanPanel extends JPanel implements KeyListener {

    private static final long serialVersionUID = -7322984714527842898L;

    private List<BombermanWall> walls = new ArrayList<>();
    private List<BombermanPlayer> players = new ArrayList<>();

    private int hSize;
    private int vSize;

    public BombermanPanel(int hSize, int vSize) {
        this.hSize = hSize;
        this.vSize = vSize;
        addKeyListener(this);
    }

    public void addWall(BombermanWall wall) {
        this.walls.add(wall);
    }

    public void addPlayer(BombermanPlayer player) {
        this.players.add(player);
    }
    // Hier wird die Bewegung des Spielers umgesetzt
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case 37: // Left
            this.players.get(0).move(-1, 0);
            System.out.println("redrawing? Left");
            break;
        case 38: // Up
            this.players.get(0).move(0, -1);
            System.out.println("redrawing? Up");
            break;
        case 39: // Right
            this.players.get(0).move(1, 0);
            System.out.println("redrawing? Right");
            break;
        case 40: // Down
            this.players.get(0).move(0, 1);
            System.out.println("redrawing? Down");
            break;
        }
        this.revalidate();
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        GUIComponent component = new GUIComponent(0, 0, this.hSize, this.vSize);
        component.setBorder(true);
        component.setBackground(Color.GREEN);
        component.render((Graphics2D) g);

        for (BombermanWall wall : walls) {
            wall.draw(g);
        }

        for (BombermanPlayer player : players) {
            player.draw(g);
        }
    }

    public boolean isFocusTraversable() {
        return true;
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
}
