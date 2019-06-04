import java.util.*;
import java.io.*;

public class Main {

	static int IDGenerator = 5;
	static int IDGeneratorSubject =2;
	static int IDGeneratorCourse =2;
	
	public static void main(String [] args){
		
		try{

			ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("memoryUsers.dat"));
			ArrayList <User> users = (ArrayList<User>)inStream.readObject();
			inStream.close();
			ObjectInputStream inStream1 = new ObjectInputStream(new FileInputStream("memorySubject.dat"));
			ArrayList <Subject> Subject = (ArrayList<Subject>)inStream1.readObject();
			inStream1.close();
			/*
			ObjectInputStream inStream2 = new ObjectInputStream(new FileOutputStream("memoryCourseStudents.dat"));
			ArrayList <ArrayList<User>> CourseStudents = (ArrayList<ArrayList<User>>)inStream.readObject();
			inStream2.close();
			*/
			ObjectInputStream inStream2 = new ObjectInputStream(new FileInputStream("memoryCourse.dat"));
			ArrayList <Course> Course =(ArrayList<Course>)inStream2.readObject();
			inStream2.close();
			ObjectInputStream inStream3 = new ObjectInputStream(new FileInputStream("memoryStudentsArray.dat"));
			ArrayList<User> StudentsArray = (ArrayList<User>)inStream3.readObject();
			inStream3.close();
			Scanner sc = new Scanner(System.in);
			System.out.println("Please login");
			System.out.print("Insert login: ");
			String Ilogin = sc.next();
			System.out.print("Insert password: ");
			String Ipassword = sc.next();
			int Irank = 0;
			int TeacherID = 0;
			int StudentsID = 0;
			String choice;
			boolean state =true;
			boolean state1 =true;
			
			for(int i=0; i<users.size();i++){
				if(users.get(i).getLogin().equals(Ilogin) && users.get(i).getLogin().equals(Ipassword)){
					if(users.get(i) instanceof Admin){
					
						Irank=1;
						
					}
					if(users.get(i) instanceof Teacher){
					
						Irank=2;
						TeacherID = users.get(i).getId();
						
					}
					


                            if(users.get(i) instanceof Student ==true){
					
						Irank=3;
						StudentsID = users.get(i).getId();
						
					}
				}
			}
			if(Irank == 1){
				while(state){
				
					System.out.println("PRESS [1] TO ADD A NEW USER");
					
System.out.println("PRESS [2] TO ADD A NEW SUBJECT");
					System.out.println("PRESS [3] TO ADD NEW COURSE");
					System.out.println("PRESS [4] TO ASSIGN STUDENTS INTO COURSES");
					System.out.println("PRESS [5] TO EDIT USERS");
					System.out.println("PRESS [6] TO DELETE USERS");
					System.out.println("PRESS [7] TO EDIT COURSES");
					System.out.println("PRESS [8] TO DELETE COURSES");
					System.out.println("PRESS [9] TO EDIT SUBJECT");
					System.out.println("PRESS [10] TO DELETE SUBJECT");
					System.out.println("PRESS [0] TO EXIT");
					
					choice = sc.next();
					
					if(choice.equals("1")){
						while(state1){
							System.out.println("PRESS [1] TO ADD ADMIN");
							System.out.println("PRESS [2] TO ADD TEACHER");
							System.out.println("PRESS [3] TO ADD STUDENT");
							System.out.println("PRESS [0] TO GO BACK");
							
							String choice1 = sc.next();
							
								
								
							if(choice1.equals("1")){
								System.out.print("Insert login: ");
								String login1 = sc.next();
								System.out.print("Insert password: ");
								String password1 = sc.next();
								users.add(new Admin(IDGenerator, login1, password1));
								IDGenerator++;
							}
							
							if(choice1.equals("2")){
								System.out.print("Insert login: ");
								String login2 = sc.next();
								System.out.print("Insert password: ");
								String password2 = sc.next();
								System.out.print("Insert Name: ");
								String name2 = sc.next();
								System.out.print("Insert Surname: ");
								String surname2=sc.next();
								System.out.print("Insert Degree: ");
								String degree2=sc.next();
								System.out.print("insert Department: ");
								String department2=sc.next();
								users.add(new Teacher(IDGenerator, login2, password2, name2, surname2, degree2, department2));
								IDGenerator++;
							}
							
							if(choice1.equals("3")){
								System.out.print("Insert login: ");
								String login3 = sc.next();
								System.out.print("Insert password: ");
								String password3 = sc.next();
								System.out.print("Insert Name: ");
								String name3 = sc.next();
								System.out.print("Insert Surname: ");
								String surname3=sc.next();
								System.out.print("Insert Group: ");
								String group3=sc.next();
								users.add(new Student(IDGenerator, login3, password3, name3, surname3, group3));
								IDGenerator++;
								
							}
							if(choice1.equals("0")){
								state1 = false;
							}
						}
					}
					if(choice.equals("2")){
		
						System.out.print("INSERT NAME: ");
						String name2 = sc.next();
						System.out.print("INSERT DESCRIPTION: ");
						String description2 = sc.next();
						Subject.add(new Subject(IDGeneratorSubject,name2, description2));
						IDGeneratorSubject++;
						
					}

					if(choice.equals("3")){
						
						System.out.print("INSERT NAME: ");
						String name2 = sc.next();
						for(int i =0; i<Subject.size(); i++){
							System.out.println(Subject.get(i).getSubjectData());
						}
						System.out.print("INSERT ID OF A SUBJECT: ");
						
						int id1 = sc.nextInt();
						for(int i =0; i<users.size(); i++){
							if(users.get(i) instanceof Teacher){
								System.out.println(users.get(i).getUserData());
							}
						}
						for(int i =0; i<Subject.size();i++){
							if(Subject.get(i).getId()==id1){
								id1=i;
							}
						}
						
						System.out.print("INSERT ID OF A TEACHER: ");
						
						int id2 = sc.nextInt();
						for(int i =0; i<users.size();i++){
							if(users.get(i).getId()==id2){
								id2=i;
							}
						}
						ArrayList<User> StudentsArray1 = new ArrayList<User>();
						Course.add(new Course(IDGeneratorCourse, name2, Subject.get(id1), StudentsArray1 ,users.get(id2)));
						IDGeneratorCourse++;
					}
					if(choice.equals("4")){

						for(int i =0; i<Course.size(); i++){
							System.out.println(Course.get(i).getCourseData());
						}
						System.out.print("INSERT ID OF A COURSE: ");
						int id3 = sc.nextInt();
						int Number = 0;
						for(int i = 0; i<Course.size();i++){
							
							if(Course.get(i).getId() == id3){
								
								Number = i;
								
							}
							
						}
						boolean state3 = true;
						
						while(state3){
							System.out.println("PRESS [1] TO ADD STUDENT");
							System.out.println("PRESS [2] TO REMOVE STUDENT");
							System.out.println("PRESS [0] TO GO BACK");
							
							String choice1 = sc.next();
							if(choice1.equals("1")){
								
								int x;
								for(int i=0; i<users.size();i++){
									x=0;
									for(int j=0;j<Course.get(Number).getStudents().size();j++){ 	//5
										if(users.get(i).getId() == Course.get(Number).getStudents().get(j).getId()){
											x++;
										}
									}
									if(x==0 && users.get(i) instanceof Student){
										System.out.println(users.get(i).getUserData());
									}
								}
								System.out.print("INSERT ID OF A STUDENT: ");
								int id4 = sc.nextInt();
								int X=0;
								for(int i = 0; i<users.size(); i++){
									if(users.get(i).getId() == id4){
										X = i;
									}
								}
								for(int i=0; i<Course.get(Number).getStudents().size();i++){
									if(Course.get(Number).getStudents().get(i).getId() == id4 || users.get(X) instanceof Student == false){
										System.out.println("You cannot pick this User");
										i=Course.get(Number).getStudents().size();
										id4=-100;
									}
								}
								if(id4!=-100){
									Course.get(Number).getStudents().add(users.get(X));
								}
							}
							if(choice1.equals("2")){
							int x=0;
								for(int i=0; i<users.size();i++){
									for(int j=0;j<Course.get(Number).getStudents().size();j++){ 	//5
										if(users.get(i).getId() == Course.get(Number).getStudents().get(j).getId()){
											System.out.println(users.get(i).getUserData());
											j=Course.get(Number).getStudents().size();
										}
									}
								}
								System.out.print("INSERT ID OF A STUDENT: ");
								int id4 = sc.nextInt();
								for(int i = 0; i<Course.get(Number).getStudents().size(); i++){
								
									if(Course.get(Number).getStudents().get(i).getId() == id4){
										Course.get(Number).getStudents().remove(Course.get(Number).getStudents().get(i));
										x++;
									}
									
								}
								if(x==0){
									System.out.println("You cannot remove this Student");
								}
							}
							if(choice1.equals("0")){
								
								state3 =false;
								
							}
						}
					}
						
					if(choice.equals("5")){
							for(int i=0; i<users.size();i++){
								System.out.println(users.get(i).getUserData());
							}
							System.out.println("INSERT ID OF USER: ");	
							int id5 = sc.nextInt();
							for(int i = 0 ; i<users.size(); i++){
								if(users.get(i).getId() == id5){
									String login3 = users.get(i).getLogin();
									String password3 = users.get(i).getPassword();
									if(users.get(i) instanceof Admin){
										boolean state3 =true;
										while(state3){
											System.out.println("PRESS [1] TO CHANGE LOGIN");
											System.out.println("PRESS [2] TO CHANGE PASSWORD");
											System.out.println("PRESS [0] TO  SAVE USER");
											String choice2 = sc.next();
											if(choice2.equals("1")){
												System.out.print("INSERT LOGIN: ");
												login3 = sc.next();
											}
											if(choice2.equals("2")){
												System.out.print("INSERT PASSWORD: ");
												password3 = sc.next();
											}
											if(choice2.equals("0")){
												users.set(i, new Admin(id5, login3, password3));
												state3 = false;
											}
										}
									}
								if(users.get(i) instanceof Teacher){
									boolean state3 = true;
									while(state3){
										Teacher teacher1 = new Teacher();
										teacher1 =(Teacher)(users).get(i);
										String name3 = teacher1.getName();
										String surname3 = teacher1.getSurname();
										String degree3 = teacher1.getDegree();
										String department3 = teacher1.getDepartment();
										System.out.println("PRESS [1] TO CHANGE LOGIN");
										System.out.println("PRESS [2] TO CHANGE PASSWORD");
										System.out.println("PRESS [3] TO CHANGE NAME");
										System.out.println("PRESS [4] TO CHANGE SURNAME");
										System.out.println("PRESS [5] TO CHANGE DEGREE");
										System.out.println("PRESS [6] TO CHANGE DEPARTMENT");
										System.out.println("PRESS [0] TO  SAVE USER");
										String choice2 = sc.next();
										if(choice2.equals("1")){
											System.out.print("INSERT LOGIN: ");
											login3 = sc.next();
										}
										if(choice2.equals("2")){
											System.out.print("INSERT PASSWORD: ");
											password3 = sc.next();
										}
										if(choice2.equals("3")){
											System.out.print("INSERT NAME: ");
											name3 = sc.next();
										}
										if(choice2.equals("4")){
											System.out.print("INSERT SURNAME: ");
											surname3 = sc.next();
										}
										if(choice2.equals("5")){
											System.out.print("INSERT DEGREE: ");
											degree3 = sc.next();
										}
										if(choice2.equals("6")){
											System.out.print("INSERT DEPARTMENT: ");
											department3 = sc.next();
										}
										if(choice2.equals("0")){
											users.set(i, new Teacher(id5, login3, password3, name3, surname3, degree3, department3));
											state3 = false;
										}
									}
								}
								if(users.get(i) instanceof Student){
									boolean state3 =true;
									while(state3){
										Student student1 = new Student();
										student1 = (Student)(users).get(i);
										String name3 = student1.getName();
										String surname3 = student1.getSurname();
										String group3 = student1.getGroup();
										System.out.println("PRESS [1] TO CHANGE LOGIN");
										System.out.println("PRESS [2] TO CHANGE PASSWORD");
										System.out.println("PRESS [3] TO CHANGE NAME");
										System.out.println("PRESS [4] TO CHANGE SURNAME");
										System.out.println("PRESS [5] TO CHANGE GROUP");
										System.out.println("PRESS [0] TO  SAVE USER");
										String choice2 = sc.next();
										if(choice2.equals("1")){
											System.out.print("INSERT LOGIN: ");
											login3 = sc.next();
										}
										if(choice2.equals("2")){
											System.out.print("INSERT PASSWORD: ");
											password3 = sc.next();
										}
										if(choice2.equals("3")){
											System.out.print("INSERT NAME: ");
											name3 = sc.next();
										}
										if(choice2.equals("4")){
											System.out.print("INSERT SURNAME: ");
											surname3 = sc.next();
										}
										if(choice2.equals("5")){
											System.out.print("INSERT GROUP: ");
											group3 = sc.next();
										}
										if(choice2.equals("0")){
											users.set(i, new Student(id5, login3, password3, name3, surname3, group3));
											state3 = false;
										}
									}
								}
							}	
						}
					}
					if(choice.equals("6")){
						for(int i=0; i<users.size();i++){
							System.out.println(users.get(i).getUserData());
						}
						System.out.println("INSERT ID OF USER: ");	
						int id5 = sc.nextInt();
						int c1=0;
						for(int i = 0 ; i<users.size(); i++){
							if(users.get(i).getId() == id5){
								users.remove(i);
								c1++;
								System.out.println("User was deleted");
							}
						}
						if(c1!=1){
							System.out.println("You cannot delete this user");
						}
					}
				
					if(choice.equals("7")){
					
						for(int i=0; i<Course.size();i++){
							System.out.println(Course.get(i).getCourseData());
						}
						System.out.println("INSERT ID OF COURSES: ");	
						int id5 = sc.nextInt();	
						for(int i = 0 ; i<Course.size(); i++){
							if(Course.get(i).getId() == id5){
							boolean state4 =true;
							String name2 = Course.get(i).getName();
							Subject subject2 = new Subject();
							subject2 = Course.get(i).getSubject();
							ArrayList<ArrayList<User>> students2 = new ArrayList<ArrayList<User>>();
							students2.add(Course.get(i).getStudents());
							User teacher4 = new Teacher();
							teacher4 = Course.get(i).getTeacher();
								while(state4){
									
									System.out.println("PRESS [1] TO CHANGE NAME");
									System.out.println("PRESS [2] TO CHANGE SUBJECT");
									//	System.out.println("PRESS [4] TO CHANGE LIST OF STUDENTS");
									System.out.println("PRESS [3] TO CHANGE TEACHER");
									System.out.println("PRESS [0] TO SAVE COURSE");
									String choice3 = sc.next();
									if(choice3.equals("1")){
										System.out.print("ENTER NAME: ");
										name2 = sc.next();
									}
									if(choice3.equals("2")){
										for(int j = 0; j<Subject.size();j++){
											if(Course.get(i).getSubject().getId()!= Subject.get(j).getId()){
												System.out.println(Subject.get(j).getSubjectData());
											}
										}
										System.out.print("CHOOSE ID OF SUBJECT: ");
										int id2 = sc.nextInt();
										int c1 = 0;
										for(int j = 0; j<Subject.size();j++){
											if(Subject.get(j).getId() == id2 && Course.get(i).getSubject().getId()!=id2){
												subject2 = Subject.get(j);
												c1++;
											}
										}
										if(c1!=1){
											System.out.println("You cannot pick this subject");
										}
									}
									if(choice3.equals("3")){
										for(int j = 0 ; j<users.size();j++){
											if(users.get(j) instanceof Teacher && users.get(j).getId() != teacher4.getId()){
												System.out.println(users.get(j).getUserData());
											}
										}
										System.out.print("CHOOSE ID OF TEACHER: ");
										int id3=sc.nextInt();
										int c1 = 0;
										for(int j=0;j<users.size();j++){
											if(users.get(j).getId() == id3 && users.get(j).getId() != teacher4.getId() && users.get(j) instanceof Teacher ==true){
												teacher4 = users.get(j);
												c1++;
												
											}
										}
										if(c1!=1){
											System.out.println("You cannot pick this techer");
										}
									}
									/*
									if(choice3.equals("4")){
										for(int j=0; j<CourseStudents.size();i++){
											System.out.println("ID: "+j+" ArrayList Number"+j);
										}
										System.out.print("CHOOSE ID OF ARRAYLIST OF STUDETNS");
										int id3 = sc.nextInt();
										students2.add(CourseStudents.get(id3));
									}
									*/
									if(choice3.equals("0")){
										Course.set(i, new Course(id5, name2,  subject2, students2.get(0), teacher4));
										state4 = false;
									}
								}
							}
						}
					}
					if(choice.equals("8")){
						for(int i=0; i<Course.size();i++){
							System.out.println(Course.get(i).getCourseData());
						}
						System.out.println("INSERT ID OF COURSES: ");	
						int id5 = sc.nextInt();
						int c1=0;
						for(int i=0;i<Course.size();i++){
							if(Course.get(i).getId() == id5){
								Course.remove(i);
								c1++;
								System.out.println("Course was deleted");
							}
						}
						if(c1!=1){
							System.out.println("You cannot delete this course");
						}
					}
					if(choice.equals("9")){
						for(int i=0; i<Subject.size();i++){
							System.out.println(Subject.get(i).getSubjectData());
						}
						System.out.print("INSERT ID OF SUBJECT: ");	
						int id5 = sc.nextInt();
						for(int i=0;i<Subject.size();i++){
							if(Subject.get(i).getId() == id5){
								boolean state3 = true;
								String name2 = Subject.get(i).getName();
								String description3 = Subject.get(i).getDescription();
								while(state3){
									System.out.println("PRESS [1] TO CHANGE NAME");
									System.out.println("PRESS [2] TO CHANGE DESCRIPTION");
									System.out.println("PRESS [0] TO SAVE SUBJECT");
									String id3=sc.next();
									if(id3.equals("1")){
										System.out.print("INSERT NAME: ");
										name2 = sc.next();
									}
									if(id3.equals("2")){
										System.out.print("INSERT DESCRIPTION: ");
										description3 = sc.next();
									}
									if(id3.equals("0")){
										Subject.set(i, new Subject(id5, name2, description3));
										state3 = false;
									}
								}
							}
						}
					}
					if(choice.equals("10")){
					
						for(int i=0; i<Subject.size();i++){
							System.out.println(Subject.get(i).getSubjectData());
						}
						System.out.print("INSERT ID OF SUBJECT: ");	
						int id5 = sc.nextInt();
						int c1=0;
						for(int i=0;i<Subject.size();i++){
							if(Subject.get(i).getId() == id5){
								Subject.remove(i);
								c1++;
								System.out.println("Subject was deleted");
							}
						}
						if(c1!=1){
							System.out.println("You cannot delete this subject");
						}
					}
					if(choice.equals("0")){
						state = false;
					}
				}
			}
			if(Irank ==2){
				boolean state3 = true;
				while(state3){
					System.out.println("PRESS [1] TO LIST MY COURSES");
					System.out.println("PRESS [2] TO LIST MY STUDENTS");
					System.out.println("PRESS [0] TO EXIT");
					
					String choice5 = sc.next();
					
					if(choice5.equals("1")){
							
						for(int j =0; j<Course.size(); j++){
							if(TeacherID == Course.get(j).getTeacher().getId()){
								System.out.println(Course.get(j).getCourseData());
							}
						}
					
					}
					if(choice5.equals("2")){
						for(int j = 0; j<Course.size();j++){
							if(TeacherID == Course.get(j).getTeacher().getId()){
								for(int c = 0; c<Course.get(j).getStudents().size() ; c++){
									System.out.println(Course.get(j).getStudents().get(j).getUserData());
								}
							}
						}
					}	
					if(choice5.equals("0")){
						state3 = false;
					}
				}
			}
			if(Irank ==3){
				boolean state3 = true;
				while(state3){
					System.out.println("PRESS [1] TO LIST MY COURSES");
					System.out.println("PRESS [0] TO EXIT");
					String choice5 = sc.next();
					if(choice5.equals("1")){
						for(int j =0; j<Course.size(); j++){
							for(int c =0;c<Course.get(j).getStudents().size(); c++){
								if(StudentsID == Course.get(j).getStudents().get(c).getId()){
									System.out.println(Course.get(j).getCourseData());
								}
							}
						}
					}
					if(choice5.equals("0")){
						state3 = false;
					}
				}
			}
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
			
		
		
