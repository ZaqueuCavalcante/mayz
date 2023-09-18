package mayz;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Test;

public class Maze00SolutionsTests {
    @Test
    public void should_test_one_correct_solution_for_maze_00() {
        // Arrange
        Maze maze = new Maze("00_mini");
        String path = "DUDDRUDRR";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_00() {
        // Arrange
        Maze maze = new Maze("00_mini");
        String path = "DDUURDRRD";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_00() {
        // Arrange
        Maze maze = new Maze("00_mini");
        String path = "DUDDRUDRL";

        // Act
        boolean isSolution = maze.isSolution(path);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_one_wrong_solution_for_maze_00_with_2_particles() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DD");
        paths.add("1 D");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_another_wrong_solution_for_maze_00_with_2_particles() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDUURDRRD");
        paths.add("1 RRRDRD");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_another_wrong_solution_for_maze_00_with_2_particles_with_particles_collision() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDU");
        paths.add("2 D");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_another_wrong_solution_for_maze_00_with_2_particles_without_collisions() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DD");
        paths.add("1 R");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_another_wrong_solution_for_maze_00_with_2_particles_without_collisions_and_one_comes_to_maze_end_cell() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDUURDRRD");
        paths.add("1 RRRLLRRLRD");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isFalse();
    }

    @Test
    public void should_test_one_correct_solution_for_maze_00_with_2_particles() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDUURDRRD");
        paths.add("1 RRRLLRRLRDD");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }

    @Test
    public void should_test_another_correct_solution_for_maze_00_with_2_particles() {
        // Arrange
        Maze maze = new Maze("00_mini");

        ArrayList<String> paths = new ArrayList<>();
        paths.add("0 DDUDRUDRR");
        paths.add("1 RLRRRLRLRDD");

        // Act
        boolean isSolution = maze.isSolution(paths);

        // Assert
        assertThat(isSolution).isTrue();
    }
}
