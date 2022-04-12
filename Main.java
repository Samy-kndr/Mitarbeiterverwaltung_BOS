import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World ;D");

        System.out.println("Test");
    }

    // saves given Object to a .json file that can be loaded again later
    // -MF
    public static void printObjectToJson(Object object, String fileName){

        System.out.println("Saving Object to " + fileName + ".json...");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonToSave = gson.toJson(object);

        try{

            PrintWriter writer = new PrintWriter(fileName + ".json", StandardCharsets.UTF_8);
            writer.println(jsonToSave);
            writer.close();

        }catch(Exception e) {

            e.printStackTrace();

        }

        System.out.println(fileName + ".json successfully saved!");

    }

    // reads given Object from a .json file to a String value, so it can be loaded into an existing Object
    // ("pathname" is here the name of the file, because it is saved in the same folder as the program")
    // -MF
    public static String readJsonToString(String pathname){
        String jsonToReturn = "";

        try{

            File fileToRead = new File(pathname + ".json");
            Scanner reader = new Scanner(fileToRead);

            while(reader.hasNextLine()){
                jsonToReturn = jsonToReturn + reader.nextLine();
            }

        }catch(FileNotFoundException e){

            System.out.println(pathname + ".json was not found...");
            e.printStackTrace();

        }

        return jsonToReturn;
    }

}
