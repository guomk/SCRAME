import java.io.*;
import java.util.*;
import java.util.zip.CheckedOutputStream;
import java.io.*;

public class SCRAMEApp {

    private static Scanner sc;
    private static ArrayList<Course> courseList;
    private static int studentCount;
    private static ArrayList<Student> studentList;
    private static int courseCount;
    private static HashMap<String, Integer> allMatricNos;
    private static HashMap<String, Integer> allCourseCodes;
    private static ArrayList<Faculty> facultyList;
    private static HashMap<String, Integer>  allfaculties;

    public static void main(String[] args) throws IOException{
        facultyList = new ArrayList<>();
        allfaculties = new HashMap<>();
        File faculties = new File("./FacultyList");
        BufferedReader br = new BufferedReader(new FileReader(faculties));
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        br.read();
        for(int i = 0; i < n; i++){
            String id = br.readLine();
            String name = br.readLine();
            String title = br.readLine();
            String description = br.readLine();
            allfaculties.put(id, i);
            facultyList.add(new Faculty(name, title, description, id));
            br.readLine();
        }
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
        sc.nextLine();
        String name = sc.nextLine();
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
        if(allCourseCodes.containsKey(name)){
            System.out.println("This Course Code already exists in the system records, you can proceed with other operations\n");
            return;
        }
        System.out.println("Please enter the ID of the course coordinator for " + name);
        String ID = sc.next();
        while(!allfaculties.containsKey(ID)){
            System.out.println("There's no faculty in the system with ID " + ID + ", please check the correctness of the input and enter again\n");
            ID = sc.next();
        }
        System.out.println("Please enter the size of the lecture of this course");
        int lectureSize = 0;
        int lectureid = 0;
        while(lectureSize == 0){
            try{
                lectureSize = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                lectureSize = 0;
                System.out.println("The input is not valid, please enter a number\n");
                continue;
            }
            if(lectureSize <= 0){
                lectureSize = 0;
                System.out.println("The input is not valid, please enter a positive number\n");
            }
        }
        Lecture lecture = new Lecture(lectureid,lectureSize);
        ArrayList<Tutorial> tutorialList = new ArrayList<>();
        HashMap<Integer, Integer> tutorialDic = new HashMap<>();
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
            System.out.println("Please proceed with entering the information for the " + number + " tutorial sessions\n");
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
                        continue;
                    }
                    if(tutorialDic.containsKey(id)){
                        id = -1;
                        System.out.println("This tutorial ID has existed for the course " + name + ", please enter a other ID");
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
                tutorialDic.put(id, i);
            }
            System.out.println("All " + number + " tutorial sessions have been created\n");
        }
        ArrayList<Lab> labList = new ArrayList<>();
        HashMap<Integer, Integer> labDic = new HashMap<>();
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
            System.out.println("Please proceed with entering the information for the " + number + " lab sessions\n");
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
                    if(labDic.containsKey(id)){
                        id = -1;
                        System.out.println("This lab ID has existed for the course " + name + ", please enter a other ID");
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
                labDic.put(id, i);
            }
            System.out.println("All " + number + " lab sessions have been created\n");
        }
        Faculty currentFaculty = facultyList.get(allfaculties.get(ID));
        courseList.add(new Course(name, currentFaculty, lecture, tutorialList, labList, tutorialDic, labDic));
        allCourseCodes.put(name, courseCount);
        courseCount++;
        System.out.println("You've successfully added the course " + name + " with coordinator " + currentFaculty.getName() + " to the SCRAME System!");
        System.out.println();
        System.out.println("Below is the list of all courses, there are altogether " + courseList.size() + " courses in the system.");
        int count = 1;
        for(Course c:courseList){
            System.out.println("(" + count + ") Course Code: " + c.getName() + "  |  Course Coordinator: " + c.getFaculty().getName());
            count++;
        }
        System.out.println();
    }

    private static void addStudentToCourse(){
        System.out.println("Please enter the Matriculation Number of the student");
        String matricNo = sc.next();
        if (!allMatricNos.containsKey(matricNo)){
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
            System.out.println("The student " + currentStudent.getName() + " has already been registered with the course " + courseCode + ".");
            return;
        }
        Course currentCourse = courseList.get(allCourseCodes.get(courseCode));
        if (currentCourse.isFull()){
            System.out.println("The course " + courseCode + " has no vacancy left, please try another course");
            return;
        }
        else{
            Record currentRecord = new Record(currentStudent, currentCourse);
            System.out.println("Here's the detail of the course " + courseCode + ": ");
            if(currentCourse.getTutorialNumber() == 0)
                System.out.println("This course only has Lecture.");
            else if(currentCourse.getLabNumber() == 0)
                System.out.print("This course only has Lecture and Tutorial.");
            else
                System.out.print("This course has Lecture, Tutorial and Lab.");
            System.out.println("Lecture: vacancy = " + currentCourse.getLecture().getVacancy());
            currentCourse.getLecture().registered();
            if (currentCourse.getTutorialNumber() != 0){
                System.out.println("Enter the id of the tutorial group you want to register (only select a tutorial group that has vacancy): ");
                for (int i = 1; i <= currentCourse.getTutorialNumber(); i++){
                    System.out.println("Tutorial group " + currentCourse.getTutorial().get(i-1).getID() + " vacancy: " + currentCourse.getTutorial().get(i-1).getVacancy() + " / " + currentCourse.getTutorial().get(i - 1).getSize());
                }
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
                    if(currentCourse.checkTutorial(id) == -1){
                        id = -1;
                        System.out.println("The entered id doesn't exist, please choose an id from the above list");
                    }
                    else if(currentCourse.getTutorial().get(currentCourse.checkTutorial(id)).isFull()){
                        id = -1;
                        System.out.println("The selected tutorial Group is full, please only select a tutorial group that has vacancy");
                    }
                }
                System.out.println("The student " + currentStudent.getName() + " has been registered with the tutorial group " + id);
                currentCourse.getTutorial().get(currentCourse.checkTutorial(id)).registered();
                currentRecord.addSession(currentCourse.getTutorial().get(currentCourse.checkTutorial(id)));
                if(currentCourse.getLabNumber() != 0){
                    System.out.println("Enter the id of the lab group you want to register (only select a lab group that has vacancy): ");
                    for (int i = 1; i <= currentCourse.getLabNumber(); i++){
                        System.out.println("Tutorial group " + currentCourse.getLab().get(i-1).getID() + " vacancy: " + currentCourse.getLab().get(i-1).getVacancy() + " / " + currentCourse.getLab().get(i - 1).getSize());
                    }
                    id = -1;
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
                        if(currentCourse.checkLab(id) == -1){
                            id = -1;
                            System.out.println("The entered id doesn't exist, please choose an id from the above list");
                        }
                        else if(currentCourse.getLab().get(currentCourse.checkLab(id)).isFull()){
                            id = -1;
                            System.out.println("The selected lab Group is full, please only select a lab group that has vacancy");
                        }
                    }
                    System.out.println("The student " + currentStudent.getName() + " has been registered with the lab group " + id);
                    currentCourse.getLab().get(currentCourse.checkLab(id)).registered();
                    currentRecord.addSession(currentCourse.getLab().get(currentCourse.checkLab(id)));
                }
            }
            System.out.println("Congratulation, the student " + currentStudent.getName() + " has been successfully registered with the course " + currentCourse.getName() + "(including lab & tutorial).");
        }

    }

    private static void checkVacancy(){
        System.out.println("Please enter the Course Code you want to check for vacancy");
        String courseCode = sc.next();
        if (!allCourseCodes.containsKey(courseCode)){
            System.out.println("The course " + courseCode + " doesn't exist in the system, please check the correctness of the input\n");
            return;
        }
        Course currentCourse = courseList.get(allCourseCodes.get(courseCode));
        System.out.println("Lecture vacancy = " + currentCourse.getLecture().getVacancy());
        System.out.println("This course has " + currentCourse.getTutorialNumber() + " tutorials and " + currentCourse.getLabNumber() + " labs.");
        for (int i = 1; i <= currentCourse.getTutorialNumber(); i++){
            System.out.println("Tuorial group " + i + ": id = " + currentCourse.getTutorial().get(i-1).getID() + " vacancy = " + currentCourse.getTutorial().get(i-1).getVacancy());
        }
        for (int j = 1; j <= currentCourse.getLabNumber(); j++){
            System.out.println("Lab group " + j + ": id = " + currentCourse.getLab().get(j-1).getID() + " vacancy = " + currentCourse.getLab().get(j-1).getVacancy());
        }
        return; 
    }


    private static void printStudentList(){
    	String courseCode;
    	int choice = 0;
    	System.out.println("Please enter the couse ID of which you want to print the student list:");
    	courseCode = sc.next();
    	while(true){
    	if(!allMatricNos.containsKey(courseCode))
            System.out.println("This Course Code does not exist in the system records, you can proceed with other operations\n");
        else
        	break;
        }
        while(choice == 0){
        System.out.println("Please chhoose the sequence do you want to print the studnet lise:");
        System.out.println("1.By lecture");
        System.out.println("2.By tutorial");
        System.out.println("3.By laboratory");
        try{
                choice = sc.nextInt();
            }
            catch (Exception e){
                sc.next();
                choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2 or 3\n");
                continue;
            }
        if(choice != 1 && choice !=2 && choice != 3){
        	    choice = 0;
                System.out.println("The input is not valid, please enter 1 or 2 or 3\n");
                continue;
        }
    }
        Course currentCourse = courseList.get(allCourseCodes.get(courseCode));
    		if(currentCourse.getRecordList().size()==0){
    			System.out.println("There is no student registered to this course.");
    			return;}
        if(choice ==1){
    	    for(Student s:studentList){
    	    	System.out.println("Student Name  "+" MatricNo  "+ " School "+ " Gender");
    		    if(s.checkRegistered(courseCode)){
    		    	System.out.println(s.getName() + "  " + s.getMatricNo() + "  " + s.getSchool() + "  " + s.getGender());
    		    }
    	
    		}
    	}
    	else if(choice ==2){
    		if(currentCourse.getTutorialNumber()==0){
    			System.out.println("There is no tutorial for this course.");
    			return;
    		}
    		else{
    			System.out.println("The tutorial list for this course:");
    			for(Tutorial t: currentCourse.getTutorial()){
    				System.out.println(t.getID());
    			}
    			System.out.println("Choose the tutorial you want to print");
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
                    if(currentCourse.checkTutorial(id) == -1){
                    	id = -1;
                        System.out.println("The tutorial sesson does not exsit, please enter a valid tutorial session.\n");
                        continue;

    			}
                }
                for(Student s:studentList){
    	    	System.out.println("Student Name  "+" MatricNo  "+ " School "+ " Gender");
    		    if(s.checkRegistered(courseCode)){
    		    	System.out.println(s.getName() + "  " + s.getMatricNo() + "  " + s.getSchool() + "  " + s.getGender());
    		    }
    		    }

    		}
    		}


    }


    private static void enterAssessmentWeightage(){
        double exam_weightage = 0;
        int numOfCAs = -1;
        int input;
        String name;
        double percent = 0;
        CA ca;
        Course course;
        Component component;


        course = getCourse();

        System.out.println("Please enter the weightage of the exam (0-100)");
        while (exam_weightage == 0) {
            try {
                input = sc.nextInt();
                exam_weightage = (double)input / 100;
            }
            catch (Exception e) {
                sc.next();
                exam_weightage = 0;
                System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
                continue;
            }
            if (input > 100 || input < 0) {
                exam_weightage = 0;
                System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
            }
        }

        System.out.println("Please enter the number of CAs");
        while (numOfCAs == -1) {
            try {
                numOfCAs = sc.nextInt();
            }
            catch (Exception e) {
                sc.next();
                numOfCAs = -1;
                System.out.println("The input is not valid, please enter an positive integer");
                continue;
            }
        }
        component = new Component(exam_weightage, numOfCAs);
        ca = component.getCa();
        for (int i = 0; i < numOfCAs; i++) {
            percent = 0;
            System.out.println("Enter name for CA(" + (i+1) + ")");
            name = sc.next();
            ca.setName(name, i);
            System.out.println("Enter weightage of " + name + " (consider all CAs as 100)");
            while (percent == 0) {
                try {
                    percent = sc.nextInt();
                    percent /= 100;
                }
                catch (Exception e) {
                    sc.next();
                    percent = 0;
                    System.out.println("The input is not valid, please enter a float number\n");
                    continue;
                }
                if (percent > 1 || percent < 0) {
                     percent = 0;
                     System.out.println("The input is not valid, please enter a float number between 0 and 1\n");
                }
            }
            ca.setWeightage(percent, i);
        }
        course.setComponent(component);

        component.printComponents();
    }

    private static void enterCourseWorkMark(){
        Course course;
        CA ca;

//      For production
        course = getCourse();
        ca = course.getComponent().getCa();
//---------------------------------------------------------------end of production section

        // For testing purpose
//        ca = new CA(2, 0.4);
//        ca.setName("CA1", 0);
//        ca.setName("CA2", 1);
//        ca.setWeightage(0.4, 0);
//        ca.setWeightage(0.6, 1);
        // end of testing section

        ca.setMarks();
        ca.printMarks();
    }

    private static void enterExamMark(){
        Course course = getCourse();
        Component component = course.getComponent();
        int mark = 0;
        System.out.println("Enter exam result for " + course.getName());
        while (mark == 0) {
            try {
                mark = sc.nextInt();
            }
            catch (Exception e) {
                sc.next();
                mark = 0;
                System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
                continue;
            }
            if (mark > 100 || mark < 0) {
                mark = 0;
                System.out.println("The input is not valid, please enter an integer between 0 and 100\n");
            }
        }

    }

    private static void printCourseStatistic(){

    }

    private static void printStudentTranscript(){
        Student student = getStudent();
        student.printTranscript();
    }

    private static Course getCourse() {
        System.out.println("Enter the course code you want to edit");
        String courseCode;
        int idx;
        Course course;
        while (true) {
            courseCode = sc.next();
            try {
                idx = allCourseCodes.get(courseCode);
            }
            catch (Exception e) {
                System.out.println("The course you are looking for is not valid");
                continue;
            }
            break;
        }
        course = courseList.get(idx);
        return course;
    }

    private static Student getStudent() {
        System.out.println("Enter the matric number of the student you want to find");
        String matricNo;
        int idx;
        Student student;
        while (true) {
            matricNo = sc.next();
            try {
                idx = allMatricNos.get(matricNo);
            }
            catch (Exception e) {
                System.out.println("The student you are looking for is not present");
                continue;
            }
            break;
        }
        student = studentList.get(idx);
        return student;
    }


    private static void pressAnyKeyToContinue()
    {
        System.out.println("Press Enter key to continue...");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }

    private static void saveObject(Object o) {
        String outPath = "";
        try {
            FileOutputStream fileOut = new FileOutputStream(outPath);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(o);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in " + outPath);
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    private static Object readObject(Object o) {
        String inPath = "";
        try {
            FileInputStream fileIn = new FileInputStream(inPath);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Object object = in.readObject();
            in.close();
            fileIn.close();
            return object;
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
    }
}
