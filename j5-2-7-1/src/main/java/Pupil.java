public class Pupil {
    private String name;
    private int averageScore;
    private int violationCount;
    private String message;

    public Pupil(String name, int averageScore, int violationCount) {
        this.name = name;
        this.averageScore = averageScore;
        this.violationCount = violationCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getViolationCount() {
        return violationCount;
    }

    public void setViolationCount(int violationCount) {
        this.violationCount = violationCount;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
