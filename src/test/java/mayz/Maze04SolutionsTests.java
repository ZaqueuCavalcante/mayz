package mayz;

import static org.assertj.core.api.Assertions.*;
import java.util.ArrayList;
import org.junit.Test;

public class Maze04SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_04() {
        // Arrange
        Maze maze = new Maze("04_random");
        String path = "RRRRDDULRDRDRRRURDRLRRUDRRDDDDLDDLDDDDUDDRRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_04() {
        // Arrange
        Maze maze = new Maze("04_random");
        String path = "RRRRDDULRDRDRRRURDRLRRUDRRDDDDLDDLDDDDUDDRRU";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }

    //@Test
    public void should_test_solution_for_maze_04_with_2_particles() {
        // Arrange
        Maze maze = new Maze("04_random");
        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDDDDRRLUUURRRDRLDDRRDR");
        paths.add("1 RRLDDDDDRRRRRDR");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }
}
