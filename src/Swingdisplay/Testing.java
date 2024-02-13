package Swingdisplay;

import Train_util.body.Chair_car;
import employee_util.Basic_Employee;
import employee_util.Chart_projector;
import employee_util.Counter_incharge;
import employee_util.Ticket_checker;
import Train_util.body.*;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import operations_util.* ;
import passengers_util.Passenger_A;
import passengers_util.Passenger_B;
import passengers_util.Passenger_S;

import java.util.Hashtable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List ;
import javax.swing.*;

import static Database.passenger_csv_reader_cc.passenger_loader;
import static operations_util.operations.route_north;
import static operations_util.operations.route_west;

//----------------------------------------// to - do list //----------------------------------------------------------//
// 1.function for  promotion of an employee(committie function ) (sashrik)
// 2.function for deletion of an employee(committie function) (sashrik)
// 3.holiday function (committie function ) (sashrik)
// 4.Mechanism to give complaint(sashrik)
// 5.implimentation of luggage car and business passenger(heer)
// 6.Make train name final and include in construtor(sashrik)
// 7.implimenting control sector(heer)
// 8.implimenting the show detaisl of the train(heer)
// 9.implimenting







//--------------------------------------------------------------------------------------------------------------------//

public class Testing
{
//--------------------------------------------------------------------------------------------------------------------//
                                               // hash-repository

                    public static HashMap<String,Chart_projector> cps = new HashMap<>() ;
                    public static HashMap<String,Ticket_checker> tcs = new HashMap<>() ;
                    public static HashMap<String,Counter_incharge> cis = new HashMap<>() ;
                    public static HashMap<Long,Train> trains = new HashMap<>() ;
                    public static HashMap<Integer,Chair_car> chaircars = new HashMap<>() ;
                    public static HashMap<Integer,Sleeper_car> sleeper = new HashMap<>() ;
                    public static HashMap<String,Passenger_B> passengers = new HashMap<>() ;


//--------------------------------------------------------------------------------------------------------------------//
                                             // time formating
public static int timef(String t ) {
    String timeString = t;
    String[] parts = timeString.split(":");

    if (parts.length == 2) {
        try {
            int hours = Integer.parseInt(parts[0]);
            return hours  ;
        } catch (NumberFormatException e) {
            System.out.println("Invalid format for hours");
        }
    } else {
        System.out.println("Invalid time format");
        return 0 ;
    }
    return 0 ;
}
//--------------------------------------------------------------------------------------------------------------------//
                                              // empolyee functions
//adding an employee
public static Counter_incharge add_ci( String name , int age , String sex , int salary  , int counter_number, int hourly_shift) {
        Counter_incharge newemp = new Counter_incharge(name , age , sex , salary , counter_number , hourly_shift)  ;
        cis.put(name , newemp) ;
        return newemp ;
}
public static Ticket_checker  add_tc( String name , int age , String sex , int salary  , String station, int hourly_shift) {
        Ticket_checker newemp = new Ticket_checker(name , age , sex , salary , station , hourly_shift)  ;
        tcs.put(name , newemp) ;
        return newemp ;
}
public static Chart_projector add_cp( String name , int age , String sex , int salary  , int counter_number, int hourly_shift) {
        Chart_projector newemp = new Chart_projector(name , age , sex , salary , counter_number , hourly_shift)  ;
        cps.put(name , newemp) ;
        return newemp ;
}
//showing details of employee
public static void show(Ticket_checker emp) {emp.show_detail();}
public static void show(Counter_incharge emp){emp.show_detail();}
public static void show(Chart_projector emp) {emp.show_detail();}
//raise asking
public static void raise(Ticket_checker emp , int raise) {emp.salary+=raise ;}
public static void raise(Chart_projector emp , int raise){emp.salary+=raise ;}
public static void raise(Counter_incharge emp , int raise){emp.salary+=raise ;}
//assign task
public static boolean task(Basic_Employee tc, String date ) {
    if(tc.avilable.containsKey(date))
    {
        tc.avilable.replace(date , false ) ;
        return true ;
    }
    return false ;
}

//--------------------------------------------------------------------------------------------------------------------//
                                                //passenger car function
//inputing
public static Chair_car add_Chair_car(int pnr,String start,String stop,int duration,int chairs,String etype , List<String> route){
    Chair_car newtrain = new Chair_car(pnr,start,stop,duration,chairs,etype , route) ;
    //trains.put(pnr,newtrain) ;
    chaircars.put((int)pnr,newtrain) ;
    return newtrain ;
}
public static Sleeper_car add_sleeper_car(int pnr,String start,String stop,int duration,int coaches,String etype , List<String> route){
        Sleeper_car newtrain = new Sleeper_car(pnr,start,stop,duration,etype , coaches , route) ;
        //trains.put(pnr,newtrain) ;
        sleeper.put((int)pnr , newtrain) ;
        return newtrain ;
}
public static void start_train(Chair_car car, String date ){
    car.addtrain(date);
}
public static void start_train(Sleeper_car car, String date){
        car.addtrain(date);
        car.dater(date) ;
}

//displaying
public static void show_status(Sleeper_car sc , String date ) {
    LocalDateTime currentTime = LocalDateTime.now();

    // Define a DateTimeFormatter to specify the time format (HH:mm:ss)
    LocalDate rdate = LocalDate.now(); // You can replace this with your desired date
    DateTimeFormatter formatt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String curr = rdate.format(formatt);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm") ;

    // Format the current time as a string with only the time part
    String formattedTime = currentTime.format(formatter);
    System.out.println(" \n \n ----current Time: " + formattedTime + "-------");


    System.out.println("the following is the status of : " + sc.pnr );
    System.out.println("-----------------------------------------------------");
    System.out.println("Today date : " + curr);
    System.out.println("Today time : " + formattedTime);
    System.out.println("Name : " + sc.name);
    System.out.println("PNR : " + sc.pnr);
    System.out.println("-----------------------------------------------------");
    System.out.println("showing the occupancy  : ");
    System.out.println("first class : " + sc.cap.get("first_class:"+date)+"/"+sc.first_class);
    System.out.println("second class : " + sc.cap.get("second_class:"+date)+"/"+sc.second_class);
    System.out.println("third class : " + sc.cap.get("third_class:"+date)+"/"+sc.third_class);
    System.out.println("sleeper class : " + sc.cap.get("sleeper:"+date)+"/"+sc.sleeper);
    System.out.println("general class : " + sc.cap.get("general:"+date)+"/"+sc.general);
    System.out.println("-----------------------------------------------------");
    boolean flag = true;
    if (!curr.equals(date)) {
        flag = false;
    }
    System.out.println("current path : ");
    System.out.println("Station       Time");
    System.out.println("-----------------------");
    for (int i = 0; i < 10; i++) {

        if (timef(formattedTime) < timef(sc.timing.get(i)) && flag) {
            System.out.printf("----Train---- (%s)%n%-10s   %s%n", formattedTime , sc.stations.get(i), sc.timing.get(i));
            flag = false;
        }
        else
        {
            System.out.printf("%-10s   %s%n", sc.stations.get(i), sc.timing.get(i));
        }


    }
    System.out.println("-----------------------------------------------------");
    System.out.println("passengers");
    for (int i = 0; i < sc.passenger_date_list.get(date).size(); i++) {
        Passenger_B passenger = sc.passenger_date_list.get(date).get(i);
        System.out.printf("%-20s %-10s%n", passenger.Name, passenger.Seatno);
    }
    System.out.println("-----------------------------------------------------");

}
public static void show_status(Chair_car sc , String date ){
    LocalDateTime currentTime = LocalDateTime.now();

    // Define a DateTimeFormatter to specify the time format (HH:mm:ss)
    LocalDate rdate = LocalDate.now(); // You can replace this with your desired date
    DateTimeFormatter formatt= DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String curr = rdate.format(formatt);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm") ;

    // Format the current time as a string with only the time part
    String formattedTime = currentTime.format(formatter);
    System.out.println(" \n \n ----current Time: " + formattedTime + "-------");


    System.out.println("the following is the status of : " + sc.pnr );
    System.out.println("-----------------------------------------------------");
    System.out.println("Today date : " + curr);
    System.out.println("Today time : " + formattedTime);
    System.out.println("Name : " + sc.name);
    System.out.println("PNR : " + sc.pnr);
    System.out.println("-----------------------------------------------------");
    System.out.println("showing the occupancy  : ");
    System.out.println("current occupancy : " + sc.seats.get(date) + "/" + sc.chairs);
    System.out.println("-----------------------------------------------------");
    boolean flag = true;
    if (!curr.equals(date)) {
        flag = false;
    }
    System.out.println("current path : ");
    System.out.println("Station       Time");
    System.out.println("-----------------------");
    for (int i = 0; i < 10; i++) {

        if (timef(formattedTime) < timef(sc.timing.get(i)) && flag) {
            System.out.printf("----Train---- (%s)%n%-10s   %s%n", formattedTime , sc.stations.get(i), sc.timing.get(i));
            flag = false;
        }
        else
        {
            System.out.printf("%-10s   %s%n", sc.stations.get(i), sc.timing.get(i));
        }


    }
    System.out.println("-----------------------------------------------------");
    System.out.println("passengers");
    for (int i = 0; i < sc.passenger_date_list.get(date).size(); i++) {
        Passenger_B passenger = sc.passenger_date_list.get(date).get(i);
        System.out.printf("%-20s %-10s%n", passenger.Name, passenger.Seatno);
    }
    System.out.println("-----------------------------------------------------");

}

//final display
public static void show_final_status(Sleeper_car sc , String date) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new TrainStatusFrame(sc,date);
        }
    });
}
public static void show_final_status(Chair_car sc , String date) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrainStatusFrame(sc,date);
            }
        });
    }
    //--------------------------------------------------------------------------------------------------------------------//
                                                   //passenger function
// booking a train
public static int booking(String email , int password ,int start, int stop, String name, int age, String gender, String occ, Chair_car cc, String date) throws TrainOccupiedException {
    int price = 0;



    if (true) {
        Passenger_B b = new Passenger_B(email , password ,name, age, gender, occ);
        if (cc.seats == null) {
            cc.seats = new HashMap<>(); // Initialize the seats map if it's null
        }
        if (!cc.seats.containsKey(date)) {
            start_train(cc, date);
            cc.passenger_date_list.put(date, new ArrayList<>()); // Initialize the list for this date
        }
        if (cc.isoccupied(date)) {
            // Throw a custom exception if the train is already occupied
            throw new TrainOccupiedException("Train is currently occupied on " + date);
        }
        ArrayList<Passenger_B> datePassengers = cc.passenger_date_list.get(date);
        if (datePassengers == null) {
            datePassengers = new ArrayList<>();
            cc.passenger_date_list.put(date, datePassengers);
        }
        datePassengers.add(b);
        cc.seats.put(date, cc.seats.get(date) + 1);
        b.coach = Integer.toString(cc.occupancy(date) / cc.coaches()+1);
        int seat = cc.occupancy(date) % cc.coaches();
        b.Seatno = "   coach : C" + b.coach + " seat : " + Integer.toString(seat);
        price = (stop - start) * 1000;
        passengers.put(email , b) ;
        passenger_loader(email,password,start,stop,name,age,gender,occ,cc,date) ;
    }

    return price;
}
public static int booking(String email , int password ,String part , int type  , int start, int stop, String name, int age, String gender, String occ, Sleeper_car cc, String date) throws Exception {
        int price = 0;
         int seat =0 ;
         if(type ==1 )
         {
             Passenger_B b = new Passenger_B(email , password ,name, age, gender, occ);
             if (cc.seats == null) {
                 cc.seats = new HashMap<>(); // Initialize the seats map if it's null
             }
             if (!cc.seats.containsKey(date)) {
                 start_train(cc, date);
                 cc.passenger_date_list.put(date, new ArrayList<>()); // Initialize the list for this date
             }
             if (cc.isoccupied(date)) {
                 // Throw a custom exception if the train is already occupied
                 throw new TrainOccupiedException("Train is currently occupied on " + date);
             }
             ArrayList<Passenger_B> datePassengers = cc.passenger_date_list.get(date);
             if (datePassengers == null) {
                 datePassengers = new ArrayList<>();
                 cc.passenger_date_list.put(date, datePassengers);
             }
             datePassengers.add(b);
             cc.seats.put(date, cc.seats.get(date) + 1);
             //seat allocation
             if (part.equals("sleeper")) {
                 if (cc.sleeper > cc.cap.get("sleeper:" + date)) {
                     b.coach = "sleeper";
                     cc.cap.replace("sleeper:" + date, cc.cap.get("sleeper:" + date) + 1);
                     seat =cc.cap.get("sleeper:" + date) ;
                 } else {
                     throw new Exception("Sleeper class is full. Try for any other class.");
                 }
             }
             if (part.equals("first_class")) {
                 if (cc.first_class > cc.cap.get("first_class:" + date)) {
                     b.coach = "first_class";
                     cc.cap.replace("first_class:" + date, cc.cap.get("first_class:" + date) + 1);
                     seat = cc.cap.get("first_class:" + date) ;
                 } else {
                     throw new Exception("First class is full. Try for any other class.");
                 }
             }
             if (part.equals("second_class")) {
                 if (cc.second_class > cc.cap.get("second_class:" + date)) {
                     b.coach = "second_class";
                     cc.cap.replace("second_class:" + date, cc.cap.get("second_class:" + date) + 1);
                     seat = cc.cap.get("second_class:" + date) ;
                 } else {
                     throw new Exception("Second class is full. Try for any other class.");
                 }
             }
             if (part.equals("third_class")) {
                 if (cc.third_class > cc.cap.get("third_class:" + date)) {
                     b.coach = "third_class";
                     cc.cap.replace("third_class:" + date, cc.cap.get("third_class:" + date) + 1);
                     seat = cc.cap.get("third_class:" + date) ;
                 } else {
                     throw new Exception("Third class is full. Try for any other class.");
                 }
             }
             if (part.equals("general")) {
                 if (cc.general > cc.cap.get("general:" + date)) {
                     b.coach = "general";
                     cc.cap.replace("general:" + date, cc.cap.get("general:" + date) + 1);
                     seat = cc.cap.get("general:" + date) + 1 ;
                 } else {
                     throw new Exception("General class is full. Try for any other class.");
                 }
             }
             b.Seatno = "coach : " + b.coach + " seat : " + Integer.toString(seat) ;
             passengers.put(email , b) ;
             price = (stop - start) * 1000;


         }
         if(type ==2 )
         {
             Passenger_A b = new Passenger_A(email , password ,name, age, gender, occ , 4 );
             if (cc.seats == null) {
                 cc.seats = new HashMap<>(); // Initialize the seats map if it's null
             }
             if (!cc.seats.containsKey(date)) {
                 start_train(cc, date);
                 cc.passenger_date_list.put(date, new ArrayList<>()); // Initialize the list for this date
             }

             ArrayList<Passenger_B> datePassengers = cc.passenger_date_list.get(date);
             if (datePassengers == null) {
                 datePassengers = new ArrayList<>();
                 cc.passenger_date_list.put(date, datePassengers);
                 cc.dater(date) ;
             }
             datePassengers.add(b);
             cc.seats.put(date, cc.seats.get(date) + 1);

             //seat allocation
             if (part.equals("sleeper")) {
                 if (cc.sleeper > cc.cap.get("sleeper:" + date)) {
                     b.coach = "sleeper";
                     cc.cap.replace("sleeper:" + date, cc.cap.get("sleeper:" + date) + 1);
                     seat =cc.cap.get("sleeper:" + date) ;
                 } else {
                     throw new Exception("Sleeper class is full. Try for any other class.");
                 }
             }
             if (part.equals("first_class")) {
                 if (cc.first_class > cc.cap.get("first_class:" + date)) {
                     b.coach = "first_class";
                     cc.cap.replace("first_class:" + date, cc.cap.get("first_class:" + date) + 1);
                     seat = cc.cap.get("first_class:" + date) ;
                 } else {
                     throw new Exception("First class is full. Try for any other class.");
                 }
             }
             if (part.equals("second_class")) {
                 if (cc.second_class > cc.cap.get("second_class:" + date)) {
                     b.coach = "second_class";
                     cc.cap.replace("second_class:" + date, cc.cap.get("second_class:" + date) + 1);
                     seat = cc.cap.get("second_class:" + date) ;
                 } else {
                     throw new Exception("Second class is full. Try for any other class.");
                 }
             }
             if (part.equals("third_class")) {
                 if (cc.third_class > cc.cap.get("third_class:" + date)) {
                     b.coach = "third_class";
                     cc.cap.replace("third_class:" + date, cc.cap.get("third_class:" + date) + 1);
                     seat = cc.cap.get("third_class:" + date) ;
                 } else {
                     throw new Exception("Third class is full. Try for any other class.");
                 }
             }
             if (part.equals("general")) {
                 if (cc.general > cc.cap.get("general:" + date)) {
                     b.coach = "general";
                     cc.cap.replace("general:" + date, cc.cap.get("general:" + date) + 1);
                     seat = cc.cap.get("general:" + date) + 1 ;
                 } else {
                     throw new Exception("General class is full. Try for any other class.");
                 }
             }


             b.Seatno = "coach : " + b.coach + " seat : " + Integer.toString(seat) ;
             passengers.put(email , b) ;
             price = (stop - start) * 4000;


         }
         if(type ==3 )
         {
             Passenger_S b = new Passenger_S(email , password ,name, age, gender, occ , 4 , true);
             if (cc.seats == null) {
                 cc.seats = new HashMap<>(); // Initialize the seats map if it's null
             }
             if (!cc.seats.containsKey(date)) {
                 start_train(cc, date);
                 cc.passenger_date_list.put(date, new ArrayList<>()); // Initialize the list for this date
             }

             ArrayList<Passenger_B> datePassengers = cc.passenger_date_list.get(date);
             if (datePassengers == null) {
                 datePassengers = new ArrayList<>();
                 cc.passenger_date_list.put(date, datePassengers);
                 cc.dater(date) ;
             }
             datePassengers.add(b);
             cc.seats.put(date, cc.seats.get(date) + 1);

             //seat allocation
             if (part.equals("sleeper")) {
                 if (cc.sleeper > cc.cap.get("sleeper:" + date)) {
                     b.coach = "sleeper";
                     cc.cap.replace("sleeper:" + date, cc.cap.get("sleeper:" + date) + 1);
                     seat =cc.cap.get("sleeper:" + date) ;
                 } else {
                     throw new Exception("Sleeper class is full. Try for any other class.");
                 }
             }
             if (part.equals("first_class")) {
                 if (cc.first_class > cc.cap.get("first_class:" + date)) {
                     b.coach = "first_class";
                     cc.cap.replace("first_class:" + date, cc.cap.get("first_class:" + date) + 1);
                     seat = cc.cap.get("first_class:" + date) ;
                 } else {
                     throw new Exception("First class is full. Try for any other class.");
                 }
             }
             if (part.equals("second_class")) {
                 if (cc.second_class > cc.cap.get("second_class:" + date)) {
                     b.coach = "second_class";
                     cc.cap.replace("second_class:" + date, cc.cap.get("second_class:" + date) + 1);
                     seat = cc.cap.get("second_class:" + date) ;
                 } else {
                     throw new Exception("Second class is full. Try for any other class.");
                 }
             }
             if (part.equals("third_class")) {
                 if (cc.third_class > cc.cap.get("third_class:" + date)) {
                     b.coach = "third_class";
                     cc.cap.replace("third_class:" + date, cc.cap.get("third_class:" + date) + 1);
                     seat = cc.cap.get("third_class:" + date) ;
                 } else {
                     throw new Exception("Third class is full. Try for any other class.");
                 }
             }
             if (part.equals("general")) {
                 if (cc.general > cc.cap.get("general:" + date)) {
                     b.coach = "general";
                     cc.cap.replace("general:" + date, cc.cap.get("general:" + date) + 1);
                     seat = cc.cap.get("general:" + date) + 1 ;
                 } else {
                     throw new Exception("General class is full. Try for any other class.");
                 }
             }


             b.Seatno = "coach : " + b.coach + " seat : " + Integer.toString(seat) ;
             passengers.put(email , b) ;
             price = (stop - start) * 13000;


         }
        return price;
    }
    public static void cofirmation(String email) {
        System.out.println("---------------------------------------");
        if (passengers.containsKey(email)) {
            Passenger_B b = passengers.get(email);

            String keyFormat = "%-25s";
            String valueFormat = "%-20s";

            System.out.printf(keyFormat + valueFormat + "%n", "Your name", ":   "+b.Name);
            System.out.printf(keyFormat + valueFormat + "%n", "Your age", ":   "+b.age);
            System.out.printf(keyFormat + valueFormat + "%n", "Your gender", ":   "+b.gender);
            System.out.printf(keyFormat + valueFormat + "%n", "Your email", ":   "+b.email);
            System.out.printf(keyFormat + valueFormat + "%n", "Your category", ":   "+b.cat);
            System.out.printf(keyFormat + "%s%n", "Your seat no:", "coach : first_class seat : " + b.Seatno);

            if (b.getcat().equals("A")) {
                System.out.printf(keyFormat + valueFormat + "%n", "Number of meals provided:", 4);
            }
            if (b.getcat().equals("S")) {
                System.out.printf(keyFormat + valueFormat + "%n", "Number of meals provided:", 4);
            }
        }
    }
    public static void final_confirmation(String email) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TrainStatusFrame(email);
            }
        });
    }

    //--------------------------------------------------------------------------------------------------------------------//
                                                  //testing ground
    public static void main(String[] args) throws Exception {
        Ticket_checker tc = add_tc("Ashok" , 35 , "male" , 30000 , "jodhpur" , 10);

//        add_Chair_car(123456781L , "mumbai" , "panji" , 10 , 130 , "none", route_west);
//        Chair_car cs = chaircars.get(123456781L);
//        start_train(cs , "07/11/2023");
//        task(tcs.get("Ashok") , cs , "07/11/2023");
//        //cs.seats.put("07/11/2023" , 130 ) ;
//        booking("1" , 1 , 1 , 4 , "sashrik" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("2" , 1 , 1 , 4 , "sanaya" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("3" , 1 , 1 , 4 , "Rahul" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("4" , 1 , 1 , 4 , "Hardik" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("5" , 1 , 1 , 4 , "Mehul" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("6" , 1 , 1 , 4 , "Myanak" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//        booking("7" , 1 , 1 , 4 , "Soumya" , 19 , "Male" , "doctor" , cs , "07/11/2023");
//
//        //show_final_status(cs , "07/11/2023") ;
//
//        System.out.println(cs.passenger_date_list.size());
//        for(int i =0 ; i<cs.passenger_date_list.get("07/11/2023").size() ; i++) {
//            System.out.print(cs.passenger_date_list.get("07/11/2023").get(i).Name);
//            System.out.println(cs.passenger_date_list.get("07/11/2023").get(i).Seatno);
//        }
//        System.out.println(cs.occupancy("07/11/2023"));
//
//        Sleeper_car car1  = add_sleeper_car(1234567888L , "mumbai" , "panji" , 10 , 10 , "none" , route_west) ;
//        long pnr1 = car1.pnr ;
//        Sleeper_car sc = sleeper.get(pnr1) ;
//
//        //sc.cap.replace("first_class:19/09/2004" , 27 ) ;
//        int price = booking("sashrik_gupta@gmail.com" , 12345 , "first_class" , 2 , 1 , 3 , "sashrik" , 13 , "male" , "doctor"  , sc , "19/09/2004") ;
//        int pric = booking("Soham_barot@gmial.com" , 12345 , "first_class" , 1 , 1 , 3 , "soham" , 13 , "male" , "doctor"  , sc , "19/09/2004") ;
//        int r = sc.cap.get("first_class:" + "19/09/2004") ;
//        final_confirmation("sashrik_gupta@gmail.com") ;
//        System.out.println(sc.cap.get("first_class:19/09/2004") + "/" + sc.first_class );
//        System.out.println(passengers.get("Soham_barot@gmial.com").Seatno);
//        System.out.println(sc.second_class);
//        System.out.println(sc.third_class);
//        System.out.println(sc.sleeper);
//        System.out.println(sc.general);
//        System.out.println(r);
//        System.out.println(price);
//        //show_final_status(sc , "19/09/2004");





    }
}
//--------------------------------------------------------------------------------------------------------------------//
                                                //null ground
