import java.util.*;

// Edge class
class Edge {
    String target;
    int weight;

    Edge(String target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

public class Map {

    private Maps<String, List<Edge>> graph = new HashMap<>();

    // Add road (edge)
    public void addRoad(String from, String to, int distance) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());

        graph.get(from).add(new Edge(to, distance));
        graph.get(to).add(new Edge(from, distance)); // undirected
    }

    // Dijkstra Algorithm
    public void shortestPath(String start, String end) {

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (String city : graph.keySet()) {
            dist.put(city, Integer.MAX_VALUE);
        }

        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));

        dist.put(start, 0);
        pq.add(start);

        while (!pq.isEmpty()) {
            String current = pq.poll();

            for (Edge neighbor : graph.get(current)) {
                int newDist = dist.get(current) + neighbor.weight;

                if (newDist < dist.get(neighbor.target)) {
                    dist.put(neighbor.target, newDist);
                    parent.put(neighbor.target, current);
                    pq.add(neighbor.target);
                }
            }
        }

        // Print result
        if (dist.get(end) == Integer.MAX_VALUE) {
            System.out.println("No path found!");
            return;
        }

        System.out.println("\nShortest Distance: " + dist.get(end));
        System.out.print("Path: ");
        printPath(parent, end);
        System.out.println();
    }

    // Print path
    private void printPath(Map<String, String> parent, String city) {
        if (city == null) return;
        printPath(parent, parent.get(city));
        System.out.print(city + " ");
    }

    // Display graph
    public void display() {
        for (String city : graph.keySet()) {
            System.out.print(city + " -> ");
            for (Edge e : graph.get(city)) {
                System.out.print("(" + e.target + ", " + e.weight + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SmartRouteFinder map = new SmartRouteFinder();

        // Predefined cities (you can change)
        map.addRoad("Delhi", "Jaipur", 280);
        map.addRoad("Delhi", "Agra", 230);
        map.addRoad("Jaipur", "Udaipur", 400);
        map.addRoad("Agra", "Lucknow", 330);
        map.addRoad("Lucknow", "Varanasi", 320);
        map.addRoad("Udaipur", "Mumbai", 760);

        while (true) {
            System.out.println("\n1. Show Map\n2. Find Shortest Path\n3. Add Traffic\n4. Exit");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                map.display();

            } else if (choice == 2) {
                System.out.print("Enter source city: ");
                String src = sc.nextLine();

                System.out.print("Enter destination city: ");
                String dest = sc.nextLine();

                map.shortestPath(src, dest);

            } else if (choice == 3) {
                System.out.print("Enter city 1: ");
                String c1 = sc.nextLine();

                System.out.print("Enter city 2: ");
                String c2 = sc.nextLine();

                System.out.print("Enter traffic delay (extra distance): ");
                int extra = sc.nextInt();

                // Add traffic by increasing weight
                for (Edge e : map.graph.get(c1)) {
                    if (e.target.equals(c2)) {
                        e.weight += extra;
                    }
                }
                for (Edge e : map.graph.get(c2)) {
                    if (e.target.equals(c1)) {
                        e.weight += extra;
                    }
                }

                System.out.println("Traffic updated!");

            } else {
                break;
            }
        }

        sc.close();
    }
}