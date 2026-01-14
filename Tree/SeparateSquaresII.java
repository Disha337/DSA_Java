//Leetcode 3454. Separate Squares II
//Approach : Sweep Line + Segment Tree
//TIme Complexity : O(n log n)
//Space Complexity : O(n)
import java.util.*;

class Solution {

    static class Event {
        long y;
        int x1, x2;
        int type; // +1 add, -1 remove

        Event(long y, int x1, int x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int[] count;
        long[] length;
        long[] xs;
        int n;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[4 * n];
            length = new long[4 * n];
        }

        void update(int node, int l, int r, int ql, int qr, int val) {
            if (qr <= l || r <= ql) return;

            if (ql <= l && r <= qr) {
                count[node] += val;
            } else {
                int mid = (l + r) / 2;
                update(node * 2, l, mid, ql, qr, val);
                update(node * 2 + 1, mid, r, ql, qr, val);
            }

            if (count[node] > 0) {
                length[node] = xs[r] - xs[l];
            } else if (l + 1 == r) {
                length[node] = 0;
            } else {
                length[node] = length[node * 2] + length[node * 2 + 1];
            }
        }

        long query() {
            return length[1];
        }
    }

    public double separateSquares(int[][] squares) {

        List<long[]> rawEvents = new ArrayList<>();
        Set<Long> xSet = new HashSet<>();

        // Collect x-coordinates and raw events
        for (int[] s : squares) {
            long x1 = s[0];
            long x2 = x1 + s[2];
            long y1 = s[1];
            long y2 = y1 + s[2];

            xSet.add(x1);
            xSet.add(x2);

            rawEvents.add(new long[]{y1, x1, x2, +1});
            rawEvents.add(new long[]{y2, x1, x2, -1});
        }

        // Coordinate compression
        long[] xs = xSet.stream().sorted().mapToLong(Long::longValue).toArray();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++) map.put(xs[i], i);

        // Build final events with correct x indices
        List<Event> events = new ArrayList<>();
        for (long[] e : rawEvents) {
            events.add(new Event(
                e[0],
                map.get(e[1]),
                map.get(e[2]),
                (int) e[3]
            ));
        }

        events.sort(Comparator.comparingLong(e -> e.y));

        // -------- First sweep: total area --------
        SegmentTree st = new SegmentTree(xs);
        long prevY = events.get(0).y;
        double totalArea = 0;

        for (Event e : events) {
            long dy = e.y - prevY;
            totalArea += st.query() * dy;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }

        double half = totalArea / 2.0;

        // -------- Second sweep: find answer --------
        st = new SegmentTree(xs);
        prevY = events.get(0).y;
        double area = 0;

        for (Event e : events) {
            long dy = e.y - prevY;
            long width = st.query();
            double block = width * dy;

            if (width > 0 && area + block >= half) {
                return prevY + (half - area) / width;
            }

            area += block;
            st.update(1, 0, st.n, e.x1, e.x2, e.type);
            prevY = e.y;
        }

        return prevY;
    }
}
