package mayz;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

public class SolverTests {
    //TODO: @Test
    public void should_solve_maze_05_empty() {
        // Arrange
        Maze maze = new Maze(Option.EMPTY);

        // Act
        ArrayList<String> paths = Solver.it(maze);

        // Assert
        for (int i = 0; i < 11; i++) {
            assertThat(paths.get(i)).isEqualTo(i + " RRRDLLLDRRR");   
        }
    }
}
