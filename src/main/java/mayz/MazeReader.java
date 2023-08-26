package mayz;

import java.io.File;
import java.util.Arrays;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import processing.core.PApplet;

public class MazeReader {
    public static MazeData Read(String option) {
        File file = new File("src/main/java/mayz/data/maze_" + option + ".txt");
        InputStream input;
        String[] lines = new String[0];

        MazeData data = new MazeData();

        try {
            input = new FileInputStream(file);
            lines = PApplet.loadStrings(input);

            data.width = Integer.parseInt(lines[0].split(" ")[0]);
            data.height = Integer.parseInt(lines[0].split(" ")[1]);
            data.cellSize = Integer.parseInt(lines[0].split(" ")[2]);

            for (int i = 1; i < lines.length; i++) {
                lines[i] = lines[i].replaceAll(" ", "");
            }

            data.lines = Arrays.copyOfRange(lines, 1, lines.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return data;
    }
}
