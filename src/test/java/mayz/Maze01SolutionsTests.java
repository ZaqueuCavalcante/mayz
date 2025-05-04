package mayz;

import static org.assertj.core.api.Assertions.*;
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
    public void should_test_one_correct_solution_for_maze_01_static_mode() {
        // Arrange
        Maze maze = new Maze(Option.SMALL, true);
        String path = "DDDDDDRRRRRRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_01_static_mode() {
        // Arrange
        Maze maze = new Maze(Option.SMALL, true);
        String path = "RRRRRRRDDDDDD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_more_another_correct_solution_for_maze_01_static_mode() {
        // Arrange
        Maze maze = new Maze(Option.SMALL, true);
        String path = "RRRDDDDDDRRRR";

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
}
