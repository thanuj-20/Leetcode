class Solution {
    static class Node {
        long val;
        int pos;
        Node prev, next;
        boolean alive = true;
        Node(long v, int p) {
            val = v;
            pos = p;
        }
    }

    static class Pair {
        long sum;
        Node left;
        Pair(long s, Node l) {
            sum = s;
            left = l;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;

        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) nodes[i] = new Node(nums[i], i);
        for (int i = 0; i < n; i++) {
            if (i > 0) nodes[i].prev = nodes[i - 1];
            if (i + 1 < n) nodes[i].next = nodes[i + 1];
        }

        java.util.PriorityQueue<Pair> pq = new java.util.PriorityQueue<>(
            (a, b) -> {
                if (a.sum != b.sum) return Long.compare(a.sum, b.sum);
                return Integer.compare(a.left.pos, b.left.pos);
            }
        );

        int bad = 0;
        for (int i = 0; i + 1 < n; i++) {
            pq.offer(new Pair(nodes[i].val + nodes[i + 1].val, nodes[i]));
            if (nodes[i].val > nodes[i + 1].val) bad++;
        }

        int ops = 0;

        while (bad > 0) {
            Pair p;
            while (true) {
                p = pq.poll();
                Node a = p.left;
                if (a.alive && a.next != null && a.next.alive &&
                    a.val + a.next.val == p.sum) {
                    break;
                }
            }

            Node a = p.left;
            Node b = a.next;

            if (a.prev != null && a.prev.val > a.val) bad--;
            if (a.val > b.val) bad--;
            if (b.next != null && b.val > b.next.val) bad--;

            a.val += b.val;
            b.alive = false;
            a.next = b.next;
            if (b.next != null) b.next.prev = a;

            if (a.prev != null && a.prev.val > a.val) bad++;
            if (a.next != null && a.val > a.next.val) bad++;

            if (a.prev != null)
                pq.offer(new Pair(a.prev.val + a.val, a.prev));
            if (a.next != null)
                pq.offer(new Pair(a.val + a.next.val, a));

            ops++;
        }

        return ops;
    }
}
