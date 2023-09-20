package mayz;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import org.junit.Test;

public class Maze01SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        String path = "RRLLDRRULDDRRRLRDRDDRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        String path = "DDDDDRRLUUURRRDRLDDRRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        String path = "RRDLLDDRDUURRRDUDRDDRRL";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_solution_for_maze_01_with_2_particles() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDDDDRRLUUURRRDRLDDRRDR");
        paths.add("1 RRLDDDDDRRRRRDR");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_other_solution_for_maze_01_with_2_particles() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDDDDRRLUUURRRDRLDDRRRD");
        paths.add("1 RRLDDDDDRRRRRRD");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_solution_for_maze_01_with_9_particles() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDDDDRRLUUURRRDRLDDRRRUDUDLRUDD");
        paths.add("1 RRLDDDDDRLLRLRRRRLLRLRLRRRRRLDR");
        paths.add("10 RDURRRDRRUDUDURLRDDDDDD");
        paths.add("21 DRRRRRRDDLRDDRD");
        paths.add("22 RRDLRDDDDRRRRDR");
        paths.add("25 DDDRLRRRRRDDRDR");
        paths.add("26 RRRRDRRRDDUDDDD");
        paths.add("27 DUDRDDRRRLRRLLRLDDRLUURRDDRDR");
        paths.add("28 RLRRDRDDRLLRRLRLLRDRDLRDRRR");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }
}
