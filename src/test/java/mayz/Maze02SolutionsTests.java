package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class Maze02SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_02() {
        // Arrange
        Maze maze = new Maze(Option.BLUE_PEN);
        String path = "DDDDDDDDDRRRRRRRDDDRRDRDDDUDDRRRDRDDRRDUDUDRRDRRRRDLRRLDDDRDRRLRLRRDDDLLRRRRURLRRUDRRDURURRDDRDRDDLDDRDDDDDDDRRLRRRDDRRUDLRRRLDDDRDRUDRDURRRRRRRDRRULRRRRDRDDRLDDLDDDDDDDDDDDRRDDDRDRRRURRRRDRLDURRURRRRDRRLUUURURUDRRRURRRLRURURRRDRRRDRRRLRRRRURRDUDRDRDRDDRDRDDRRURURRDUDDLRRRRDRDRDDRDRRRRDDRDDRRDRRDURRRRDULRURRURRRRLURRDRDRDRUUDURRRLRDULRLRRRRDDRDDRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_02() {
        // Arrange
        Maze maze = new Maze(Option.BLUE_PEN);
        String path = "DDDDDDDDDRRRRRRRDDDRRDRDDDUDDRRRDRDDRRDUDUDRRDRRRRDLRRLDDDRDRRLRLRRDDDLLRRRRURLRRUDRRDURURRDDRDRDDLDDRDDDDDDDRRLRRRDDRRUDLRRRLDDDRDRUDRDURRRRRRRDRRULRRRRDRDDRLDDLDDDDDDDDDDDRRDDDRDRRRURRRRDRLDURRURRRRDRRLUUURURUDRRRURRRLRURURRRDRRRDRRRLRRRRURRDUDRDRDRDDRDRDDRRURURRDUDDLRRRRDRRDDDRDRRRRDDRDDRRDRRDURRRRDULRURRURRRRLURRDRDRDRUUDURRRLRDULRLRRRRDDRDDRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }
}
