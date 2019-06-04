import java.util.*;
import java.io.*;

public class MainSave {

	static int IDGenerator = 1;
	static int IDGeneratorSubject =1;
	static int IDGeneratorCourse =1;
	
	public static void main(String [] args){
	try{
		ArrayList <User> users = new ArrayList<User>();
		ArrayList <Subject> Subject = new ArrayList<Subject>();
		ArrayList <Course> Course = new ArrayList<Course>();
		ArrayList <ArrayList<User>> CourseStudents = new ArrayList<ArrayList<User>>();
		ArrayList<User> StudentsArray = new ArrayList<User>();
		users.add(new Admin(IDGenerator, "admin", "admin"));
		IDGenerator++;
		users.add(new Teacher(IDGenerator, "teacher", "teacher", "TeacherName", "TeacherSurname", "TeacherDegree", "TeacherDepartment"));		
		IDGenerator++;
		users.add(new Student(IDGenerator, "student", "student", "StudentName", "StudentSurname", "StudentGroup"));		
		IDGenerator++;
		users.add(new Student(IDGenerator, "student1", "student1", "StudentName", "StudentSurname", "StudentGroup"));		
		IDGenerator++;
		Subject.add(new Subject(IDGeneratorSubject, "subject", "subject"));
		IDGeneratorSubject++;
		StudentsArray.add(users.get(2));
		StudentsArray.add(users.get(3));
		Course.add(new Course(IDGeneratorCourse, "course", Subject.get(0),StudentsArray,users.get(1)));
		IDGeneratorCourse++;
		ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("memoryUsers.dat"));
		outStream.writeObject(users);
		outStream.close();
		ObjectOutputStream outStream1 = new ObjectOutputStream(new FileOutputStream("memorySubject.dat"));
		outStream1.writeObject(Subject);
		outStream1.close();
		/*
			ObjectOutputStream outStream2 = new ObjectOutputStream(new FileOutputStream("memoryCourseStudents.dat"));
			outStream2.writeObject(CourseStudents );
			outStream2.close();
		*/
		ObjectOutputStream outStream2 = new ObjectOutputStream(new FileOutputStream("memoryCourse.dat"));
		outStream2.writeObject(Course);
		outStream2.close();
		ObjectOutputStream outStream3 = new ObjectOutputStream(new FileOutputStream("memoryStudentsArray.dat"));
		outStream3.writeObject(StudentsArray);
		outStream3.close();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}
}

