package entity;

public class GenderCountResult {
    private final int maleCount;
    private final int femaleCount;
    private final int sum;

    public GenderCountResult(int maleCount, int femaleCount) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
        this.sum = maleCount + femaleCount;
    }


    public double getMaleRatio() {
        return (double) maleCount / (double) sum;
    }
    public double getFemaleRatio() {
        return (double) femaleCount / (double) sum;
    }

    public int getMaleCount() {return maleCount;}
    public int getFemaleCount() {return femaleCount;}
}
