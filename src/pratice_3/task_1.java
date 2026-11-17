package pratice_3;

import java.util.*;

public class task_1 {
    public static void main(String[] arg) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int s = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int v = 0; v < n; v++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt();
            int to = scanner.nextInt();

            graph.get(from).add(to);
        }
        boolean[] visited = new boolean[n];
        int[] nextNeighbor = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> finishOrder = new ArrayList<>();

        visited[s] = true;
        stack.push(s);
        while (!stack.isEmpty()) {
            int v = stack.peek();

            if (nextNeighbor[v] < graph.get(v).size()) {
                int to = graph.get(v).get(nextNeighbor[v]);

                nextNeighbor[v]++;

                if (!visited[to]) {
                    visited[to] = true;
                    stack.push(to);
                }
            } else {

                stack.pop();
                finishOrder.add(v);
            }
        }

        System.out.println(Arrays.toString(visited));

        StringJoiner finishOutput = new StringJoiner(" ");

        for (int v : finishOrder) {
            finishOutput.add(Integer.toString(v));
        }

        System.out.println(finishOutput);
    }
}
