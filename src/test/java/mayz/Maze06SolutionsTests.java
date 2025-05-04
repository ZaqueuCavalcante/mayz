package mayz;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class Maze06SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_06() {
        // Arrange
        Maze maze = new Maze(Option.PAC_MAN);
        String path = "DRRRRRRRDRURRDRDDDLRRRDRRRRUDLLDDDDURDDDDDRDDDDDRDLRDRRRDDDRRDDDDRDDRRRRRURRURURURRDRLRRDDRRRRRRRRRRRRRRRLDDLDRRRRD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_06() {
        // Arrange
        Maze maze = new Maze(Option.PAC_MAN);
        String path = "DRRRRRRRDRURRDRDDDLRRRDRRRRUDLLDDDDURDDDDDRDDDDDRDLRDRDRDDDRRDDDDRDDRRRRRURRURURURRDRLRRDDRRRRRRRRRRRRRRRLDDLDRRRRD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
