package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class UserAccountUI {

    //arrayList containing the instance of UserAccount
    static ArrayList<UserAccount> person = new ArrayList<>();

    public static void main(String[] args) {

        //Classes
        UserAccount useraccount = new UserAccount();
        Scanner kbInput = new Scanner(System.in);

        //Variables
        int userInput;
        int ID = 0;
        String username;
        String password;
        boolean isDone = false; // Checks status of program

        while(!isDone){
            System.out.println("Select 1 to create a new account, 2 for returning users, 3 to exit");
            userInput = kbInput.nextInt();
            if(userInput == 1){
                do{
                    System.out.println("Please create a new account below." + "\n");
                    System.out.println("Please enter an username that is not taken");
                    username = kbInput.next();
                    System.out.println("\n" + "Please enter a password that is not taken");
                    password = kbInput.next();
                    useraccount.getUsers(username, password);
                    if(useraccount.checkNewUserAccount()){
                        System.out.println("Sorry that username or password was taken. Try again.");
                    }
                    }while(useraccount.checkNewUserAccount());

                    UserAccount Person = new UserAccount(username, password, ID);
                    person.add(Person);
                    ID++;
                    while(!isDone){
                        System.out.println("\n" + "Hello, " + username.substring(0,1).toUpperCase() + username.substring(1));
                        System.out.println("Select 1 to deposit, 2 to withdraw, 3 to check balance, 4 to check transaction history, 5 to exit");
                        userInput = kbInput.nextInt();
                        switch (userInput){
                            case 1:
                                useraccount.depositMethod();
                                break;

                            case 2:
                                useraccount.withdrawMethod();
                                break;

                            case 3:
                                useraccount.checkBalance();
                                break;

                            case 4:
                                System.out.println("\n" + username.substring(0,1).toUpperCase() + username.substring(1) + ", ");
                                useraccount.checkUserTransactionHistory();
                                break;

                            default:
                                System.out.println("\n" + "Thank you for banking with us today" + "\n" + "\n");
                                isDone = true;
                                break;
                        }
                    }
                    isDone = false; //let's the program continue

            }else if(userInput == 2){
                System.out.println("Please enter your username");
                username = kbInput.next();
                System.out.println("\n" + "Please enter your password");
                password = kbInput.next();
                useraccount.getUsers(username, password);

                if(useraccount.checkUserAccount()){
                    System.out.println("\n" + "Welcome back, " + username.substring(0,1).toUpperCase() + username.substring(1));
                    while(!isDone){
                        System.out.println("\n" + "Select 1 to deposit, 2 to withdraw, 3 to check balance, 4 to check transaction history, 5 to quit");
                        userInput = kbInput.nextInt();
                        switch (userInput){
                            case 1:
                                useraccount.depositMethod();
                                break;

                            case 2:
                                useraccount.withdrawMethod();
                                break;

                            case 3:
                                useraccount.checkBalance();
                                break;

                            case 4:
                                System.out.println("\n" + username.substring(0,1).toUpperCase() + username.substring(1) + ", ");
                                useraccount.checkUserTransactionHistory();
                                break;

                            default:
                                System.out.println("\n" + "Thank you for banking with us today" + "\n" + "\n");
                                isDone = true;
                                break;
                        }
                    }
                    isDone = false;
                }else{
                    System.out.println("One of the information above was entered incorrectly. Please try again" + "\n" + "\n");
                }
            }else {
                System.out.println("Thank you for banking with us today.");
                isDone = true;
            }
        }
    }
}

