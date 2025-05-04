package mayz;

public final class MayzUtils {
    public static int[][] getIds(int rows, int columns) {
        int id = 0;
        int[][] ids = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                ids[row][column] = id;
                id++;
            }
        }
        return ids;
    }
}
