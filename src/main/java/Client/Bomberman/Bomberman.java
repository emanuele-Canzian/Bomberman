package Client.Bomberman;

import java.awt.Color;
import javax.swing.JFrame;

import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;

public class Bomberman {

    private static final int WIDTH = 1000, HEIGHT = 650;
    private static final int H_SIZE = 600, V_SIZE = 600;

    private JFrame frame;
    private BombermanPanel panel;
    private BombermanThread thread;

    public static void main(String[] args) {
        new Bomberman();
    }

    public Bomberman() {
        frame = new JFrame("Bomberman");
        frame.setSize(WIDTH, HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        panel = new BombermanPanel(H_SIZE, V_SIZE);
        frame.setContentPane(panel);

        JSONArray column = Unirest.get("http://localhost:4567/api/play-field").asJson().getBody().getArray();

        int hBlockSize = H_SIZE / column.getJSONArray(0).length();
        int vBlockSize = H_SIZE / column.length();

        for (int y = 0; y < column.length(); y++) {
            JSONArray row = column.getJSONArray(y);
            for (int x = 0; x < row.length(); x++) {
                if (row.getInt(x) == 2) {
                    BombermanWall wall = new BombermanWall(x, y, hBlockSize, vBlockSize);
                    panel.addWall(wall);
                }
            }
        }
        panel.addPlayer(new BombermanPlayer(Color.RED, 0, 0, hBlockSize, vBlockSize));

        thread = new BombermanThread(panel);
        thread.start();
    }

    public JFrame getFrame() {
        return frame;
    }

    public BombermanThread getThread() {
        return thread;
    }
}
