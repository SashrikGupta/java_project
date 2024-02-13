package Database;

import Train_util.body.Chair_car;
import Train_util.body.Sleeper_car;
import operations_util.TrainOccupiedException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static Swingdisplay.Testing.booking;

public class passenger_csv_reader_sc {
    public static void passenger_loader(Sleeper_car cc) throws FileNotFoundException {
        String csvFile =  "C:\\Users\\sashr\\OneDrive\\Desktop\\nirma\\2nd year\\semester 3\\oops\\assinglemt\\innovative_Assingment\\src\\Database\\passenger_sleeper.txt" ;
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
               // System.out.println(data.length);
                if (data.length == 12) {
                    String email = data[0];
                    int password = Integer.parseInt(data[1].trim());
                    String part = data[2] ;
                    int type = Integer.parseInt(data[3].trim());
                    int start = Integer.parseInt(data[4].trim());
                    int stop = Integer.parseInt(data[5].trim());
                    String name = data[6];
                    int age = Integer.parseInt(data[7].trim());
                    String gender = data[8];
                    String occupation = data[9];
                    //String chairCar = data[8];
                    String date = data[11];
                    //System.out.println(date);
                    booking(email,password,part , type , start,stop,name,age,gender,occupation,cc,date) ;
                } else {
                    System.out.println("Invalid CSV format: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}