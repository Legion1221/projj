package chapters.chapter_11.LAB11_B;

/*
 * Выполнил : Дамдинов Арья
 * Дата получения задания: 01.09.2024
 * Дата сдачи задания: 17.01.2025
 */

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(5);

        // Добавление рёбер
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);

        // Печать всех рёбер
        System.out.println("Все рёбра: " + graph.getAllEdges());

        // Проверка наличия рёбер
        System.out.println("Есть ли ребро между 1 и 2: " + graph.hasEdge(1, 2));
        System.out.println("Есть ли ребро между 1 и 3: " + graph.hasEdge(1, 3));

        // Получение соседей для вершины
        System.out.println("Соседи вершины 1: " + graph.getNeighbors(1));

        // Удаление ребра
        graph.removeEdge(1, 2);
        System.out.println("Все рёбра после удаления ребра 1 - 2: " + graph.getAllEdges());

        // Количество рёбер
        System.out.println("Количество рёбер: " + graph.getEdgeCount());
    }
}
