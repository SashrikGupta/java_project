package Database;

import Train_util.body.Chair_car;
import Train_util.body.Sleeper_car;
import operations_util.TrainOccupiedException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

import static Swingdisplay.Testing.*;

public class csv_cp {
    public static void cp_loader() throws FileNotFoundException {
        String csvFile = "C:\\Users\\sashr\\OneDrive\\Desktop\\nirma\\2nd year\\semester 3\\oops\\assinglemt\\innovative_Assingment\\src\\Database\\employee_cp_list.txt";
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                //System.out.println(data.length);
                if (data.length == 6) {
                    String name = data[0];
                    int age = Integer.parseInt(data[1].trim());
                    String sex = data[2];
                    int salary = Integer.parseInt(data[3].trim());
                    int counter = Integer.parseInt(data[4].trim());
                    int hourly_shift = Integer.parseInt(data[5].trim());

                    add_cp(name, age, sex, salary, counter, hourly_shift);
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