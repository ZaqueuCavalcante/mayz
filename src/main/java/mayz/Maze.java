package mayz;

import java.util.ArrayList;
import java.util.HashMap;

import processing.core.PConstants;

public class Maze {
    String option;

    int width;
    int height;
    int cellSize;

    int rows;
    int columns;

    Cell startCell;
    Cell endCell;

    int[][] current;
    int[][] next;

    int[][] currentNeighbors;
    boolean showNeighbors = false;

    int turn;

    private boolean isStatic = false;

    // Turn -> Particles
    HashMap<Integer, Particle> particles = new HashMap<Integer, Particle>();

    int[][] ids;
    int endCellIndex;

    boolean hasCollision;

    public Maze(Option option) {
        New(option);
    }

    public Maze(Option option, boolean isStatic) {
        this.isStatic = isStatic;
        New(option);
    }

    private void New(Option option) {
        this.option = option.getValue();

        initialSetup();

        calculateNeighbors();

        calculateNext();

        if (isStatic) next = current;
    }

    public void shift() {
        turn++;

        if (isStatic) return;

        current = next;
        calculateNeighbors();
        calculateNext();
    }

    public int[] getDirections(int row, int column) {
        int up = ((row - 1) >= 0 && current[row - 1][column] != CellType.OBSTACLE) ? 1 : 0;
        int right = ((column + 1) < columns && current[row][column + 1] != CellType.OBSTACLE) ? 1 : 0;
        int down = ((row + 1) < rows && current[row + 1][column] != CellType.OBSTACLE) ? 1 : 0;
        int left = ((column - 1) >= 0 && current[row][column - 1] != CellType.OBSTACLE) ? 1 : 0;

        return new int[] { up, right, down, left };
    }

    public int[] getNextDirections(int row, int column) {
        int up = ((row - 1) >= 0 && next[row - 1][column] != CellType.OBSTACLE) ? 1 : 0;
        int right = ((column + 1) < columns && next[row][column + 1] != CellType.OBSTACLE) ? 1 : 0;
        int down = ((row + 1) < rows && next[row + 1][column] != CellType.OBSTACLE) ? 1 : 0;
        int left = ((column - 1) >= 0 && next[row][column - 1] != CellType.OBSTACLE) ? 1 : 0;

        return new int[] { up, right, down, left };
    }

    private void initialSetup() {
        MazeData mazeData = MazeReader.Read(option);

        width = mazeData.width;
        height = mazeData.height;
        cellSize = mazeData.cellSize;
        String[] lines = mazeData.lines;

        rows = lines.length;
        columns = lines[0].length();

        current = new int[rows][columns];

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int value = Integer.parseInt(String.valueOf(lines[row].charAt(column)));
                current[row][column] = value;

                if (currentIsStart(row, column)) {
                    startCell = new Cell(row, column, value);
                } else if (currentIsEnd(row, column)) {
                    endCell = new Cell(row, column, value);
                }
            }
        }
    }

    public boolean currentIsStart(int row, int column) {
        return current[row][column] == CellType.START;
    }

    public boolean currentIsEnd(int row, int column) {
        return current[row][column] == CellType.END;
    }

    public boolean currentIsObstacle(int row, int column) {
        return current[row][column] == CellType.OBSTACLE;
    }

    public boolean currentIsEmpty(int row, int column) {
        return current[row][column] == CellType.EMPTY;
    }

    public boolean isSolution(String path) {
        int row = startCell.row;
        int column = startCell.column;

        for (char c : path.toCharArray()) {
            shift();

            String direction = String.valueOf(c).toString();

            if (direction.equals("U")) {
                row--;
            }
            if (direction.equals("R")) {
                column++;
            }
            if (direction.equals("D")) {
                row++;
            }
            if (direction.equals("L")) {
                column--;
            }

            if (currentIsObstacle(row, column)) {
                return false;
            }
        }

        return row == endCell.row && column == endCell.column;
    }

    public boolean isSolution(ArrayList<String> paths) {
        particles = MayzUtils.toParticleHashMap(paths);

        ids = MayzUtils.getIds(rows, columns);
        endCellIndex = ids[endCell.row][endCell.column];

        hasCollision = false;

        do {
            Particle newParticle = particles.get(turn);
            if (newParticle != null) {
                newParticle.isInsideMaze = true;
            }

            shift();

            for (Particle p : particles.values()) {
                if (p.isInsideMaze) {
                    p.pathMove(ids);
                    hasCollision = currentIsObstacle(p.row, p.column);
                }
            }

            if (hasCollision) {
                return false;
            }

            hasCollision = !MayzUtils.areAllUnique(particles
                .values().stream()
                .filter(x -> x.isInsideMaze && x.index != endCellIndex)
                .mapToInt(x -> x.index)
                .boxed().toList()
            );

            if (hasCollision) {
                return false;
            }

            for (Particle p : particles.values()) {
                if (p.isInsideMaze && p.index == endCellIndex) {
                    p.isInsideMaze = false;
                }
            }
        }
        while (!hasCollision && particles.values().stream().anyMatch(x -> x.isInsideMaze && x.hasMoves()));

        if (particles.values().stream().anyMatch(x -> x.isInsideMaze)) {
            return false;
        }

        return true;
    }

    public void setupReplay(ArrayList<String> paths) {
        particles = MayzUtils.toParticleHashMap(paths);

        particles.values().stream().forEach(x -> x.index = -1);

        particles.values().iterator().next().index = 0;

        ids = MayzUtils.getIds(rows, columns);
        endCellIndex = ids[endCell.row][endCell.column];

        hasCollision = false;
    }

    public void replay() {
        Particle newParticle = particles.get(turn);
        if (newParticle != null) {
            newParticle.isInsideMaze = true;
        }

        shift();

        for (Particle p : particles.values()) {
            if (p.isInsideMaze) {
                p.pathMove(ids);
                hasCollision = currentIsObstacle(p.row, p.column);
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

        if (particles.values().stream().anyMatch(x -> x.isInsideMaze)) {
            System.out.println("STUCKED");
        }
    }

    private void calculateNeighbors() {
        currentNeighbors = new int[rows][columns];

        for (int column = 0; column < columns; column++) {
            currentNeighbors[0][column] = getNeighborsTopRow(column);
            currentNeighbors[rows - 1][column] = getNeighborsDownRow(rows - 1, column);
        }

        for (int row = 1; row < rows - 1; row++) {
            currentNeighbors[row][0] = getNeighborsLeftColumn(row);
            currentNeighbors[row][columns - 1] = getNeighborsRightColumn(row, columns - 1);
        }

        for (int row = 1; row < rows - 1; row++) {
            for (int column = 1; column < columns - 1; column++) {
                currentNeighbors[row][column] = getNeighbors(row, column);
            }
        }
    }

    private int getNeighborsTopRow(int column) {
        int neighbors = 0;

        if ((column - 1) >= 0) {
            if (currentIsObstacle(0, column - 1)) {
                neighbors++;
            }
        }
        if ((column + 1) < columns) {
            if (currentIsObstacle(0, column + 1)) {
                neighbors++;
            }
        }

        if ((column - 1) >= 0) {
            if (currentIsObstacle(1, column - 1)) {
                neighbors++;
            }
        }
        if (currentIsObstacle(1, column)) {
            neighbors++;
        }
        if ((column + 1) < columns) {
            if (currentIsObstacle(1, column + 1)) {
                neighbors++;
            }
        }

        return neighbors;
    }

    private int getNeighborsDownRow(int row, int column) {
        int neighbors = 0;

        if ((column - 1) >= 0) {
            if (currentIsObstacle(row - 1, column - 1)) {
                neighbors++;
            }
        }
        if (currentIsObstacle(row - 1, column)) {
            neighbors++;
        }
        if ((column + 1) < columns) {
            if (currentIsObstacle(row - 1, column + 1)) {
                neighbors++;
            }
        }

        if ((column - 1) >= 0) {
            if (currentIsObstacle(row, column - 1)) {
                neighbors++;
            }
        }
        if ((column + 1) < columns) {
            if (currentIsObstacle(row, column + 1)) {
                neighbors++;
            }
        }

        return neighbors;
    }

    private int getNeighborsLeftColumn(int row) {
        int neighbors = 0;

        if ((row - 1) >= 0) {
            if (currentIsObstacle(row - 1, 0)) {
                neighbors++;
            }
            if (currentIsObstacle(row - 1, 1)) {
                neighbors++;
            }
        }

        if (currentIsObstacle(row, 1)) {
            neighbors++;
        }

        if ((row + 1) < rows) {
            if (currentIsObstacle(row + 1, 0)) {
                neighbors++;
            }
            if (currentIsObstacle(row + 1, 1)) {
                neighbors++;
            }
        }

        return neighbors;
    }

    private int getNeighborsRightColumn(int row, int column) {
        int neighbors = 0;

        if ((row - 1) >= 0) {
            if (currentIsObstacle(row - 1, column - 1)) {
                neighbors++;
            }
            if (currentIsObstacle(row - 1, column)) {
                neighbors++;
            }
        }

        if (currentIsObstacle(row, column - 1)) {
            neighbors++;
        }

        if ((row + 1) < rows) {
            if (currentIsObstacle(row + 1, column - 1)) {
                neighbors++;
            }
            if (currentIsObstacle(row + 1, column)) {
                neighbors++;
            }
        }

        return neighbors;
    }

    private int getNeighbors(int row, int column) {
        int neighbors = 0;

        if (currentIsObstacle(row - 1, column - 1)) {
            neighbors++;
        }
        if (currentIsObstacle(row - 1, column)) {
            neighbors++;
        }
        if (currentIsObstacle(row - 1, column + 1)) {
            neighbors++;
        }

        if (currentIsObstacle(row, column - 1)) {
            neighbors++;
        }
        if (currentIsObstacle(row, column + 1)) {
            neighbors++;
        }

        if (currentIsObstacle(row + 1, column - 1)) {
            neighbors++;
        }
        if (currentIsObstacle(row + 1, column)) {
            neighbors++;
        }
        if (currentIsObstacle(row + 1, column + 1)) {
            neighbors++;
        }

        return neighbors;
    }

    private void calculateNext() {
        next = new int[rows][columns];

        next[startCell.row][startCell.column] = CellType.START;
        next[endCell.row][endCell.column] = CellType.END;

        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int neighbors = currentNeighbors[row][column];
                useRules(neighbors, row, column);
            }
        }
    }

    private void useRules(int neighbors, int row, int column) {
        if (currentIsEmpty(row, column)) {
            if (neighbors == 2 || neighbors == 3) {
                next[row][column] = CellType.OBSTACLE;
            }
        } else if (currentIsObstacle(row, column)) {
            if (neighbors == 4 || neighbors == 5 || neighbors == 6) {
                next[row][column] = CellType.OBSTACLE;
            }
        }
    }

    public void draw(Game game) {
        game.translate(game.csz, game.csz);

        for (int row = 0; row < game.maze.rows; row++) {
            for (int column = 0; column < game.maze.columns; column++) {
                drawCells(game, row, column);
                drawNeighbors(game, row, column);
            }
        }

        for (Particle particle : particles.values()) {
            particle.draw(game, endCellIndex);
        }
    }

    private void drawCells(Game game, int row, int column) {
        if (game.maze.currentIsEmpty(row, column)) {
            game.fill(200);
        }
        if (game.maze.currentIsObstacle(row, column)) {
            game.fill(0, 80, 255);
        }
        if (game.maze.currentIsStart(row, column) || game.maze.currentIsEnd(row, column)) {
            game.fill(255, 255, 0);
        }

        game.rect(column * game.csz, row * game.csz, game.csz, game.csz, game.csz / 4);
    }

    private void drawNeighbors(Game game, int row, int column) {
        if (!showNeighbors) {
            return;
        }

        int neighbors = currentNeighbors[row][column];
        game.textSize((float) (game.csz * 0.40));
        game.textAlign(PConstants.CENTER);
        game.fill(0);
        game.text(neighbors, column * game.csz + game.csz / 2, (float) ((row * game.csz) + game.csz * 0.65));
    }
}
