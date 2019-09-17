package HuaWei.LeetCode;

import java.util.*;

public class L815_NumBusesToDestination {
    public int numBusesToDestination(int[][] routes, int S, int T) {
        if (S==T) return 0;
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int res = 0;
        for(int i = 0; i < routes.length; i++){
            for(int j = 0; j < routes[i].length; j++){
                if (!map.containsKey(routes[i][j])) map.put(routes[i][j], new ArrayList<>());
                map.get(routes[i][j]).add(i);
            }
        }
        q.offer(S);
        while (!q.isEmpty()) {
            int len = q.size();
            res++;
            for (int i = 0; i < len; i++) {
                int cur = q.poll();
                ArrayList<Integer> buses = map.get(cur);
                for (int bus: buses) {
                    if (visited.contains(bus)) continue;
                    visited.add(bus);
                    for (int j = 0; j < routes[bus].length; j++) {
                        if (routes[bus][j] == T) return res;
                        q.offer(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}
