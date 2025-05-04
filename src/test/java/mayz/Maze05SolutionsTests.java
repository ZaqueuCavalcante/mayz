package mayz;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class Maze05SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_05() {
        // Arrange
        Maze maze = new Maze(Option.EMPTY);
        String path = "DDRRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_05() {
        // Arrange
        Maze maze = new Maze(Option.EMPTY);
        String path = "RDRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_05() {
        // Arrange
        Maze maze = new Maze(Option.EMPTY);
        String path = "RRDD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
