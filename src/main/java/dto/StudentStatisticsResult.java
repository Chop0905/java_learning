package dto;

public class StudentStatisticsResult {
    private final int maleCount;
    private final int femaleCount;
    private final int totalCount;
    private final double maleRatio;
    private final double femaleRatio;
    private final double averageAge;

    public StudentStatisticsResult(int maleCount, int femaleCount, int totalCount,
                                   double maleRatio, double femaleRatio, double averageAge) {
        this.maleCount = maleCount;
        this.femaleCount = femaleCount;
        this.totalCount = totalCount;
        this.maleRatio = maleRatio;
        this.femaleRatio = femaleRatio;
        this.averageAge = averageAge;
    }

    // Getter们省略……

    public int getMaleCount() {
        return maleCount;
    }

    public int getFemaleCount() {
        return femaleCount;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public double getMaleRatio() {
        return maleRatio;
    }

    public double getFemaleRatio() {
        return femaleRatio;
    }

    public double getAverageAge() {
        return averageAge;
    }
}

