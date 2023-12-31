package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class MazeReaderTests {
    @Test
    public void should_read_maze_00_file_with_correct_values() {
        // Arrange / Act
        MazeData data = MazeReader.Read("00_mini");

        // Assert
        assertThat(data.lines).hasSize(3);
        assertThat(data.lines[0]).isEqualTo("3010");
        assertThat(data.lines[1]).isEqualTo("0100");
        assertThat(data.lines[2]).isEqualTo("0014");
    }

    @Test
    public void should_read_maze_01_file_with_correct_values() {
        // Arrange / Act
        MazeData data = MazeReader.Read("01_small");

        // Assert
        assertThat(data.lines).hasSize(7);
        assertThat(data.lines[0]).isEqualTo("30000000");
        assertThat(data.lines[1]).isEqualTo("00001000");
        assertThat(data.lines[2]).isEqualTo("00101100");
        assertThat(data.lines[3]).isEqualTo("01100110");
        assertThat(data.lines[4]).isEqualTo("00101100");
        assertThat(data.lines[5]).isEqualTo("00001000");
        assertThat(data.lines[6]).isEqualTo("00000004");
    }
}
