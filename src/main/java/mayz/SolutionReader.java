package mayz;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import processing.core.PApplet;

public class SolutionReader {
    public static ArrayList<String> ReadReplay(String option) {
        File file = new File("src/main/java/mayz/replays/replay_maze_" + option + ".txt");
        InputStream input;
        ArrayList<String> paths = new ArrayList<String>();

        try {
            input = new FileInputStream(file);
            String[] lines = PApplet.loadStrings(input);
            paths = new ArrayList<String>(Arrays.asList(lines));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return paths;
    }
}
