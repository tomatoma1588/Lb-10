class Student {
    String firstName;
    String lastName;
    String studentId;
    double averageScore;

    public Student(String firstName, String lastName, String studentId, double averageScore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.averageScore = averageScore;
    }
}

class Faculty {
    String name;
    List<Student> students;

    public Faculty(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }
}

class Institute {
    String name;
    List<Faculty> faculties;

    public Institute(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }
}

public class Lab10 {
    public static void main(String[] args) {
        // Приклад даних
        Student student1 = new Student("Іван", "Іванов", "12345", 96.0);
        Student student2 = new Student("Марія", "Петрівна", "12346", 98.5);
        Student student3 = new Student("Олег", "Сидоров", "12347", 89.0);
        Faculty faculty1 = new Faculty("Факультет Інформатики", Arrays.asList(student1, student2));
        Faculty faculty2 = new Faculty("Факультет Математики", Arrays.asList(student3));
        Institute institute = new Institute("КПІ", Arrays.asList(faculty1, faculty2));

        // Завдання 1: Загальна кількість студентів (нетипізований ітератор)
        int totalStudents = 0;
        Iterator<Faculty> facultyIterator = institute.faculties.iterator();
        while (facultyIterator.hasNext()) {
            Faculty faculty = facultyIterator.next();
            totalStudents += faculty.students.size();
        }
        System.out.println("Загальна кількість студентів: " + totalStudents);

        // Завдання 2: Факультет з найбільшою кількістю студентів (типізований for-each)
        Faculty largestFaculty = null;
        int maxStudents = 0;
        for (Faculty faculty : institute.faculties) {
            if (faculty.students.size() > maxStudents) {
                maxStudents = faculty.students.size();
                largestFaculty = faculty;
            }
        }
        System.out.println("Факультет з найбільшою кількістю студентів: " + (largestFaculty != null ? largestFaculty.name : "Не знайдено"));

        // Завдання 3: Студенти з середнім балом 95..100 (типізований ітератор)
        List<Student> highScoreStudents = new ArrayList<>();
        for (Faculty faculty : institute.faculties) {
            Iterator<Student> studentIterator = faculty.students.iterator();
            while (studentIterator.hasNext()) {
                Student student = studentIterator.next();
                if (student.averageScore >= 95 && student.averageScore <= 100) {
                    highScoreStudents.add(student);
                }
            }
        }
        System.out.println("Студенти з середнім балом 95..100:");
        for (Student student : highScoreStudents) {
            System.out.println(student.firstName + " " + student.lastName + " (" + student.studentId + ")");
        }
    }
}
