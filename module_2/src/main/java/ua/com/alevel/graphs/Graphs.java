package ua.com.alevel.graphs;

import ua.com.alevel.util.FileToStringList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Graphs {

    private static final Path path = Paths.get("module_2/inputGraphs.txt");
    private static final Path pathOut = Paths.get("module_2/outputGraphs.txt");

    private static List<Vertex> nodes = new ArrayList<>();
    private static List<Edge> edges = new ArrayList<>();

    public static void runGraphs() {
        List<String> list = FileToStringList.fileToStringList(path);
        if (list == null) return;
        String[] array = new String[list.size()];
        array = list.toArray(array);
        List<String> cities = new ArrayList<>();
        int n = 1;
        int vertexId = 1;
        int cost;
        List<Integer> sources = new ArrayList<>();
        List<Integer> destinations = new ArrayList<>();
        nodes.clear();
        edges.clear();

        for (int i = 2; i < list.size(); i++) {
            if (n == Integer.parseInt(array[0]) + 1) {
                for (int j = i; j < list.size(); j++) {
                    int position = 0;
                    for (String city : cities) {
                        if (city.equals(array[j].split("\s")[0])) {
                            sources.add(position);
                            break;
                        }
                        position++;
                    }
                    position = 0;
                    for (String city : cities) {
                        if (city.equals(array[j].split("\s")[1])) {
                            destinations.add(position);
                            break;
                        }
                        position++;
                    }
                }
                break;
            }
            cities.add(array[i - 1]);
            nodes.add(new Vertex(vertexId, array[i - 1]));
            vertexId++;
            n++;
            i += Integer.parseInt(array[i]) + 1;
        }

        n = 1;
        for (int i = 2; i < list.size(); i++) {
            if (n == Integer.parseInt(array[0]) + 1) break;
            for (int j = 1; j <= Integer.parseInt(array[i]); j++) {
                String[] tempArr = array[i + j].split("\s");
                edges.add(new Edge(nodes.get(n - 1), nodes.get(Integer.parseInt(tempArr[0]) - 1), Integer.parseInt(tempArr[1])));
            }
            n++;
            i += Integer.parseInt(array[i]) + 1;
        }

        Graph graph = new Graph(nodes, edges);

        if (Files.exists(pathOut)) {
            try {
                Files.delete(pathOut);
                Files.createFile(pathOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            try {
                Files.createFile(pathOut);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < sources.size(); i++) {
            System.out.println("From " + (sources.get(i) + 1) + " = " + cities.get(sources.get(i)) + ", to " + (destinations.get(i) + 1) + " = " + cities.get(destinations.get(i)));
            PathFinder pathFinder = new PathFinder(graph);
            pathFinder.execute(nodes.get(sources.get(i)));
            LinkedList<Vertex> path = PathFinder.getPath(nodes.get(destinations.get(i)));

            cost = 0;
            for (int j = 0; j < path.size() - 1; j++) {
                for (Edge edge : edges) {
                    if (edge.getSource() == path.get(j) && edge.getDestination() == path.get(j + 1)) cost += edge.getCost();
                }
            }
            String result = cost + "\n";
            try {
                Files.write(pathOut, result.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Cost = " + cost);
        }
    }
}
