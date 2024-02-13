package Swingdisplay;

import Train_util.body.*;
import passengers_util.Passenger_B;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static Swingdisplay.Testing.show_status;
import static Swingdisplay.Testing.*;

public class TrainStatusFrame {
    public static void show_status(Sleeper_car sc, String date, JTextArea textArea) {
        LocalDateTime currentTime = LocalDateTime.now();
        LocalDate rdate = LocalDate.now();
        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String curr = rdate.format(formatt);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String formattedTime = currentTime.format(formatter);
        textArea.append(" \n \n ----current Time: " + formattedTime + "-------\n");
        textArea.append("the following is the status of : " + sc.pnr + "\n");
        textArea.append("-----------------------------------------------------\n");
        textArea.append("Today date : " + curr + "\n");
        textArea.append("Today time : " + formattedTime + "\n");
        textArea.append("Name : " + sc.name + "\n");
        textArea.append("PNR : " + sc.pnr + "\n");
        textArea.append("-----------------------------------------------------\n");
        textArea.append("showing the occupancy  : \n");
        textArea.append("first class : " + sc.cap.get("first_class:" + date) + "/" + sc.first_class + "\n");
        textArea.append("second class : " + sc.cap.get("second_class:" + date) + "/" + sc.second_class + "\n");
        textArea.append("third class : " + sc.cap.get("third_class:" + date) + "/" + sc.third_class + "\n");
        textArea.append("sleeper class : " + sc.cap.get("sleeper:" + date) + "/" + sc.sleeper + "\n");
        textArea.append("general class : " + sc.cap.get("general:" + date) + "/" + sc.general + "\n");
        textArea.append("-----------------------------------------------------\n");
        boolean flag = true;
        if (!curr.equals(date)) {
            flag = false;
        }
        textArea.append("current path : \n");
        textArea.append("Station       Time\n");
        textArea.append("-----------------------\n");
        for (int i = 0; i < 10; i++) {
            if (timef(formattedTime) < timef(sc.timing.get(i)) && flag) {
                textArea.append(String.format("%-10s   ----Train---- (%s)\n", sc.stations.get(i), formattedTime));
                flag = false;
            } else {
                textArea.append(String.format("%-10s   %s\n", sc.stations.get(i), sc.timing.get(i)));
            }
        }
        textArea.append("-----------------------------------------------------\n");
        textArea.append("passengers\n");
        if (sc.passenger_date_list.containsKey(date)) {
            for (int i = 0; i < sc.passenger_date_list.get(date).size(); i++) {
                Passenger_B passenger = sc.passenger_date_list.get(date).get(i);
                textArea.append(String.format("%-20s %-10s\n", passenger.Name, passenger.Seatno));
            }
        } else {
            textArea.append("No passengers for the selected date.\n");
        }
        textArea.append("-----------------------------------------------------\n");
    }
    public static void show_status(Chair_car sc, String date, JTextArea textArea) {
        LocalDateTime currentTime = LocalDateTime.now();

        // Define a DateTimeFormatter to specify the time format (HH:mm:ss)
        LocalDate rdate = LocalDate.now(); // You can replace this with your desired date
        DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String curr = rdate.format(formatt);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        // Format the current time as a string with only the time part
        String formattedTime = currentTime.format(formatter);
        textArea.append(" \n \n ----current Time: " + formattedTime + "-------\n");

        textArea.append("the following is the status of : " + sc.pnr + "\n");
        textArea.append("-----------------------------------------------------\n");
        textArea.append("Today date : " + curr + "\n");
        textArea.append("Today time : " + formattedTime + "\n");
        textArea.append("Name : " + sc.name + "\n");
        textArea.append("PNR : " + sc.pnr + "\n");
        textArea.append("-----------------------------------------------------\n");
        textArea.append("showing the occupancy  : \n");
        textArea.append("current occupancy : " + sc.seats.get(date) + "/" + sc.chairs + "\n");
        textArea.append("-----------------------------------------------------\n");
        boolean flag = true;
        if (!curr.equals(date)) {
            flag = false;
        }
        textArea.append("current path : \n");
        textArea.append("Station       Time\n");
        textArea.append("-----------------------\n");
        for (int i = 0; i < 10; i++) {
            if (timef(formattedTime) < timef(sc.timing.get(i)) && flag) {
                textArea.append("----Train----" + "(" + formattedTime + ")\n");
                textArea.append(String.format("%-10s   %s%n", sc.stations.get(i), sc.timing.get(i)));
                flag = false;
            } else {
                textArea.append(String.format("%-10s   %s%n", sc.stations.get(i), sc.timing.get(i)));
            }
        }
        textArea.append("-----------------------------------------------------\n");
        textArea.append("passengers\n");
        for (int i = 0; i < sc.passenger_date_list.get(date).size(); i++) {
            Passenger_B passenger = sc.passenger_date_list.get(date).get(i);
            textArea.append(String.format("%-20s %-10s%n", passenger.Name, passenger.Seatno) + "\n");
        }
        textArea.append("-----------------------------------------------------\n");
    }





    private JFrame frame;
    private JTextArea textArea;

    public TrainStatusFrame(Sleeper_car car, String date) {
        frame = new JFrame("Train Status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        JButton showStatusButton = new JButton("Show Status");
        showStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your show_status method here and append the output to the text area
                show_status(car, date, textArea);

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showStatusButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public TrainStatusFrame(Chair_car car, String date) {
        frame = new JFrame("Train Status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        JButton showStatusButton = new JButton("Show Status");
        showStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your show_status method here and append the output to the text area
                show_status(car, date, textArea);

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showStatusButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
    public static void cofirmation(String email, JTextArea textArea) {
        textArea.append("---------------------------------------\n");
        if (passengers.containsKey(email)) {
            Passenger_B b = passengers.get(email);

            String keyFormat = "%-25s";
            String valueFormat = "%-20s";

            textArea.append(String.format(keyFormat + valueFormat + "%n", "Your name", ":   " + b.Name));
            textArea.append(String.format(keyFormat + valueFormat + "%n", "Your age", ":   " + b.age));
            textArea.append(String.format(keyFormat + valueFormat + "%n", "Your gender", ":   " + b.gender));
            textArea.append(String.format(keyFormat + valueFormat + "%n", "Your email", ":   " + b.email));
            textArea.append(String.format(keyFormat + valueFormat + "%n", "Your category", ":   " + b.cat));
            textArea.append(String.format(keyFormat + "%s%n", "Your seat no:", "coach : first_class seat : " + b.Seatno));

            if (b.getcat().equals("A")) {
                textArea.append(String.format(keyFormat + valueFormat + "%n", "Number of meals provided:", 4));
            }
            if (b.getcat().equals("S")) {
                textArea.append(String.format(keyFormat + valueFormat + "%n", "Number of meals provided:", 4));
            }
        }
    }
    public TrainStatusFrame(String email ) {
        frame = new JFrame("Train Status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        textArea = new JTextArea();
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.getContentPane().add(scrollPane);

        JButton showStatusButton = new JButton("Show Status");
        showStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call your show_status method here and append the output to the text area
                cofirmation(email , textArea) ;

            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(showStatusButton);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

}
