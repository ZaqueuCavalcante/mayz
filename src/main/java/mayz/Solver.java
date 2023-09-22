package mayz;

import java.util.ArrayList;
import java.util.HashMap;

public class Solver {
    public static ArrayList<String> it(Maze maze) {
        // Turn -> Particles
        HashMap<Integer, Particle> particles = new HashMap<Integer, Particle>();

        int[][] ids = MayzUtils.getIds(maze.rows, maze.columns);
        int endCellIndex = ids[maze.endCell.row][maze.endCell.column];

        boolean hasCollision = false;
        int count = 0;

        do {
            // 0 - Inicio do turno
            // Vai entrar alguma particula nesse turno?
            Particle newParticle = new Particle();
            newParticle.isInsideMaze = true;
            newParticle.number = count;
            newParticle.turn = maze.turn;
            particles.put(newParticle.turn, newParticle);
            count ++;

            // 1 - Tabuleiro muda
            maze.shift();

            for (Particle p : particles.values()) {
                if (p.isInsideMaze) {
                    int[] directions = maze.getDirections(p.row, p.column);
                    p.move(directions, ids);

                    

                    hasCollision = maze.currentIsObstacle(p.row, p.column);
                }
            }

            if (hasCollision) { System.out.println("COLLISION"); }

            hasCollision = !MayzUtils.areAllUnique(particles
                .values().stream()
                .filter(x -> x.isInsideMaze && x.index != endCellIndex)
                .mapToInt(x -> x.index)
                .boxed().toList()
            );

            if (hasCollision) { System.out.println("COLLISION"); }

            for (Particle p : particles.values()) {
                if (p.isInsideMaze && p.index == endCellIndex) {
                    p.isInsideMaze = false;
                }
            }
        }
        while (!hasCollision && particles.values().stream().anyMatch(x -> x.isInsideMaze && x.hasMoves()));

        if (particles.values().stream().anyMatch(x -> x.isInsideMaze)) {
            System.out.println("STUCKED");
        }

        return new ArrayList<String>();
    }
}
