import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.HashMap;

public class SCRAMEApp {

    private static Scanner sc;
    private static ArrayList<Course> courseList;
    private static int studentCount;
    private static ArrayList<Student> studentList;
    private static int courseCount;
    private static HashMap<String, Integer> allMatricNos;
    private static HashMap<String, Integer> allCourseCodes;
    private static ArrayList<Faculty> facultyList;
    private static HashMap<Integer, Integer>  allfaculties;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        courseList = new ArrayList<>();
        studentList = new ArrayList<>();
        allMatricNos = new HashMap<>();
        allCourseCodes = new HashMap<>();
        courseCount = 0;
        studentCount = 0;
        System.out.println("Welcome to the SCRAME System! It's a good day, isn't it?");
        System.out.println();
        while(true){
            System.out.println("Please choose from the following list of operations (enter a number between 1 and 11):");
            System.out.println("1. Add a student");
            System.out.println("2. Add a course");
            System.out.println("3. Register student for a course (this includes registering for Tutorial/Lab classes");
            System.out.println("4. Check availableslot in a class (vacancy in a class)");
            System.out.println("5. Print student list by lecture, tutorial or laboratory session for a course");
            System.out.println("6. Enter course assessment components weightage");
            System.out.println("7. Enter coursework mark - inclusive of its components");
            System.out.println("8. Enter exam mark");
            System.out.println("9. Print course statistics");
            System.out.println("10, Print student transcript");
            System.out.println("11. Quit");
            int choice = 0;
            try{
                choice = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                System.out.println("The input is not valid, please enter a number between 1 and 11\n");
                continue;
            }
            if(choice < 1 || choice > 11){
                System.out.println("The input is not valid, please enter a number between 1 and 11\n");
                continue;
            }
            if(choice == 11) {
                System.out.println("Thanks for using SCRAME, see you next time!");
                break;
            }
            else if(choice == 1){
                addStudent();
            }
            else if(choice == 2){
                addCourse();
            }
            else if (choice == 3){
                addStudentToCourse();
            }
            else if(choice == 4){
                checkVacancy();
            }
            else if(choice == 5){
                printStudentList();
            }
            else if(choice == 6){
                enterAssessmentWeightage();
            }
            else if(choice == 7){
                enterCourseWorkMark();
            }
            else if(choice == 8){
                enterExamMark();
            }
            else if(choice == 9){
                printCourseStatistic();
            }
            else if(choice == 10){
                printStudentTranscript();
            }

        }
    }

    private static void addStudent(){
        System.out.println("Please enter the student's name");
        String name = sc.next();
        System.out.println("Please enter the Matriculation Number of " + name);
        String matricNo = sc.next();
        if(allMatricNos.containsKey(matricNo)){
            System.out.println("This Matriculation Number already exists in the system records, you can proceed with other operations\n");
            return;
        }
        System.out.println("Please enter the school of " + name);
        String school = sc.next();
        int gender = 0;
        while(gender == 0){
            System.out.print("Please enter the gender of " + name);
            System.out.println(" (enter a number between 1 and 3)");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Genderqueer");
            try{
                gender = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                gender = 0;
                System.out.println("The input is not valid, please enter a number between 1 and 3\n");
                continue;
            }
            if(gender < 1 || gender > 3){
                gender = 0;
                System.out.println("The input is not valid, please enter a number between 1 and 3\n");
            }
        }
        studentList.add(new Student(name, matricNo, school, gender));
        allMatricNos.put(matricNo, studentCount);
        studentCount++;
        System.out.println("You've successfully added the student " + name + " with Matric No. " + matricNo + " to the SCRAME System!");
        System.out.println();
        System.out.println("Below is the list of all current students, there are altogether " + studentList.size() + " students in the system.");
        int count = 1;
        for(Student s:studentList){
            System.out.println("(" + count + ") Name: " + s.getName() + "  |  Matric Number: " + s.getMatricNo());
            count++;
        }
        System.out.println();
    }

    private static void addCourse(){
        System.out.println("Please enter the Course Code");
        String name = sc.next();
        if(allMatricNos.containsKey(name)){
            System.out.println("This Course Code already exists in the system records, you can proceed with other operations\n");
            return;
        }
        System.out.println("Please enter the ID of the course coordinator for " + name);
        String ID = sc.next();
        while(!allfaculties.containsKey(ID)){
            System.out.println("There's no faculty in the system with ID " + ID + ", please check the correctness of the input and enter again\n");
            ID = sc.next();
        }
        ArrayList<Tutorial> tutorialList = new ArrayList<>();
        int choice = 0;
        while(choice == 0){
            System.out.println("Does this course contain any tutorial session? (enter 1 or 2)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            try{
                choice = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2\n");
                continue;
            }
            if(choice != 1 && choice != 2){
                choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2\n");
            }
        }
        if(choice == 1){
            System.out.println("Please enter the number of tutorial sessions");
            int number = 0;
            while(number == 0){
                try{
                    number = sc.nextInt();
                }
                catch (Exception e){
                    sc.next();
                    number = 0;
                    System.out.println("The input is not valid, please enter a number\n");
                    continue;
                }
                if(number <= 0){
                    number = 0;
                    System.out.println("The input is not valid, please enter a positive number\n");
                }
            }
            System.out.println("Please proceed with entring the information for the " + number + " tutorial sessions\n");
            for(int i = 0; i < number; i++){
                System.out.println("Please enter the ID of the tutorial session");
                int id = -1;
                while(id == -1){
                    try{
                        id = sc.nextInt();
                    }
                    catch (Exception e){
                        sc.next();
                        id = -1;
                        System.out.println("The input is not valid, please enter a number\n");
                        continue;
                    }
                    if(id < 0){
                        id = -1;
                        System.out.println("The input is not valid, please enter a non-negative number\n");
                    }
                }
                System.out.println("Please enter the size of the tutorial session");
                int size = 0;
                while(size == 0){
                    try{
                        size = sc.nextInt();
                    }
                    catch (Exception e){
                        sc.next();
                        size = 0;
                        System.out.println("The input is not valid, please enter a number\n");
                        continue;
                    }
                    if(size <= 0){
                        size = 0;
                        System.out.println("The input is not valid, please enter a positive number\n");
                    }
                }
                Tutorial current = new Tutorial(id, size);
                System.out.println("A tutorial session with ID " + id + " and size " + size + " has been created\n");
                tutorialList.add(current);
            }
            System.out.println("All " + number + " tutorial sessions have been created\n");
        }
        ArrayList<Lab> labList = new ArrayList<>();
        choice = 0;
        while(choice == 0){
            System.out.println("Does this course contain any lab session? (enter 1 or 2)");
            System.out.println("1. Yes");
            System.out.println("2. No");
            try{
                choice = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2\n");
                continue;
            }
            if(choice != 1 && choice != 2){
                choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2\n");
            }
        }
        if(choice == 1){
            System.out.println("Please enter the number of lab sessions");
            int number = 0;
            while(number == 0){
                try{
                    number = sc.nextInt();
                }
                catch (Exception e){
                    sc.next();
                    number = 0;
                    System.out.println("The input is not valid, please enter a number\n");
                    continue;
                }
                if(number <= 0){
                    number = 0;
                    System.out.println("The input is not valid, please enter a positive number\n");
                }
            }
            System.out.println("Please proceed with entring the information for the " + number + " lab sessions\n");
            for(int i = 0; i < number; i++){
                System.out.println("Please enter the ID of the lab session");
                int id = -1;
                while(id == -1){
                    try{
                        id = sc.nextInt();
                    }
                    catch (Exception e){
                        sc.next();
                        id = -1;
                        System.out.println("The input is not valid, please enter a number\n");
                        continue;
                    }
                    if(id < 0){
                        id = -1;
                        System.out.println("The input is not valid, please enter a non-negative number\n");
                    }
                }
                System.out.println("Please enter the size of the lab session");
                int size = 0;
                while(size == 0){
                    try{
                        size = sc.nextInt();
                    }
                    catch (Exception e){
                        sc.next();
                        size = 0;
                        System.out.println("The input is not valid, please enter a number\n");
                        continue;
                    }
                    if(size <= 0){
                        size = 0;
                        System.out.println("The input is not valid, please enter a positive number\n");
                    }
                }
                Lab current = new Lab(id, size);
                System.out.println("A lab session with ID " + id + " and size " + size + " has been created\n");
                labList.add(current);
            }
            System.out.println("All " + number + " lab sessions have been created\n");
        }
        Faculty currentFaculty = facultyList.get(allfaculties.get(ID));
        courseList.add(new Course(name, currentFaculty, tutorialList, labList));
        allCourseCodes.put(name, courseCount);
        courseCount++;
        System.out.println("You've successfully added the course " + name + " with coordinator " + currentFaculty.getName() + " to the SCRAME System!");
        System.out.println();
        System.out.println("Below is the list of all courses, there are altogether " + courseList.size() + " courses in the system.");
        int count = 1;
        for(Course c:courseList){
            System.out.println("(" + count + ") Course Code: " + c.getName() + "  |  Course Coordinator: " + c.getFaculty());
            count++;
        }
        System.out.println();
    }

    private static void addStudentToCourse(){
        System.out.println("Please enter the Matriculation Number of the student");
        String matricNo = sc.next();
        if(!allMatricNos.containsKey(matricNo)){
            System.out.println("There's no student in the system with Matric Number " + matricNo + ", please check the correctness of the input\n");
            return;
        }
        Student currentStudent = studentList.get(allMatricNos.get(matricNo));
        System.out.println("Please enter the Course Code of the course you want to register for " + currentStudent.getName());
        String courseCode = sc.next();
        if(!allCourseCodes.containsKey(courseCode)){
            System.out.println("The course " + courseCode + " doesn't exist in the system, please check the correctness of the input\n");
            return;
        }
        if(currentStudent.checkRegistered(courseCode)){
            System.out.println(currentStudent.getName() + " has already been registered with the course " + courseCode + ", there's no need to add again");
            return;
        }
        Course currentCourse = courseList.get(allCourseCodes.get(courseCode));
        if(currentCourse.isFull()) {
            System.out.println("The course " + courseCode + " has no vacancy left, please try another course");
            return;
        }

    }

    private static void checkVacancy(){

    }

    private static void printStudentList(){

    }

    private static void enterAssessmentWeightage(){

    }

    private static void enterCourseWorkMark(){

    }

    private static void enterExamMark(){

    }

    private static void printCourseStatistic(){

    }

    private static void printStudentTranscript(){

    }
}
