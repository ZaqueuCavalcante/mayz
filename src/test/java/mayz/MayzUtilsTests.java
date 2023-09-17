package mayz;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class MayzUtilsTests {
    @Test
    public void should_convert_from_paths_to_particles_hash_map() {
        // Arrange
        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDUURDRRD");
        paths.add("1 RRRDRD");

        // Act
        HashMap<Integer, Particle> particles = MayzUtils.toParticleHashMap(paths);

        // Assert
        assertThat(particles.get(0).turn).isEqualTo(0);
        assertThat(particles.get(0).path).isEqualTo("DDUURDRRD");
        assertThat(particles.get(1).turn).isEqualTo(1);
        assertThat(particles.get(1).path).isEqualTo("RRRDRD");
    }

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
