package sms;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Printer {

    public static void printAllStudents(ResultSet result) {
        try {
            
            while (result.next()) {
                System.out.println(
                        "Studend's Id: " + result.getString(1)
                        + ", First Name: " + result.getString(2)
                        + ", Last Name: " + result.getString(3)
                        + ", Date of birth: " + result.getString(4)
                        + ", Tuition fees: " + result.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllTrainers(ResultSet result) {
        try {
            
            while (result.next()) {
                System.out.println(
                        "Trainer's Id: " + result.getString(1)
                        + ", First Name: " + result.getString(2)
                        + ", Last Name: " + result.getString(3)
                        + ", Subject: " + result.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllAssignments(ResultSet result) {
        try {
            
            while (result.next()) {
                System.out.println(
                        "Assignment's Id: " + result.getString(1)
                        + ", Title: " + result.getString(2)
                        + ", Description: " + result.getString(3)
                        + ", Submition Date: " + result.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void printAllCourses(ResultSet result) {
        try {
            
            while (result.next()) {
                System.out.println(
                        "Course's Id: " + result.getString(1)
                        + ", Title: " + result.getString(2)
                        + ", Stream: " + result.getString(3)
                        + ", Type: " + result.getString(4)
                        + ", Start date: " + result.getString(5)
                        + ", End date: " + result.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * a method that prints a menu with all options
     */
     public static void printOptions() {
        System.out.println("I want to:\n"
                + "1. Retrieve data for all the students\n"
                + "2. Retrieve data for all the trainers\n"
                + "3. Retrieve data for all the assignments\n"
                + "4. Retrieve data for all the courses\n"
                + "5. Retrieve data for all the students per course\n"
                + "6. Retrieve data for all the trainers per course\n"
                + "7. Retrieve data for all the assignments per course\n"
                + "8. Retrieve data for all the assignments per course per student\n"
                + "9. Retrieve data for all the students that belong to more than one courses\n"
                + "10. Insert a student\n"
                + "11. Insert a trainer\n"
                + "12. Insert an assignment\n"
                + "13. Insert a course\n"
                + "14. Insert students per course\n"
                + "15. Insert trainers per course\n"
                + "16. Insert assignments per student per course\n"
                + "17. Exit the system\n");
    }
     
     public static void printMsg(String message){
         System.out.println(message);
     }
     
     
     /**
     * This method prints the logo of the system, a welcome message and an
     * instruction of how the user can navigate into the system's menu
     */
    public static void printLogo() {
        System.out.println(" _____      _            _          _____      _                 _ \n"
                + "|  __ \\    (_)          | |        / ____|    | |               | |\n"
                + "| |__) | __ ___   ____ _| |_ ___  | (___   ___| |__   ___   ___ | |\n"
                + "|  ___/ '__| \\ \\ / / _` | __/ _ \\  \\___ \\ / __| '_ \\ / _ \\ / _ \\| |\n"
                + "| |   | |  | |\\ V / (_| | ||  __/  ____) | (__| | | | (_) | (_) | |\n"
                + "|_|   |_|  |_| \\_/ \\__,_|\\__\\___| |_____/ \\___|_| |_|\\___/ \\___/|_|\n"
                + "\n"
                + "Welcome to the Private School  Management System!!!\n"
                + "\n"
                + "Please follow the instructions on each screen to navigate throw the system.\n"
                + "Enter the number of your choice for every action you want to execute.\n");
    }
}
