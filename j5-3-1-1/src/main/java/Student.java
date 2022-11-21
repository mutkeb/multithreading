public class Student {
    // 名字
    private String name;
    // 期中考试分数
    private int midtermScore;

    public Student(String name, int midtermScore) {
        this.name = name;
        this.midtermScore = midtermScore;
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
}
