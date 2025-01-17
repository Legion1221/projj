package chapter11_Test;

import chapters.chapter_11.LAB11_B.Graph;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

public class LAB11B_Test {

    private Graph graph;

    @BeforeEach
    public void setUp() {
        // Создание графа с 5 вершинами для каждого теста
        graph = new Graph(5);
    }

    @Test
    public void testAddEdge() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        // Проверям что рёбра были добавлены правильно
        assertTrue(graph.hasEdge(0, 1));
        assertTrue(graph.hasEdge(1, 2));
    }

    @Test
    public void testRemoveEdge() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        graph.removeEdge(1, 2);

        assertFalse(graph.hasEdge(1, 2));
    }

    @Test
    public void testGetNeighbors() {
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);

        Set<Integer> neighbors = graph.getNeighbors(0);
        assertTrue(neighbors.contains(1));
        assertTrue(neighbors.contains(4));
    }

    @Test
    public void testGetAllEdges() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertEquals(3, graph.getAllEdges().size());
    }

    @Test
    public void testEdgeCount() {
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);

        assertEquals(3, graph.getEdgeCount());
    }

    @Test
    public void testInvalidVertex() {
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(0, 5));
        assertThrows(IllegalArgumentException.class, () -> graph.addEdge(-1, 1));
    }

    @Test
    public void testAddAndRemoveEdge() {
        graph.addEdge(0, 1);
        graph.removeEdge(0, 1);

        assertFalse(graph.hasEdge(0, 1));
    }
}
