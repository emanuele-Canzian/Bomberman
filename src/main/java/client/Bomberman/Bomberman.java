package client.Bomberman;

import javax.swing.JFrame;

public class Bomberman {

    private static final int WIDTH = 1000, HEIGHT = 650;

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

        panel = new BombermanPanel(this);
        frame.setContentPane(panel);

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
