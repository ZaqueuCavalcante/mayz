package mayz;

public class GameDebugMode extends Game {
    Tree tree;

    public void settings() {
        maze = new Maze(Option.RANDOM100x100);
        tree = new Tree(maze);

        size(maze.width, maze.height);
        csz = maze.cellSize;
    }

    public void draw() {
        background(100);
        fill(255);
        stroke(0);
        maze.draw(this);
        tree.drawPathsOnMaze(this);
    }

    public void keyPressed() {
        if (keyCode == ENTER) {
            tree.goToNextLevel(maze);
            maze.shift();
        }
    }
}
