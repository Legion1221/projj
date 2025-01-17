package chapters.chapter_11.LAB11_B;

import java.util.*;

public class Graph {
    private int numVertices;  // Количество вершин в графе
    private Map<Integer, Set<Integer>> adjacencyList;  // Список смежности для хранения рёбер

    // Конструктор принимающий кол-во вершин
    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjacencyList = new HashMap<>();

        // Создаём список смежности для каждой вершины
        for (int i = 0; i < numVertices; i++) {
            adjacencyList.put(i, new HashSet<>());
        }
    }

    // Метод для добавления ребра
    public void addEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex2 < 0 || vertex1 >= numVertices || vertex2 >= numVertices) {
            throw new IllegalArgumentException("Неверный индекс вершины");
        }

        // Добавляем вершины друг к другу
        adjacencyList.get(vertex1).add(vertex2);
        adjacencyList.get(vertex2).add(vertex1);
    }

    // Метод для удаления ребра
    public void removeEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex2 < 0 || vertex1 >= numVertices || vertex2 >= numVertices) {
            throw new IllegalArgumentException("Неверный индекс вершины");
        }

        // Удаляем рёбра
        adjacencyList.get(vertex1).remove(vertex2);
        adjacencyList.get(vertex2).remove(vertex1);
    }

    // Метод для получения соседей
    public Set<Integer> getNeighbors(int vertex) {
        if (vertex < 0 || vertex >= numVertices) {
            throw new IllegalArgumentException("Неверный индекс вершины");
        }
        return adjacencyList.get(vertex);
    }

    // Метод для проверки наличия ребра между вершинами
    public boolean hasEdge(int vertex1, int vertex2) {
        if (vertex1 < 0 || vertex2 < 0 || vertex1 >= numVertices || vertex2 >= numVertices) {
            throw new IllegalArgumentException("Неверный индекс вершины");
        }
        return adjacencyList.get(vertex1).contains(vertex2);
    }

    // Метод для получения всех рёбер
    public List<String> getAllEdges() {
        List<String> edges = new ArrayList<>();
        for (int vertex : adjacencyList.keySet()) {
            for (int neighbor : adjacencyList.get(vertex)) {
                if (vertex < neighbor) {  // Чтобы не добавить одинаковые рёбра дважды
                    edges.add(vertex + " - " + neighbor);
                }
            }
        }
        return edges;
    }

    // Метод для получения количества рёбер
    public int getEdgeCount() {
        int count = 0;
        for (int vertex : adjacencyList.keySet()) {
            count += adjacencyList.get(vertex).size();
        }
        return count / 2;  // Делим на 2 потому что каждое ребро посчитано 2 раза
    }
}
