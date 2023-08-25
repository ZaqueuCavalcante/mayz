package mayz;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import processing.core.PApplet;

public class MazeReader {
    public static String[] Read(String option) {
        File file = new File("src/main/java/mayz/data/maze_" + option + ".txt");
        InputStream input;
        String[] lines = new String[0];

        try {
            input = new FileInputStream(file);
            lines = PApplet.loadStrings(input);

            for (int i = 0; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll(" ", "");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
