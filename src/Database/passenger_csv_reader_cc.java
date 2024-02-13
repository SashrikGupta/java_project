package Database;

import Train_util.body.Chair_car;
import operations_util.TrainOccupiedException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

import static Swingdisplay.Testing.booking;

public class passenger_csv_reader_cc {
    public static String csvFile = "C:\\Users\\sashr\\OneDrive\\Desktop\\nirma\\2nd year\\semester 3\\oops\\assinglemt\\innovative_Assingment\\src\\Database\\passenger.txt";
    public static void passenger_loader(Chair_car cc) throws FileNotFoundException {

        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                //System.out.println(data.length);
                if (data.length == 10) {
                    String email = data[0];
                    int password = Integer.parseInt(data[1].trim());
                    int start = Integer.parseInt(data[2].trim());
                    int stop = Integer.parseInt(data[3].trim());
                    String name = data[4];
                    int age = Integer.parseInt(data[5].trim());
                    String gender = data[6];
                    String occupation = data[7];
                    //String chairCar = data[8];
                    String date = data[9];

                   booking(email,password,start,stop,name,age,gender,occupation,cc,date) ;
                } else {
                    System.out.println("Invalid CSV format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TrainOccupiedException e) {
            throw new RuntimeException(e);
        }
    }



    public static void writePassengerData(String csvFile, String email, int password, int start, int stop, String name, int age, String gender, String occupation, Chair_car cc, String date) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile, true))) {
            String data = email + "," + password + "," + start + "," + stop + "," + name + "," + age + "," + gender + "," + occupation + "," + "cc"+","+date ;
            writer.write(data);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void passenger_loader(String  email, int password, int start, int stop, String name, int age, String gender, String occupation, Chair_car cc, String date)
    {
        //writePassengerData(csvFile,email,password,start,stop,name,age,gender,occupation,cc,date) ;
    }
}
