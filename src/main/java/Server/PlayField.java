package Server;

import java.util.Arrays;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import static spark.Spark.*;

import Server.Payload.*;

public class PlayField {

    public static int[][] initPlayField(int vSize, int hSize) {
        int[][] playField = new int[hSize][vSize];

        for (int row = 0; row < hSize; row++) {
            System.out.print("\n");
            for (int col = 0; col < vSize; col++) {
                if (col % 2 == 0 || row % 2 == 0) {
                    playField[row][col] = 1;
                } else {
                    playField[row][col] = 2;
                }
            }
            System.out
                    .println(Arrays.stream(playField[row]).mapToObj(String::valueOf).collect(Collectors.joining("  ")));
        }
        return playField;
    }

    public static void player() {

    }

    public static void main(String[] args) {
        int hSize = 20;
        int vSize = 20;
        int[][] playfield = initPlayField(hSize, vSize);
        Gson gson = new Gson();

        path("/api", () -> {
            get("/play-field", "application/json", (req, res) -> playfield, new JsonTransformer());

            // Handle player movement
            // See "MovePlayer.java" for payload specification
            post("/move-player", (request, response) -> {
                try {
                    MovePlayer move = gson.fromJson(request.body(), MovePlayer.class);
                    Coordinate nextPosition = move.getPosition().move(move.getDirection());
                    int x = nextPosition.getX();
                    int y = nextPosition.getY();

                    // Check if new position is valid and return the result of this check
                    return nextPosition.isNotOutOfBounds(hSize, vSize) && playfield[y][x] != 2;
                } catch (Exception e) {
                    System.out.println(e);
                    e.printStackTrace();
                    return false;
                }
            }, new JsonTransformer());
        });
    }
}
