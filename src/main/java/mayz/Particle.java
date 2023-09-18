package mayz;

public class Particle {
    int row;
    int column;
    int index;

    int turn;
    int number;

    String path;
    int pathIndex;

    boolean isInsideMaze;

    public void move(int[][] ids) {
        if (!hasMoves()) return;

        String direction = String.valueOf(path.charAt(pathIndex)).toString();

        if (direction.equals("U")) {
            row--;
        }
        if (direction.equals("R")) {
            column++;
        }
        if (direction.equals("D")) {
            row++;
        }
        if (direction.equals("L")) {
            column--;
        }

        index = ids[row][column];
        pathIndex++;
    }

    public boolean hasMoves()
    {
        return pathIndex < path.length();
    }
}
