package mayz;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;

public class ParticleMoveTests {
    @Test
    public void should_move_particle_one_time_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(1);
        assertThat(particle.column).isEqualTo(0);
        assertThat(particle.index).isEqualTo(4);
        assertThat(particle.pathIndex).isEqualTo(1);
    }

    @Test
    public void should_move_particle_two_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(2);
        assertThat(particle.column).isEqualTo(0);
        assertThat(particle.index).isEqualTo(8);
        assertThat(particle.pathIndex).isEqualTo(2);
    }

    @Test
    public void should_move_particle_three_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(1);
        assertThat(particle.column).isEqualTo(0);
        assertThat(particle.index).isEqualTo(4);
        assertThat(particle.pathIndex).isEqualTo(3);
    }

    @Test
    public void should_move_particle_four_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(0);
        assertThat(particle.column).isEqualTo(0);
        assertThat(particle.index).isEqualTo(0);
        assertThat(particle.pathIndex).isEqualTo(4);
    }

    @Test
    public void should_move_particle_five_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(0);
        assertThat(particle.column).isEqualTo(1);
        assertThat(particle.index).isEqualTo(1);
        assertThat(particle.pathIndex).isEqualTo(5);
    }

    @Test
    public void should_move_particle_six_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(1);
        assertThat(particle.column).isEqualTo(1);
        assertThat(particle.index).isEqualTo(5);
        assertThat(particle.pathIndex).isEqualTo(6);
    }

    @Test
    public void should_move_particle_seven_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(1);
        assertThat(particle.column).isEqualTo(2);
        assertThat(particle.index).isEqualTo(6);
        assertThat(particle.pathIndex).isEqualTo(7);
    }

    @Test
    public void should_move_particle_eight_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(1);
        assertThat(particle.column).isEqualTo(3);
        assertThat(particle.index).isEqualTo(7);
        assertThat(particle.pathIndex).isEqualTo(8);
    }

    @Test
    public void should_move_particle_nine_times_on_maze_00_mini() {
        // Arrange
        Particle particle = new Particle();
        particle.path = "DDUURDRRD";

        int[][] ids = MayzUtils.getIds(3, 4);

        // Act
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);
        particle.move(ids);

        // Assert
        assertThat(particle.row).isEqualTo(2);
        assertThat(particle.column).isEqualTo(3);
        assertThat(particle.index).isEqualTo(11);
        assertThat(particle.pathIndex).isEqualTo(9);
    }
}
