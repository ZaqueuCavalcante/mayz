package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Maze03SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_03() {
        // Arrange
        Maze maze = new Maze(Option.MONA_LISA);
        String path = "DDDDDDDDDDDRRRRRRRRRRRRRRRRDRRRRRRRRRRRRDDDDDRDDDDDDRRDDDRDUDUDUDDDRLDLDDRDDDDRRRRDRDRDDDRRDDLRRDUDRRDRUDRDDDDDUDDLDDLRDLDDDRRRRURRDRRRRDDDDDRLDDDRDRRRDRDRRDURRUDRRDDDRDRDRRDDRRRRDURDRRRLRRDDUDURRRRRRUDRDUUUDURRDDRDDDRRRDRRDLDDRLDRRRRRDDDDDURRDRRRRRRDRRDRDDDURRDDDDDLDRDDDLUURLDDDDRRRDDRRRDDDDRDUDUDRRURRURRULRRLRRRRURURDRDRRRRRRDRRDDRDDDDDDRRDRRURRRDDLDDDDRRRDRRRRUDDRRRDDRRRDDDRLRRRRDUDDDDRRLLRDURDDRRDDDLRRURRLRLRURRDDDRRRLRLRRUULRRDRRDRRLRLRRDRRDRDDRRRDRRDDRDRRRULDDRRRRDDDDRRRDRDRDRDUDRRRRDRDDDDLLDRDRLDDLDRDRDRDRDDLRRRRRRDRDDLDDDRRDRDDLRRDDRRRRDRDRRRRUUDURRRRLDDRUUURRDRDRDRRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_03() {
        // Arrange
        Maze maze = new Maze(Option.MONA_LISA);
        String path = "DDDDDDDDDDDRRRRRRRRRRRRRRRRDRRRRRRRRRRRRDDDDDRDDDDDDRRDDDRDUDUDUDDDRLDLDDRDDDDRRRRDRDRDDDRRDULRRDUDRRDRUDRDDDDDUDDLDDLRDLDDDRRRRURRDRRRRDDDDDRLDDDRDRRRDRDRRDURRUDRRDDDRDRDRRDDRRRRDURDRRRLRRDDUDURRRRRRUDRDUUUDURRDDRDDDRRRDRRDLDDRLDRRRRRDDDDDURRDRRRRRRDRRDRDDDURRDDDDDLDRDDDLUURLDDDDRRRDDRRRDDDDRDUDUDRRURRURRULRRLRRRRURURDRDRRRRRRDRRDDRDDDDDDRRDRRURRRDDLDDDDRRRDRRRRUDDRRRDDRRRDDDRLRRRRDUDDDDRRLLRDURDDRRDDDLRRURRLRLRURRDDDRRRLRLRRUULRRDRRDRRLRLRRDRRDRDDRRRDRRDDRDRRRULDDRRRRDDDDRRRDRDRDRDUDRRRRDRDDDDLLDRDRLDDLDRDRDRDRDDLRRRRRRDRDDLDDDRRDRDDLRRDDRRRRDRDRRRRUUDURRRRLDDRUUURRDRDRDRRDR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
