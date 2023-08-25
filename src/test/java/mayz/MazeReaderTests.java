package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class MazeReaderTests {
    @Test
    public void should_read_maze_00_file_with_correct_values() {
        // Arrange / Act
        String[] lines = MazeReader.Read("00");

        // Assert
        assertThat(lines).hasSize(3);
        assertThat(lines[0]).isEqualTo("3010");
        assertThat(lines[1]).isEqualTo("0100");
        assertThat(lines[2]).isEqualTo("0014");
    }

    @Test
    public void should_read_maze_01_file_with_correct_values() {
        // Arrange / Act
        String[] lines = MazeReader.Read("01");

        // Assert
        assertThat(lines).hasSize(7);
        assertThat(lines[0]).isEqualTo("30000000");
        assertThat(lines[1]).isEqualTo("00001000");
        assertThat(lines[2]).isEqualTo("00101100");
        assertThat(lines[3]).isEqualTo("01100110");
        assertThat(lines[4]).isEqualTo("00101100");
        assertThat(lines[5]).isEqualTo("00001000");
        assertThat(lines[6]).isEqualTo("00000004");
    }
}
