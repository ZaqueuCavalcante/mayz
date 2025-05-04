package mayz;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

public class Maze07SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_04() {
        // Arrange
        Maze maze = new Maze(Option.RANDOM100x100);
        String path = "DRRRRRRRRUDURDDDLDDDDDDRDDDDDDDDDDDRRDRDRRDDRRDRURRRURRDRDRRRRRRRDRRDRRUURRRRDDRRRDDRDRRDUDUDUDULRDUDRRRDDDDLRDUDDDDRRDURRUDRDDRDRLRLRDRDRDRDRRRRDRRRLRDDDDDDRDDDDDRRDDRLDLDRRRRDLRDDRRDDDDDRRDRRRURUDURDDDUDRRRRRDRRRRDDRRRRLLRRRRRRDLDRDDRDRRDLDRLDLRDRLLLLDDRRDDDDDDDLDDDDDLRRRRD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_04() {
        // Arrange
        Maze maze = new Maze(Option.RANDOM100x100);
        String path = "DRRRRRRRRUDURDDDLDDDDDDRDDDDDDDDDDDRRDRDRRDDRRDRURRRURRDRDRRRRRRRDRRDRRUURRRRDDRRRDDRDRRDUDUDUDULRDUDRRRDDDDLRDUDDDDRRDURRUDRDDRDRLRLRDRDRDRDRRRRDRRRLRDDDDDDRDDRDDRRDDRLDLDRRRRDLRDDRRDDDDDRRDRRRURUDURDDDUDRRRRRDRRRRDDRRRRLLRRRRRRDLDRDDRDRRDLDRLDLRDRLLLLDDRRDDDDDDDLDDDDDLRRRRD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
