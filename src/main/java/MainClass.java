import daoImpl.StudentDaoImpl;
import daoImpl.CourseDaoImpl;
import models.Student;
import models.Course;

public class MainClass {
    public static void main(String[] args) {
        StudentDaoImpl studentDao = new StudentDaoImpl();
        CourseDaoImpl courseDao = new CourseDaoImpl();

        // Create new students
        Student student1 = new Student("John", "Doe", "john.doe@example.com");
        Student student2 = new Student("Jane", "Smith", "jane.smith@example.com");

        // Create new courses
        Course course1 = new Course("Math 101", "Basic Mathematics");
        Course course2 = new Course("History 101", "World History");

        // Save students and courses
        studentDao.save(student1);
        studentDao.save(student2);
        courseDao.save(course1);
        courseDao.save(course2);

        // Add courses to students
        student1.addCourse(course1);
        student1.addCourse(course2);
        student2.addCourse(course1);

        // Update students to reflect the course additions
        studentDao.update(student1);
        studentDao.update(student2);

        // Find and print all students
        System.out.println("All Students:");
        for (Student student : studentDao.findAll()) {
            System.out.println(student);
        }

        // Find and print all courses
        System.out.println("All Courses:");
        for (Course course : courseDao.findAll()) {
            System.out.println(course);
        }

        // Clean up
        studentDao.close();
        courseDao.close();
    }
}