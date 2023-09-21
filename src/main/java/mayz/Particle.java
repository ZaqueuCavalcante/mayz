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

    float rowForDraw;
    float columnForDraw;
    float vx;
    float vy;
    public void move(int[][] ids) {
        if (!hasMoves()) return;

        rowForDraw = row;
        columnForDraw = column;

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

        if (column != columnForDraw) {
            vx = column > columnForDraw ? 0.05f : -0.05f;
        }
        if (row != rowForDraw) {
            vy = row > rowForDraw ? 0.05f : -0.05f;
        }

        index = ids[row][column];
        pathIndex++;
    }

    public boolean hasMoves()
    {
        return pathIndex < path.length();
    }
}
