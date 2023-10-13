package mayz;

import java.util.ArrayList;

public class GameReplayMode extends Game {
    public void settings() {
        maze = new Maze(Option.PAC_MAN);
        size(maze.width, maze.height);
        csz = maze.cellSize;

        ArrayList<String> paths = SolutionReader.ReadReplay(maze.option);
        maze.setupReplay(paths);
    }

    public void draw() {
        background(100);
        fill(255);
        stroke(0);
        maze.draw(this);
    }

    public void keyPressed() {
        if (keyCode == ENTER) {
            maze.replay();
        }
    }
}
