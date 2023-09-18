package mayz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class MayzUtils {
    public static HashMap<Integer, Particle> toParticleHashMap(ArrayList<String> paths) {
        // Turn -> Particles
        HashMap<Integer, Particle> particles = new HashMap<>();

        int count = 0;
        for (String path : paths) {
            String[] splitedPath = path.split(" ");
            String turnAsString = splitedPath[0];

            Particle p = new Particle();
            p.number = count;
            p.turn = Integer.parseInt(turnAsString);
            p.path = splitedPath.length == 2 ? splitedPath[1] : "";
            particles.put(p.turn, p);
            count++;
        }

        return particles;
    }

    public static int[][] getIds(int rows, int columns) {
        int id = 0;
        int[][] ids = new int[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                ids[row][column] = id;
                id++;
            }
        }
        return ids;
    }

    public static <T> boolean areAllUnique(List<T> list){
        Set<T> set = new HashSet<>();

        for (T t: list){
            if (!set.add(t))
                return false;
        }
        
        return true;
    }
}
