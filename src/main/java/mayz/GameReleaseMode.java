package mayz;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import processing.core.PApplet;

public class GameReleaseMode {
    public static void run() {
        Maze maze = new Maze(Option.RANDOM5000x5000);
        Tree tree = new Tree(maze);

        Instant start = Instant.now();

        while (tree.solutions.size() == 0) {
            tree.goToNextLevel(maze);
            maze.shift();

            if (tree.level % 5 == 0) {
                System.out.println("Level: " + tree.level + " | Nodes: " + tree.levelNodes.size() + " | Filtered nodes: " + tree.getFilteredNodes().size());
            }
        }

        long duration = Duration.between(start, Instant.now()).toMillis();

        ArrayList<String> output = tree.getSolutionsPaths();
        Collections.sort(output, (a, b) -> Integer.compare(a.length(), b.length()));

        System.out.println(output.size() + " paths | " + duration + " ms | " + output.get(0).length() + " moves");

        String fileName = "src/main/java/mayz/solutions/release/solutions_maze_" + maze.option + ".txt";
        File file = new File(fileName);
        OutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file);
            PApplet.saveStrings(outputStream, output.toArray(new String[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
