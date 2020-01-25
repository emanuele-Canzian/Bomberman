package client.Bomberman;

import client.Activity.Activity;
import client.GUI.GUIComponent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class BombermanPanel extends Container {

    private static final long serialVersionUID = -7322984714527842898L;

    private static final List<Activity> ACTIVITIES = new ArrayList<>();

    private Bomberman bomberman;

    public BombermanPanel(Bomberman bomberman) {
        this.bomberman = bomberman;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        GUIComponent component = new GUIComponent(200, 200, 200, 200);
        component.setBorder(true);
        component.setBackground(Color.GREEN);
        component.render((Graphics2D) g);

        bomberman.getThread().nowait();
    }
}
