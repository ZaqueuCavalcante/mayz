package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class MayzUtilsTests {
    @Test
    public void should_get_ids_for_maze_00_mini() {
        // Arrange
        int rows = 3;
        int columns = 4;

        // Act
        int[][] ids = MayzUtils.getIds(rows, columns);

        // Assert
        assertThat(ids[0]).isEqualTo(new int[] { 0, 1, 2, 3 });
        assertThat(ids[1]).isEqualTo(new int[] { 4, 5, 6, 7 });
        assertThat(ids[2]).isEqualTo(new int[] { 8, 9, 10, 11 });
    }
}
