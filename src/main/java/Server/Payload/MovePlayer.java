package Server.Payload;

/**
 * MovePlayer
 */
public class MovePlayer {
    private int player;
    private Coordinate position;
    private Coordinate direction;

    public int getPlayer() {
        return player;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public Coordinate getPosition() {
        return position;
    }

    public void setPosition(Coordinate position) {
        this.position = position;
    }

    public Coordinate getDirection() {
        return direction;
    }

    public void setDirection(Coordinate direction) {
        this.direction = direction;
    }
}