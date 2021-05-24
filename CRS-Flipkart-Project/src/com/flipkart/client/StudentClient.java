package com.flipkart.client;

import java.util.*;
import java.util.Scanner;

import com.flipkart.bean.Course;


/**
 *
 * @author anshuman
 *  The class displays the menu for student client
 *
 */
public class StudentClient {

    Scanner sc = new Scanner(System.in);

    private boolean is_registered;

    /**
     * Method to generate Student Menu for course registration, addition, removal and fee payment
     * @param studentId student id
     */
    public void create_menu(int studentId)
    {

        is_registered = getRegistrationStatus(studentId);
        while (loggedin)
        {
            System.out.println("*****************************");
            System.out.println("**********Student Menu*********");
            System.out.println("*****************************");
            System.out.println("1. Course Registration");
            System.out.println("2. Add Course");
            System.out.println("3. Drop Course");
            System.out.println("4. View Course");
            System.out.println("5. View Registered Courses");
            System.out.println("6. View grade card");
            System.out.println("7. Make Payment");
            System.out.println("8. Logout");
            System.out.println("*****************************");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    registerCourses(studentId);
                    break;

                case 2:
                    addCourse(studentId);
                    break;

                case 3:

                    dropCourse(studentId);
                    break;

                case 4:
                    viewCourse(studentId);
                    break;

                case 5:
                    viewRegisteredCourse(studentId);
                    break;

                case 6:
                    viewGradeCard(studentId);
                    break;

                case 7:
                    make_payment(studentId);
                    break;

                case 8:
                    loggedin = false;
                    return;

                default:
                    System.out.println("***** Wrong Choice *****");
            }
        }
    }


    /**
     * Select course for registration
     * @param studentId
     */
    private void registerCourses(int studentId)
    {
        //TODO
    }

    /**
     * Add course for registration
     * @param studentId
     */
    private void addCourse(int studentId)
    {
        //TODO
    }

    /**
     * Method to check if student is already registered
     * @param studentId
     * @return Registration Status
     */
    private boolean getRegistrationStatus(int studentId)
    {
        //TODO
    }

    /**
     * Drop Course
     * @param studentId
     */
    private void dropCourse(int studentId)
    {
        //TODO
    }

    /**
     * View all available Courses
     * @param studentId
     * @return List of available Courses
     */
    private List<Course> viewCourse(int studentId)
    {
        //TODO
    }

    /**
     * View Registered Courses
     * @param studentId
     * @return List of Registered Courses
     */
    private List<Course> viewRegisteredCourse(int studentId)
    {
       //TODO
    }

    /**
     * View grade card for particular student
     * @param studentId
     */
    private void viewGradeCard(int studentId)
    {
        //TODO
    }

    /**
     * Make Payment for selected courses. Student is provided with an option to pay the fees and select the mode of payment.
     * @param studentId
     */
    private void make_payment(int studentId)
    {
        //TODO
    }




}