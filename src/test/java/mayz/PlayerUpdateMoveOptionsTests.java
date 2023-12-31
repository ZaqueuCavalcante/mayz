package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class PlayerUpdateMoveOptionsTests {
    @Test
    public void should_set_the_player_move_options_on_maze_01_initial_state() {
        // Arrange
        Maze maze = new Maze(Option.SMALL);
        Player player = new Player(maze.startCell.row, maze.startCell.column);

        // Act
        player.updateMoveOptions(maze);

        // Assert
        assertThat(player.canMoveUp).isFalse();
        assertThat(player.canMoveRight).isTrue();
        assertThat(player.canMoveDown).isTrue();
        assertThat(player.canMoveLeft).isFalse();
    }
}
