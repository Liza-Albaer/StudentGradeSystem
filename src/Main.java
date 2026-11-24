
import java.util.Scanner;
import studentInfo.Student;
import studentInfo.StudentSubjects;

public class Main {

    public static void main(String[]  args) {

        Scanner scan = new Scanner(System.in);


        int n = 5;
        Student[] students = new Student[n];

        String[] subjects = new String[3];

        System.out.println("Enter Subject Names :");

        for (int j = 0; j < 3; j++) {
            System.out.print("Enter subject " + (j + 1) + " name: ");
            subjects[j] = scan.nextLine();
        }

        for (int i = 0; i < n; i++) {

            students[i] = new Student();

            System.out.print("\nEnter student " + (i + 1) + " name: ");
            students[i].setName(scan.nextLine());

            for (int j = 0; j < 3; j++) {

                StudentSubjects sub = new StudentSubjects();

                sub.setsubjectName(subjects[j]);

                int grade;

                while (true) {

                    System.out.print("Enter " + subjects[j] + " grade (0-100): ");
                    grade = scan.nextInt();
                    scan.nextLine();

                    if (grade >= 0 && grade <= 100) {
                        sub.setGrade(grade);
                        break;
                    } else {
                        System.out.println("Invalid grade.");
                    }
                }

                students[i].setSubject(j, sub);
            }
        }

        int choice;

        do {

            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Show All Students names.");
            System.out.println("2. Show all Students grades in each subject.");
            System.out.println("3. Search Student by name.");
            System.out.println("4. Count Passed Students");
            System.out.println("5. Display average for each subject.");
            System.out.println("6. Display highest grade in each subject.");
            System.out.println("7. Display letter grades (A-F).");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {

                // 1. Show all students names
                case 1:

                    for (int i = 0; i < n; i++) {
                        System.out.println((i + 1) + ". " + students[i].getName());
                    }

                    break;

                // 2. Show all students grades
                case 2:

                    for (int i = 0; i < n; i++) {

                        System.out.print(students[i].getName() + ": ");

                        for (int j = 0; j < 3; j++) {

                            StudentSubjects sub = students[i].getSubject(j);

                            System.out.print(sub.getsubjectName() + " = " + sub.getGrade());

                            if (j < 2) {
                                System.out.print(", ");
                            }
                        }

                        System.out.println();
                    }

                    break;

                // 3. Search student by name
                case 3:

                    System.out.print("Enter student name to search: ");
                    String searchName = scan.nextLine();

                    boolean found = false;

                    for (int i = 0; i < n; i++) {

                        if (students[i].getName().trim().equalsIgnoreCase(searchName.trim())) {

                            System.out.println("Found: " + students[i].getName());

                            for (int j = 0; j < 3; j++) {

                                StudentSubjects sub = students[i].getSubject(j);

                                System.out.println("  " + sub.getsubjectName() + ": " + sub.getGrade());
                            }

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Student not found.");
                    }

                    break;

                // 4. Count passed students
                case 4:

                    int passedCount = 0;

                    for (int i = 0; i < n; i++) {

                        int sum = 0;

                        for (int j = 0; j < 3; j++) {
                            sum += students[i].getSubject(j).getGrade();
                        }

                        double avg = sum / 3.0;

                        if (avg >= 50) {
                            passedCount++;
                        }
                    }

                    System.out.println("Passed students: " + passedCount);

                    break;

                // 5. Display average for each subject
                case 5:

                    System.out.println("\n--- Average for Each Subject ---");

                    for (int j = 0; j < 3; j++) {

                        String subjectName = subjects[j];

                        int sum = 0;

                        for (int i = 0; i < n; i++) {
                            sum += students[i].getSubject(j).getGrade();
                        }

                        double avg = (double) sum / n;

                        System.out.println(subjectName + ": " + avg);
                    }

                    break;

                // 6. Display highest grade in each subject
                case 6:

                    System.out.println("\n--- Highest Grade in Each Subject ---");

                    for (int j = 0; j < 3; j++) {

                        String subjectName = subjects[j];

                        int highest = students[0].getSubject(j).getGrade();

                        for (int i = 1; i < n; i++) {

                            int currentGrade = students[i].getSubject(j).getGrade();

                            if (currentGrade > highest) {
                                highest = currentGrade;
                            }
                        }

                        System.out.println(subjectName + ": " + highest);
                    }

                    break;

                // 7. Display letter grades
                case 7:

                    System.out.println("\n--- Letter Grades (A-F) ---");

                    for (int i = 0; i < n; i++) {

                        System.out.println(students[i].getName() + ":");

                        for (int j = 0; j < 3; j++) {

                            StudentSubjects sub = students[i].getSubject(j);

                            int g = sub.getGrade();

                            char letter;

                            if (g >= 85) {
                                letter = 'A';
                            } else if (g >= 75 ) {
                                letter = 'B';
                            } else if (g >= 65 ) {
                                letter = 'C';
                            } else if (g >= 50 ) {
                                letter = 'D';
                            } else {
                                letter = 'F';
                            }

                            System.out.println("  " + sub.getsubjectName() + ": " + g + " -> " + letter);
                        }
                    }

                    break;

                // 0. Exit
                case 0:

                    System.out.println("Exiting...");

                    break;

                default:
                 System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scan.close();
    }
}
