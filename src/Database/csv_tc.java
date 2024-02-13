package Database;

import Train_util.body.Chair_car;
import Train_util.body.Sleeper_car;
import operations_util.TrainOccupiedException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

import static Swingdisplay.Testing.add_tc;
import static Swingdisplay.Testing.booking;

public class csv_tc {
    public static void tc_loader() throws FileNotFoundException {
        String csvFile =  "C:\\Users\\sashr\\OneDrive\\Desktop\\nirma\\2nd year\\semester 3\\oops\\assinglemt\\innovative_Assingment\\src\\Database\\employee_tc_list.txt" ;
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                //System.out.println(data.length);
                if (data.length == 6) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1].trim());
                    String sex = data[2] ;
                    int salary = Integer.parseInt(data[3].trim());
                    String station = data[4];
                    int hourly_shift = Integer.parseInt(data[5].trim());

                    add_tc(name  , age , sex , salary , station , hourly_shift) ;
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