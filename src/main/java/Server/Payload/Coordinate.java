package Server.Payload;

/**
 * Coordinate
 */
public class Coordinate {
    private int x;
    private int y;

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public Coordinate move(Coordinate direction) {
        Coordinate next = new Coordinate();
        next.setX(this.getX() + direction.getX());
        next.setY(this.getY() + direction.getY());

        return next;
    }

    public boolean isNotOutOfBounds(int hSize, int vSize) {
        return this.x >= 0 && this.y >= 0 && this.x < hSize && this.y < vSize;
    }
}