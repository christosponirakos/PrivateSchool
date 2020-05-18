package sms; //aka School Management System

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {

    public static void main(String[] args) {

        Database database = new Database(); //Connect to the database

        Printer.printLogo();//printing the logo of the system

        optionsHandling();//basic method for handling all the user actions

        try {            //closing the connection
            database.getResult().close();
            database.getStatement().close();
            database.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method controls actions, where the user chooses what to do. Numbers
     * 1 -11. We use the method to give the ability to the user for repeatedly
     * navigating throw the menu, until she decides to exit the system.
     *
     */
    public static void optionsHandling() {
        Database database = null;
        PreparedStatement pstmt = null;
        Scanner input = new Scanner(System.in); //Creating a scanner object for accepting entries from the user
        Printer.printOptions();
        try {
            byte options = input.nextByte(); //The first value that the user will enter after she sees the first menu

            switch (options) {
                case 1:
                    ResultSet result = database.getResults(Sql.allStudents); //Retrieves a list of all the students        
                    Printer.printAllStudents(result);// method for printing students data
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 2:
                    result = database.getResults(Sql.allTrainers);
                    Printer.printAllTrainers(result);// method for printing Trainers data
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 3:
                    result = database.getResults(Sql.allAssignments);
                    Printer.printAllAssignments(result);// method for printing Assignments data
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 4:
                    result = database.getResults(Sql.allCourses);
                    Printer.printAllCourses(result);// method for printing Courses data
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 5:
                    result = database.getResults(Sql.allCourses);
                    Printer.printMsg("\nPlease enter the course ID number from the below list, on which you want to see the enlisted students\n");
                    Printer.printAllCourses(result);
                    byte option1 = input.nextByte();
                    pstmt = database.getConnection().prepareStatement(Sql.allStudentsPerCourse);
                    pstmt.setInt(1, option1);
                    result = pstmt.executeQuery();
                    Printer.printAllStudents(result);
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 6:
                    result = database.getResults(Sql.allCourses);
                    Printer.printMsg("\nPlease enter the course ID number from the below list, on which you want to see the enlisted trainers\n");
                    Printer.printAllCourses(result);
                    byte option2 = input.nextByte();
                    pstmt = database.getConnection().prepareStatement(Sql.allTrainersPerCourse);
                    pstmt.setInt(1, option2);
                    result = pstmt.executeQuery();
                    Printer.printAllTrainers(result);
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 7:
                    result = database.getResults(Sql.allCourses);
                    Printer.printMsg("\nPlease enter the course ID number from the below list, on which you want to see the enlisted assignments\n");
                    Printer.printAllCourses(result);
                    byte option3 = input.nextByte();
                    pstmt = database.getConnection().prepareStatement(Sql.allAssignmentsPerCourse);
                    pstmt.setInt(1, option3);
                    result = pstmt.executeQuery();
                    Printer.printAllAssignments(result);
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 8:
                    result = database.getResults(Sql.allCourses);
                    Printer.printMsg("\nPlease enter the course ID number from the below list, on which you want to see the students\n");
                    Printer.printAllCourses(result);
                    byte option4 = input.nextByte();

                    Printer.printMsg("\nPlease enter the student ID number from the below list, on which you want to see the assignments\n");
                    pstmt = database.getConnection().prepareStatement(Sql.allStudentsPerCourse);
                    pstmt.setInt(1, option4);
                    result = pstmt.executeQuery();
                    Printer.printAllStudents(result);
                    byte option5 = input.nextByte();

                    pstmt = database.getConnection().prepareStatement(Sql.allAssignmentsPerCoursePerStudent);
                    pstmt.setInt(1, option4);
                    pstmt.setInt(2, option5);
                    result = pstmt.executeQuery();
                    Printer.printAllAssignments(result);
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 9:
                    result = database.getResults(Sql.allStudentsMoreThanOneCourses);
                    Printer.printAllStudents(result);
                    Printer.printMsg("\n*********End*********\n");
                    break;
                    
                case 10:
                    Printer.printMsg("Please enter the firstname of the student");
                    String firstname = input.next();
                    Printer.printMsg("Please enter the lasttname of the student");
                    String lastname = input.next();
                    Printer.printMsg("Please enter the date of birth of the student in that format yyyy-MM-dd. example: 2020-01-30");
                    String dateOfBirth = input.next();
                    Printer.printMsg("Please enter the tuition fees of the student");
                    String fees = input.next();
                    String sql = new StringBuilder()
                            .append("INSERT `students`(`firstname`, `lastname`, `dateofbirth`, `tuitionfees`) ")
                            .append("VALUES (?, ?, ?, ?);").toString();

                    PreparedStatement statement = database.getConnection().prepareStatement(sql);

                    statement.setString(1, firstname);
                    statement.setString(2, lastname);
                    statement.setString(3, dateOfBirth);
                    statement.setString(4, fees);
                    int rowsAffected = statement.executeUpdate();
                    Printer.printMsg("\n" + rowsAffected + " row(s) inserted\n");

                    break;

                case 11:
                    Printer.printMsg("Please enter the firstname of the trainer");
                    firstname = input.next();
                    Printer.printMsg("Please enter the lasttname of the trainer");
                    lastname = input.next();
                    Printer.printMsg("Please enter the subject of the trainer");
                    String subject = input.next();
                    sql = new StringBuilder()
                            .append("INSERT `trainers`(`firstname`, `lastname`, `subject`) ")
                            .append("VALUES (?, ?, ?);").toString();

                    PreparedStatement statement1 = database.getConnection().prepareStatement(sql);

                    statement1.setString(1, firstname);
                    statement1.setString(2, lastname);
                    statement1.setString(3, subject);

                    rowsAffected = statement1.executeUpdate();
                    Printer.printMsg("\n" + rowsAffected + " row(s) inserted\n");

                    break;

                case 12:

                    Printer.printMsg("Please enter the title of the assignment");
                    String title = input.next();
                    Printer.printMsg("Please enter the description of the assignment");
                    String description = input.next();
                    Printer.printMsg("Please enter the submision date of of the assignment in that format yyyy-MM-dd. example: 2020-01-30");
                    String subDate = input.next();
                    Printer.printMsg("Please enter the id of the course  that belongs to from the below list");
                    result = database.getResults(Sql.allCourses);
                    Printer.printAllCourses(result);
                    String courseId = input.next();
                    sql = new StringBuilder()
                            .append("INSERT `assignments`(`title`, `description`, `subdatetime`, `courseid`) ")
                            .append("VALUES (?, ?, ?, ?);").toString();

                    PreparedStatement statement2 = database.getConnection().prepareStatement(sql);

                    statement2.setString(1, title);
                    statement2.setString(2, description);
                    statement2.setString(3, subDate);
                    statement2.setString(4, courseId);
                    rowsAffected = statement2.executeUpdate();
                    Printer.printMsg("\n" + rowsAffected + " row(s) inserted\n");
                    break;
                    
                case 13:
                    Printer.printMsg("Please enter the title of the course");
                    String titleCourse = input.next();
                    Printer.printMsg("Please enter the stream of the course");
                    String stream = input.next();
                    Printer.printMsg("Please enter the type of the course");
                    String type = input.next();
                    Printer.printMsg("Please enter the start date of the course in that format yyyy-MM-dd. example: 2020-01-30");
                    String startDate = input.next();
                    Printer.printMsg("Please enter the end date of the course in that format yyyy-MM-dd. example: 2020-01-30");
                    String endDate = input.next();
                    sql = new StringBuilder()
                            .append("INSERT `courses`(`title`, `stream`, `type`, `start_date`, `end_date`) ")
                            .append("VALUES (?, ?, ?, ?, ?);").toString();

                    PreparedStatement statement3 = database.getConnection().prepareStatement(sql);

                    statement3.setString(1, titleCourse);
                    statement3.setString(2, stream);
                    statement3.setString(3, type);
                    statement3.setString(4, startDate);
                    statement3.setString(5, endDate);
                    rowsAffected = statement3.executeUpdate();
                    Printer.printMsg("\n" + rowsAffected + " row(s) inserted\n");
                    break;

                case 17:
                    System.exit(0);
                    break;
                    
                default:
                    Printer.printMsg("\nPlease select one of the choices presented in the menu. Number 1 - 11\n");
                    optionsHandling();
            }
            optionsHandling();
        } catch (Exception e) {
            Printer.printMsg("\nPlease select one of the choices presented in the menu. Number 1 - 11\n");
            optionsHandling();
        }
    }

    public static LocalDate parseStringDate(String inputDate) {
        //String  formatStrings = "y-M-d";//, "y/M/d", "M/y", "M/d/y", "M-d-y",};
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate parseDate = LocalDate.parse(inputDate, formatter);
        return parseDate;
    }

}
