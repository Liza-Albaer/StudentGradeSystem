package studentInfo;

public class StudentSubjects {
    private String subjectName;
    private int Grade;
    public void  setsubjectName(String name) {
        subjectName = name;
    }
    public void setGrade(int grade) {
        if(grade >= 0 && grade <= 100) {
            Grade = grade;
        }

    }
    public String getsubjectName() {
        return subjectName;
    }
    public int getGrade() {
        return Grade;
    }
}
