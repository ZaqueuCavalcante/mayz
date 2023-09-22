package mayz;

import processing.core.PConstants;

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
    private static float velocity = 0.08f;

    public void move(int[] directions, int[][] ids) {
        // boolean canMoveUp = directions[0] == 1;
        boolean canMoveRight = directions[1] == 1;
        // boolean canMoveDown = directions[2] == 1;
        // boolean canMoveLeft = directions[3] == 1;

        if (canMoveRight) {
            column++;
            path = path + "R";
        }

        index = ids[row][column];
    }

    public void pathMove(int[][] ids) {
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
            vx = column > columnForDraw ? velocity : -velocity;
        }
        if (row != rowForDraw) {
            vy = row > rowForDraw ? velocity : -velocity;
        }

        index = ids[row][column];
        pathIndex++;
    }

    public boolean hasMoves()
    {
        return pathIndex < path.length();
    }

    public void draw(Game game, int endCellIndex) {
        boolean start = index == 0;
        boolean end = index == endCellIndex;
        if (!isInsideMaze && !start && !end) {
            return;
        }

        boolean toRight = vx > 0 && columnForDraw + vx > column;
        boolean toLeft = vx < 0 && columnForDraw + vx < column;
        if (toRight || toLeft) {
            vx = 0;
        } else {
            columnForDraw = columnForDraw + vx;
        }
        float x = columnForDraw * game.csz + game.csz / 2;

        boolean toDown = vy > 0 && rowForDraw + vy > row;
        boolean toUp = vy < 0 && rowForDraw + vy < row;
        if (toDown || toUp) {
            vy = 0;
        } else {
            rowForDraw = rowForDraw + vy;
        }
        float y = rowForDraw * game.csz + game.csz / 2;

        game.fill(255, 0, 0);
        game.circle(x, y, game.csz / 2);

        game.textSize((float) (game.csz * 0.35));
        game.textAlign(PConstants.CENTER);
        game.fill(0);
        game.text(
            turn,
            (float) (columnForDraw * game.csz + game.csz * 0.48),
            (float) ((rowForDraw * game.csz) + game.csz * 0.63)
        );
    }
}
