import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Student implements Serializable 
{
    String nm, grd, gitMessage = "GitHub";
    int rno; 

    public Student(String nm, int rno, String grd) 
    {
        this.nm = nm;
        this.rno = rno;
        this.grd = grd;
    }

    public int getRollNumber() 
    {
        return rno;
    }

    public void setRollNumber(int rno) 
    {
        this.rno = rno;
    }

    public String toString() 
    {
        return "Name: " + nm + ", Roll Number: " + rno + ", Grade: " + grd;
    }
}

class StudentManagementSystem 
{
    private List<Student> students;

    public StudentManagementSystem() 
    {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) 
    {
        students.add(student);
    }

    public void removeStudent(String rno) 
    {
        students.removeIf(student -> Integer.toString(student.getRollNumber()).equals(rno));
    }

    public Student searchStudent(String rno) 
    {
        for (Student student : students) 
        {
            if (Integer.toString(student.getRollNumber()).equals(rno)) 
            {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() 
    {
        for (Student student : students) 
        {
            System.out.println(student);
        }
    }

    public void saveToFile(String fileName) 
    {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) 
        {
            oos.writeObject(students);
            System.out.println("Data saved successfully!");
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String fileName) 
    {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) 
        {
            students = (List<Student>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } 
        catch (IOException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
    }
}

public class task3
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StudentManagementSystem studentManagementSystem = new StudentManagementSystem();
        String fileName = "student_data.ser";

        System.out.println(gitMessage);

        File file = new File(fileName); // Load data from file (if it exists)
        if (file.exists()) 
        {
            studentManagementSystem.loadFromFile(fileName);
        }

        while (true) 
        {
        	 System.out.println("\n============================================");
            System.out.println("\n	 Student Management System ");
            System.out.println("\n=============================================");
            System.out.println("1. Add a new student");
            System.out.println("2. Remove a student");
            System.out.println("3. Search for a student");
            System.out.println("4. Display all students");
            System.out.println("5. Save and Exit");
            System.out.println("\n=============================================");
            System.out.print("Enter your choice (1-5): ");
         
            
            String choice = sc.nextLine();

            switch (choice) 
            {
                case "1":
                    Student student = getStudentInfoFromUser(sc);
                    studentManagementSystem.addStudent(student);
                    System.out.println("Student added successfully!");
                    break;

                case "2":
                    System.out.print("Enter the roll number of the student to remove: ");
                    int rollNumberToRemove = Integer.parseInt(sc.nextLine());
                    studentManagementSystem.removeStudent(Integer.toString(rollNumberToRemove));
                    System.out.println("Student removed successfully!");
                    break;
                
                case "3":
                    System.out.print("Enter the roll number of the student to search for: ");
                    int rollNumberToSearch = Integer.parseInt(sc.nextLine());
                    Student searchedStudent = studentManagementSystem.searchStudent(Integer.toString(rollNumberToSearch));
                    if (searchedStudent != null) 
                    {
                        System.out.println("Student found:");
                        System.out.println(searchedStudent);
                    } 
                    else 
                    {
                        System.out.println("Student not found!");
                    }
                    break;

                case "4":
                    System.out.println("\nAll Students:");
                    studentManagementSystem.displayAllStudents();
                    break;

                case "5":
                    studentManagementSystem.saveToFile(fileName);
                    System.out.println("Data saved. Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static Student getStudentInfoFromUser(Scanner sc) 
    {
        System.out.print("Enter name of a student: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        int rollNumber = Integer.parseInt(sc.nextLine()); 
        System.out.print("Enter Grade: ");
        String grade = sc.nextLine();
        return new Student(name, rollNumber, grade);
    }
}