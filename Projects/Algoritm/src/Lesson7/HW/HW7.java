package Lesson7.HW;

import Lesson7.Graph;
import Lesson7.GraphImpl;

import java.util.Stack;

public class HW7 {
    private static boolean label;

    public static void main(String[] args) {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", "Тула");
        graph.addEdge("Москва","Рязань");
        graph.addEdge("Москва","Калуга");
        graph.addEdge("Тула","Липецк");
        graph.addEdge("Рязань","Тамбов");
        graph.addEdge("Калуга","Орел");
        graph.addEdge("Липецк","Воронеж");
        graph.addEdge("Тамбов","Саратов");
        graph.addEdge("Орел","Курск");
        graph.addEdge("Саратов","Воронеж");
        graph.addEdge("Курск","Воронеж");

        Stack<String> path = graph.bfs("Москва", "Воронеж");
        StringBuilder stringBuilder = new StringBuilder();

        while (!path.isEmpty()) {
            if (label){
                stringBuilder.append(" ");
            }
            label = true;
            stringBuilder.append(path.pop());

        }

        System.out.println(stringBuilder);

        //System.out.println(path);

    }
}
