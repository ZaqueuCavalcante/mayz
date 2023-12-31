package mayz;

import java.util.ArrayList;

public class Player {
    int row;
    int column;

    boolean canMoveUp;
    boolean canMoveRight;
    boolean canMoveDown;
    boolean canMoveLeft;

    boolean isDead;
    boolean wonTheGame;

    boolean showOptions;

    ArrayList<String> path;

    public Player(int row, int column) {
        this.row = row;
        this.column = column;
        isDead = false;
        wonTheGame = false;
        showOptions = false;
        path = new ArrayList<String>();
    }

    public void updateMoveOptions(Maze maze) {
        int[] directions = maze.getNextDirections(row, column);
        canMoveUp = directions[0] == 1;
        canMoveRight = directions[1] == 1;
        canMoveDown = directions[2] == 1;
        canMoveLeft = directions[3] == 1;
    }

    public void resetMoveOptions() {
        canMoveUp = false;
        canMoveRight = false;
        canMoveDown = false;
        canMoveLeft = false;
    }

    public void die() {
        isDead = true;
        resetMoveOptions();
    }

    public void win() {
        wonTheGame = true;
        resetMoveOptions();
    }

    public void up() {
        row--;
        path.add("U");
    }

    public void right() {
        column++;
        path.add("R");
    }

    public void down() {
        row++;
        path.add("D");
    }

    public void left() {
        column--;
        path.add("L");
    }

    public void draw(Game game) {
        if (isDead || wonTheGame) {
            drawPath(game);
        }

        drawSelf(game);

        drawMoveOptions(game);
    }

    private void drawSelf(Game game) {
        game.fill(34, 139, 34);
        game.circle(column * game.csz + game.csz / 2, row * game.csz + game.csz / 2, game.csz / 2);
    }

    private void drawMoveOptions(Game game) {
        if (!showOptions) { return; }

        float x = (float) (column * game.csz + game.csz / 2);
        float y = row * game.csz + game.csz / 2;
        float delta = game.csz / 2;
        float radius = game.csz / 4;

        if (canMoveUp) {
            game.circle(x, y - delta, radius);
        }
        if (canMoveRight) {
            game.circle(x + delta, y, radius);
        }
        if (canMoveDown) {
            game.circle(x, y + delta, radius);
        }
        if (canMoveLeft) {
            game.circle(x - delta, y, radius);
        }
    }

    private void drawPath(Game game) {
        float x1 = game.maze.startCell.column * game.csz + game.csz / 2;
        float y1 = game.maze.startCell.row * game.csz + game.csz / 2;
        float x2 = 0;
        float y2 = 0;

        game.fill(34, 139, 34);
        game.stroke(148, 0, 211);
        game.strokeWeight(2);

        for (String direction : path) {
            if (direction.equals("U")) {
                x2 = x1;
                y2 = y1 - game.csz;
            }
            if (direction.equals("R")) {
                x2 = x1 + game.csz;
                y2 = y1;
            }
            if (direction.equals("D")) {
                x2 = x1;
                y2 = y1 + game.csz;
            }
            if (direction.equals("L")) {
                x2 = x1 - game.csz;
                y2 = y1;
            }

            game.line(x1, y1, x2, y2);

            x1 = x2;
            y1 = y2;
        }
        game.strokeWeight(1);
    }
}
