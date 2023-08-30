package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Maze01SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze("01_small");
        String path = "RRLLDRRULDDRRRLRDRDDRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze("01_small");
        String path = "DDDDDRRLUUURRRDRLDDRRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_01() {
        // Arrange
        Maze maze = new Maze("01_small");
        String path = "RRDLLDDRDUURRRDUDRDDRRL";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
