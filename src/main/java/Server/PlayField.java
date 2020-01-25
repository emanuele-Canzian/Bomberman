package Server;

import java.util.Arrays;

public class PlayField {

    public static int[][] initPlayField(){
        int vSize = 19;
        int hSize = 19;
        int[][] playField = new int[hSize][vSize];

        for (int row = 0 ; row < hSize; row++){
            System.out.print("\n");
            for(int col = 0; col < vSize; col++){
                if (col % 2 == 0 || row % 2 == 0){
                    playField[row][col] = 1;
                    // System.out.print("1");
                }
                else  {
                    //  System.out.print("2");
                    playField[row][col] = 2;
                }
            }
        }
        System.out.println(Arrays.deepToString(playField));
        return playField;
    }
    public static void player(){

    }
    public static void main(String[] args) {
        initPlayField();
    }
}
