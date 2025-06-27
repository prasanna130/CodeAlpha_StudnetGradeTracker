import java.util.*;

class Student {
    private String name;
    private int rollNumber;
    private int[] marks;

    public Student(String name, int rollNumber, int[] marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getRollNumber() { return rollNumber; }
    public int[] getMarks() { return marks; }

    public double getAverage() {
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.length;
    }

    public int getHighest() {
        int max = marks[0];
        for (int mark : marks) if (mark > max) max = mark;
        return max;
    }

    public int getLowest() {
        int min = marks[0];
        for (int mark : marks) if (mark < min) min = mark;
        return min;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int numberOfStudents = scanner.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.next();

            System.out.print("Roll Number: ");
            int roll = scanner.nextInt();

            System.out.print("Number of subjects: ");
            int numSubjects = scanner.nextInt();

            int[] marks = new int[numSubjects];
            for (int j = 0; j < numSubjects; j++) {
                System.out.print("Enter marks for subject " + (j + 1) + ": ");
                marks[j] = scanner.nextInt();
            }

            students.add(new Student(name, roll, marks));
        }

        System.out.println("\n========== Student Grade Summary ==========");
        for (Student s : students) {
            System.out.println("\nName: " + s.getName());
            System.out.println("Roll Number: " + s.getRollNumber());
            System.out.println("Marks: ");
            int[] m = s.getMarks();
            for (int i = 0; i < m.length; i++) {
                System.out.println("Subject " + (i + 1) + ": " + m[i]);
            }
            System.out.printf("Average Score: %.2f\n", s.getAverage());
            System.out.println("Highest Score: " + s.getHighest());
            System.out.println("Lowest Score: " + s.getLowest());
        }

        scanner.close();
    }
}
