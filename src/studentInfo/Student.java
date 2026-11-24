package studentInfo;

public class Student {
    private String Name;
    private StudentSubjects[] studentSubjects=new StudentSubjects [3];


    public void  setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }
    public void setSubject(int index, StudentSubjects subject) {
        if (index >= 0 && index < studentSubjects.length) {
            studentSubjects[index] = subject;
        }
    }

    public StudentSubjects getSubject(int index) {
        if (index >= 0 && index < studentSubjects.length) {
            return studentSubjects[index];
        }
        return null;
    }
}
