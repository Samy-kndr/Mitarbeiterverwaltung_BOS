import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        int conf1 = 0;
        User user = new User();

        Object[] loginRegisterChoice = {"Log In", "Register"};

        Object choice = JOptionPane.showInputDialog( // testing the choice between login and register -MF
                null,
                "What do you want to do?",
                "HOME SCREEN",
                JOptionPane.INFORMATION_MESSAGE,
                null,
                loginRegisterChoice,
                loginRegisterChoice[0]
        );

        System.out.println("choice: " + choice);


        if(choice == "Log In"){
            // Logging in with name -MF
            String userName = JOptionPane.showInputDialog(
                    null,
                    "Please enter your name",
                    "LOGIN",
                    JOptionPane.INFORMATION_MESSAGE
            );

            user.setName(userName);

            if(checkUserAvailability(userName)){
                // true == profile does not exist
                JOptionPane.showMessageDialog(
                        null,
                        "Sorry, that profile does not exist yet. \n" +
                                "Please try registering",
                        "profile does not exist",
                        JOptionPane.INFORMATION_MESSAGE
                );

                System.exit(0);

            }else{

                user = loadUserFromJson(userName);

            }

        }else if(choice == "Register") {

            do{

                String userName = JOptionPane.showInputDialog(
                        null,
                        "Please enter your name",
                        "LOGIN",
                        JOptionPane.INFORMATION_MESSAGE
                );

                user.setName(userName);

                if (checkUserAvailability(user.getName())) {

                    // Confirmation - SK
                    String userconf = JOptionPane.showInputDialog(
                            null,
                            "Please enter your name again",
                            "Confirmation",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    System.out.println(userconf);

                    if (Objects.equals(userName, userconf)) {
                        saveUserToJson(user);
                        conf1 = 1;
                    } else {
                        JOptionPane.showMessageDialog(
                                null,
                                "Names don´t match \n" +
                                        "Plese try again",
                                "Confirmation Fail",
                                JOptionPane.INFORMATION_MESSAGE
                        );
                    }


                } else {
                    JOptionPane.showMessageDialog(
                            null,
                            "Sorry, a profile with that name already exists. \n" +
                                    "Please try logging in.",
                            "profile already exists",
                            JOptionPane.INFORMATION_MESSAGE
                    );

                    System.exit(0);
                }

            }while(conf1 != 1);

        }else{
            // selected "Cancel"-option -MF
            JOptionPane.showInternalMessageDialog(
                    null,
                    "OK, Goodbye then!",
                    "bye bye",
                    JOptionPane.INFORMATION_MESSAGE
            );

            System.exit(0);
        }

        if(user.getName() == null){
            System.out.println("cancelled...");
            System.exit(0);

        }else{
            System.out.println("userName = " + user.getName());

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Welcome, " + user.getName(),
                    "WELCOME",
                    JOptionPane.INFORMATION_MESSAGE
            );

        }

        // asking user to either clock in or clock out
        // -> "Clock In" --> saved current time in the user json
        // -> "Clock Out" --> calculates difference between current time and clock-in time and shows calculated "worktime"
        // -MF
        Object[] userOptions = { "Clock In", "Clock Out"};

        Object selectedOption =
                JOptionPane.showInputDialog(
                        null,
                        "What do you want to do?",
                        "Options",
                        JOptionPane.INFORMATION_MESSAGE,
                        null, userOptions, userOptions[0]
                );

        if(selectedOption == "Clock In"){ //clocking in -MF

            user.setClockInTime(System.currentTimeMillis());

            System.out.println("user ClockInTime: " + user.getClockInTime());

            long hours = user.getClockInTime() / 3600000;

            System.out.println("time in hours: " + hours);

            saveUserToJson(user);

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Thank you. You have successfully clocked in. \n" +
                            "Please don't forget to clock out before leaving work!",
                    "clocked in successfully",
                    JOptionPane.INFORMATION_MESSAGE);

        }else if (selectedOption == "Clock Out"){ // clocking out -MF

            user.setClockOutTime(System.currentTimeMillis());

            long inTime = user.getClockInTime() / 3600000;
            long outTime = user.getClockOutTime() / 3600000;

            System.out.println("user ClockInTime: " + inTime +
                    "\n user ClockOutTime: " + outTime);

            long workTimeDifference = outTime - inTime;

            System.out.println("user working hours: " + workTimeDifference);

            JOptionPane.showInternalMessageDialog(
                    null,
                    "Thank you. You have successfully clocked out. \n" +
                            "You have worked " + workTimeDifference + " hours today!",
                    "clocked out successfully", JOptionPane.INFORMATION_MESSAGE);

            user.setClockInTime(0);
            user.setClockOutTime(0);
            user.setWorkedHoursTotal(user.getWorkedHoursTotal() + workTimeDifference);

            saveUserToJson(user);

        }else{
            System.out.println("cancelled...");
        }
        System.exit(0);


    }

    // saves given User Object to a .json file that can be loaded again later
    // -MF
    public static void saveUserToJson(User userToSave){

        String userName = userToSave.getName();
        System.out.println("Saving Object to " + userName + ".json...");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonToSave = gson.toJson(userToSave);

        try{

            PrintWriter writer = new PrintWriter(userName + ".json", StandardCharsets.UTF_8);
            writer.println(jsonToSave);
            writer.close();

        }catch(Exception e) {

            e.printStackTrace();

        }

        System.out.println(userName + ".json successfully saved!");

    }

    // loads user profile from json file.
    // returns null, if the file is not found.
    // -MF
    public static User loadUserFromJson(String userNameToLoad){
        StringBuilder jsonToLoad = new StringBuilder();
        User userToLoad = new User();
        Gson gson = new Gson();

        try{

            File fileToRead = new File(userNameToLoad + ".json");
            Scanner reader = new Scanner(fileToRead);

            while(reader.hasNextLine()){
                jsonToLoad.append(reader.nextLine());
            }

            userToLoad = gson.fromJson(jsonToLoad.toString(), User.class);

        }catch(FileNotFoundException e){

            System.out.println(userNameToLoad + ".json was not found...");
            e.printStackTrace();

            return null;

        }

        return userToLoad;
    }

    // checking if the user profile is already saved as json file
    // -> true: profile does not exist and is available; false: profile already exists and is therefore not available
    public static boolean checkUserAvailability(String nameToCheck){

        User checkUser = new User();

        checkUser = loadUserFromJson(nameToCheck);

        if(checkUser == null){
            System.out.println(nameToCheck + ".json does not exist.");
            return true;
        }else{
            return false;
        }


    }

}
