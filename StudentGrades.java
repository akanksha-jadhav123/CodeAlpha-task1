import java.util.ArrayList;
import java.util.Scanner;

public class StudentGrades {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> grades = new ArrayList<>();

        System.out.println("Enter the number of students:");
        int numberOfStudents = scanner.nextInt();

        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter grade for student " + i + ": ");
            int grade = scanner.nextInt();
            grades.add(grade);  // Add grade to the list
        }

        if (grades.size() > 0) {
            int sum = 0;
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int grade : grades) {
                sum += grade;

                if (grade > highest) {
                    highest = grade;
                }
                if (grade < lowest) {
                    lowest = grade;
                }
            }

            double average = (double) sum / grades.size();

            System.out.println("Average Grade: " + average);
            System.out.println("Highest Grade: " + highest);
            System.out.println("Lowest Grade: " + lowest);
        } else {
            System.out.println("No grades entered.");
        }
        scanner.close();
    }
}
