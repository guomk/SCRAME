import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SCRAMEApp {
    private static Scanner sc;
    private static ArrayList<Course> courseList;
    private static ArrayList<Student> studentList;
    private static HashSet<String> allMatricNos;
    public static void main(String[] args) throws IOException{
        sc = new Scanner(System.in);
        courseList = new ArrayList<>();
        studentList = new ArrayList<>();
        allMatricNos = new HashSet<>();
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
            catch (Exception){
                System.out.println("The input is not valid, please enter a number between 1 and 11");
                continue;
            }
            if(choice < 1 || choice > 11){
                System.out.println("The input is not valid, please enter a number between 1 and 11");
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
        if(allMatricNos.contains(matricNo)){
            System.out.println("This Matriculation Number already exists in the system records, you can proceed with other operations");
            return;
        }
        System.out.println("Please enter the school of " + name);
        String school = sc.next();
        int gender = 0;
        while(gender == 0){
            System.out.print("Please enter the gender of" + name);
            System.out.println(" (enter a number between 1 and 3)");
            System.out.println("1. Male");
            System.out.println("2. Female");
            System.out.println("3. Genderqueer");
            try{
                gender = sc.nextInt();
            }
            catch (Exception){
                gender = 0;
                System.out.println("The input is not valid, please enter a number between 1 and 3");
                continue;
            }
            if(gender < 1 || gender > 3){
                gender = 0;
                System.out.println("The input is not valid, please enter a number between 1 and 3");
            }
        }
        studentList.add(new Student(name, matricNo, school, gender));
        allMatricNos.add(matricNo);
        System.out.println("You've successfully added " + name + " with Matric No. " + matricNo + " to the SCRAME System!");
        System.out.println();
        System.out.println("Below is the list of all current students, there are " + studentList.size() + " students in the system.");
        int count = 1;
        for(Student:studentList){
            System.out.println("(" + count + ") Name: " + name + "  |  Matric Number: " + matricNo);
            count++;
        }
    }
    private static void addCourse(){

    }
    private static void addStudentToCourse(){

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
    private static void printStudentTranscript(Student){

    }
}
