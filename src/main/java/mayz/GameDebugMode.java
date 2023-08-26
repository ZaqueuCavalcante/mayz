package mayz;

public class GameDebugMode extends Game {
    Tree tree;

    public void settings() {
        maze = new Maze("02_blue_pen");
        tree = new Tree(maze);

        size(maze.width, maze.height);
        CIZE = maze.cellSize;
    }

    public void draw() {
        background(100);
        fill(255);
        stroke(0);
        maze.draw(this);
        tree.drawPathsOnMaze(this);
    }

    public void keyPressed() {
        if (keyCode == 10) { // Enter
            maze.showNeighbors = false;
            goToNextStep();
        }
    }

    public void goToNextStep() {
        tree.goToNextLevel(maze);
        maze.shift();
    }
}
