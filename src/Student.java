public class Student {
    private String name;
    private String className;
    private double average;
    private String rank;

    public Student(String name, String className, double average) {
        this.name = name;
        this.className = className;
        this.average = average;
        if (average < 5) {
            rank = "YEU";
        } else if (average <= 6) {
            rank = "TB";
        } else if (average < 8) {
            rank = "KHA";
        } else {
            rank = "GIOI";
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}