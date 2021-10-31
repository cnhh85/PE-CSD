import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        View();
    }

    private static void View() {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        DoublyLinkedList<Student> students = new DoublyLinkedList<Student>();
        ArrayList<String> classes = new ArrayList<String>();
        System.out.println("=======STUDENT MANAGEMENT=======");
        do {
            Menu();
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again!");
                System.out.println();
            }
            switch (choice) {
            case 1:
                createList(students, classes);
                break;
            case 2:
                searchStudent(students);
                break;
            case 3:
                sortByScore(students);
                break;
            case 4:
                printByClass(students, classes);
                break;
            case 5:
                System.out.println("Exiting");
                break;
            default:
                System.out.println("Invalid input, please try again!\n");
            }
        } while (choice != 5);
    }

    private static void Menu() {
        System.out.println("1. Create students list");
        System.out.println("2. Number of students in class");
        System.out.println("3. Sort by average score");
        System.out.println("4. Print students by class");
        System.out.println("5. Exit");
        System.out.print("Your choice: ");
    }

    private static void createList(DoublyLinkedList<Student> students, ArrayList<String> classes) {
        int quantity = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter number of students: ");
            try {
                quantity = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please try again!\n");
            }
        } while (quantity <= 0);
        for (int i = 0; i <= quantity; i++) {
            String name = null, className = null;
            double average = -1;
            System.out.println("Add student number " + i + ": ");

            do {
                System.out.print("Enter name: ");
                name = sc.nextLine();
                if (isEmpty(name)) {
                    System.out.println("String cannot be empty");
                }
            } while (isEmpty(name));

            do {
                System.out.print("Enter class: ");
                className = sc.nextLine();
                if (isEmpty(className)) {
                    System.out.println("String cannot be empty");
                }
            } while (isEmpty(className));

            do {
                System.out.print("Enter average score: ");
                try {
                    average = Double.parseDouble(sc.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input, please try again!\n");
                }
                if (average < 0 || average > 10) {
                    System.out.println("Invalid score please try again!");
                }
            } while (average < 0 || average > 10);

            Student student = new Student(name, className, average);
            students.addLast(student);
            classes.add(className);
        }
    }

    private static void searchStudent(DoublyLinkedList<Student> students) {
        Scanner sc = new Scanner(System.in);
        String className;
        do {
            System.out.print("Enter class: ");
            className = sc.nextLine();
            if (isEmpty(className)) {
                System.out.println("String cannot be empty");
            }
        } while (isEmpty(className));
        ArrayList<Student> list = students.convertToList();
        ArrayList<Student> result = new ArrayList<Student>();

        for (Student student : list) {
            if (className.equals(student.getClassName())) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No student in " + className);
        } else {
            for (Student student : result) {
                printStudent(student);
            }
        }

    }

    private static void sortByScore(DoublyLinkedList<Student> students) {
        ArrayList<Student> list = students.convertToList();
        list.stream().sorted((s1, s2) -> getSorter(s1.getAverage(), s2.getAverage()));
        for (Student student : list) {
            printStudent(student);
        }
    }

    private static int getSorter(Double s1, Double s2) {
        return s1 - s2 < 0 ? -1 : 1;
    }

    private static void printByClass(DoublyLinkedList<Student> students, ArrayList<String> classes) {
        ArrayList<Student> list = students.convertToList();
        for (String className : classes) {
            for (Student student : list) {
                if (student.getClassName().equals(className)) {
                    printStudent(student);
                }
            }
            System.out.println("====================================");
        }
    }

    private static void printStudent(Student student) {
        System.out.format("|%30s|%6|%6lf|%6s|\n", student.getName(), student.getClassName(), student.getAverage(),
                student.getRank());
    }

    private static boolean isEmpty(String string) {
        if (string.equals("")) {
            return true;
        } else {
            return false;
        }
    }
}