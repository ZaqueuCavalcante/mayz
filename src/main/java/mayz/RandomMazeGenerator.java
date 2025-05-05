package mayz;

import java.io.File;
import java.util.Random;
import java.util.ArrayList;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

import processing.core.PApplet;

public class RandomMazeGenerator {
    public static void run() {
        int size = 1_500;
        ArrayList<String> lines = new ArrayList<>();
        lines.add("1000 1000 10");

        Random r = new Random();

        for (int i = 0; i < size; i++) {
            StringBuilder line = new StringBuilder(size*2);
            for (int j = 0; j < size; j++) {
                if (r.nextInt(100) < 25) {
                    line.append("1");
                } else {
                    line.append("0");
                }
            }
            lines.add(line.toString().trim());
        }

        lines.set(1, "3" + lines.get(1).substring(1));
        lines.set(size, lines.get(size).substring(0, size-1) + "4");

        String fileName = "src/main/java/mayz/data/maze_" + size + "x" + size + ".txt";
        File file = new File(fileName);
        OutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file);
            PApplet.saveStrings(outputStream, lines.toArray(new String[0]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
