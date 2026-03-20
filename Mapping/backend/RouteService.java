package Mapping.backend;



import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class RouteService {

    private Map<String, List<Edge>> graph = new HashMap<>();

    public RouteService() {
        addRoad("Delhi", "Jaipur", 280);
        addRoad("Delhi", "Agra", 230);
        addRoad("Jaipur", "Udaipur", 400);
        addRoad("Agra", "Lucknow", 330);
        addRoad("Lucknow", "Varanasi", 320);
        addRoad("Udaipur", "Mumbai", 760);
    }

    public void addRoad(String from, String to, int distance) {
        graph.putIfAbsent(from, new ArrayList<>());
        graph.putIfAbsent(to, new ArrayList<>());

        graph.get(from).add(new Edge(to, distance));
        graph.get(to).add(new Edge(from, distance));
    }

    public Map<String, Object> shortestPath(String start, String end) {

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

            for (Edge neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                int newDist = dist.get(current) + neighbor.weight;

                if (newDist < dist.get(neighbor.target)) {
                    dist.put(neighbor.target, newDist);
                    parent.put(neighbor.target, current);
                    pq.add(neighbor.target);
                }
            }
        }

        List<String> path = new ArrayList<>();
        String curr = end;

        while (curr != null) {
            path.add(0, curr);
            curr = parent.get(curr);
        }

        Map<String, Object> result = new HashMap<>();
        result.put("distance", dist.get(end));
        result.put("path", path);

        return result;
    }
}