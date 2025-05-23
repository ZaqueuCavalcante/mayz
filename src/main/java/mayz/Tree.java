package mayz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;

public class Tree {
    Node root;

    int level;
    HashMap<Integer, Node> levelNodes;

    HashSet<Node> solutions;

    int[][] ids;

    public Tree(Maze maze) {
        ids = MayzUtils.getIds(maze.rows, maze.columns);

        root = new Node(maze.startCell.row, maze.startCell.column, null, ids);

        level = 0;
        levelNodes = new HashMap<Integer, Node>();
        levelNodes.put(root.id, root);

        solutions = new HashSet<>();
    }

    public HashSet<Node> getFilteredNodes() {
        HashSet<Node> filteredNodes = new HashSet<>();

        int maxRow = levelNodes.values().stream()
            .mapToInt(v -> v.row)
            .max().getAsInt();
        int maxColumn = levelNodes.values().stream()
            .mapToInt(v -> v.column)
            .max().getAsInt();

        for (int row = 0; row <= maxRow; row++) {
            for (int column = maxColumn; column >= 0; column--) {
                Node node = levelNodes.getOrDefault(ids[row][column], null);

                if (node == null) {
                    continue;
                }

                filteredNodes.add(node);
                column = -1;
            }
        }

        for (int column = 0; column <= maxColumn; column++) {
            for (int row = maxRow; row >= 0; row--) {
                Node node = levelNodes.getOrDefault(ids[row][column], null);

                if (node == null) {
                    continue;
                }

                filteredNodes.add(node);
                row = -1;
            }
        }

        return filteredNodes;
    }

    public void goToNextLevel(Maze maze) {
        HashMap<Integer, Node> newNodes = new HashMap<Integer, Node>();
        HashSet<Node> filteredNodes = getFilteredNodes();

        for (Node levelNode : filteredNodes) {
            int[] directions = maze.getNextDirections(levelNode.row, levelNode.column);
            levelNode.addChildren(directions[0], directions[1], directions[2], directions[3], ids);

            for (int i = 0; i < 4; i++) {
                Node node = levelNode.children.get(i);

                if (node == null) {
                    continue;
                }

                if (node.row == maze.endCell.row && node.column == maze.endCell.column) {
                    solutions.add(node);
                }

                newNodes.put(node.id, node);
            }
        }

        levelNodes = newNodes;
        level++;
    }

    // Only for tests
    public void goToLevel(int targetLevel, Maze maze) {
        while (this.level < targetLevel) {
            this.goToNextLevel(maze);
            maze.shift();
        }
    }

    public ArrayList<String> getSolutionsPaths() {
        ArrayList<String> paths = new ArrayList<String>();

        for (Node node : solutions) {
            paths.add(node.getPath());
        }

        return paths;
    }

    public void drawPathsOnMaze(Game game) {
        game.fill(34, 139, 34);
        game.stroke(34, 139, 34);

        game.strokeWeight(2.50f);

        for (Node node : levelNodes.values()) {
            float x1 = game.maze.startCell.column * game.csz + game.csz / 2;
            float y1 = game.maze.startCell.row * game.csz + game.csz / 2;
            float x2 = 0;
            float y2 = 0;

            String[] path = node.getPath().split("");
            if (path[0].equals("")) {
                x2 = x1;
                y2 = y1;
            }

            for (String direction : path) {
                if (direction.equals("U")) {
                    x2 = x1;
                    y2 = y1 - game.csz;
                }
                if (direction.equals("R")) {
                    x2 = x1 + game.csz;
                    y2 = y1;
                }
                if (direction.equals("D")) {
                    x2 = x1;
                    y2 = y1 + game.csz;
                }
                if (direction.equals("L")) {
                    x2 = x1 - game.csz;
                    y2 = y1;
                }

                game.line(x1, y1, x2, y2);

                x1 = x2;
                y1 = y2;
            }

            game.circle(x2, y2, (float) (game.csz * 0.40));
        }

        game.strokeWeight(1);
    }
}
