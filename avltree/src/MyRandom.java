public class MyRandom {
    private double now = 0;
    private double cons=1e11;
    private final long seed;
    public MyRandom(long seed) {
        this.seed = seed;
    }
    public double nextDouble() {
        return now = Math.abs(
                (long)((long)cons * Math.sin(now * 10101 + seed)) /cons
        );
    }
}