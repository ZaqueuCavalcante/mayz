package mayz;

public class GameFunMode extends Game {
    Player player;

    public void settings() {
        maze = new Maze(Option.SMALL);

        player = new Player(maze.startCell.row, maze.startCell.column);
        player.updateMoveOptions(maze);

        size(maze.width, maze.height);
        csz = maze.cellSize;
    }

    public void draw() {
        background(100);
        fill(255);
        stroke(0);
        maze.draw(this);
        player.draw(this);
    }

    public void keyPressed() {
        if (player.isDead || player.wonTheGame) {
            return;
        }

        if (keyCode == O) {
            player.showOptions = !player.showOptions;
        }

        if (keyCode == N) {
            maze.showNeighbors = !maze.showNeighbors;
        }

        if (keyCode >= 37 && keyCode <= 40) {
            if (keyCode == UP && player.row > 0) {
                player.up();
            }
            if (keyCode == RIGHT && player.column < maze.columns - 1) {
                player.right();
            }
            if (keyCode == DOWN && player.row < maze.rows - 1) {
                player.down();
            }
            if (keyCode == LEFT && player.column > 0) {
                player.left();
            }
            
            maze.shift();
            player.updateMoveOptions(maze);

            if (maze.currentIsObstacle(player.row, player.column)) {
                player.die();
            }

            if (maze.currentIsEnd(player.row, player.column)) {
                player.win();
            }
        }
    }
}
