public class Student {
    // 名字
    private String name;
    // 期中考试分数
    private int midtermScore;
    // 期末考试分数
    private int lastScore;

    public Student(String name, int midtermScore, int lastScore) {
        this.name = name;
        this.midtermScore = midtermScore;
        this.lastScore = lastScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMidtermScore() {
        return midtermScore;
    }

    public void setMidtermScore(int midtermScore) {
        this.midtermScore = midtermScore;
    }

    public int getLastScore() {
        return lastScore;
    }

    public void setLastScore(int lastScore) {
        this.lastScore = lastScore;
    }
}
