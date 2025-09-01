class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<T> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b.extraPassRatio, a.extraPassRatio));
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            maxHeap.offer(new T(getExtraPassRatio(pass, total), pass, total));
        }
        for (int i = 0; i < extraStudents; i++) {
            T current = maxHeap.poll();
            maxHeap.offer(new T(getExtraPassRatio(current.pass + 1, current.total + 1), current.pass + 1, current.total + 1));
        }
        double ratioSum = 0;
        while (!maxHeap.isEmpty()) {
            T current = maxHeap.poll();
            ratioSum += (double) current.pass / current.total;
        }
        return ratioSum / classes.length;
    }
    private double getExtraPassRatio(int pass, int total) {
        return (pass + 1) / (double) (total + 1) - (double) pass / total;
    }
    private static class T {
        double extraPassRatio;
        int pass;
        int total;
        T(double extraPassRatio, int pass, int total) {
            this.extraPassRatio = extraPassRatio;
            this.pass = pass;
            this.total = total;
        }
    }
}