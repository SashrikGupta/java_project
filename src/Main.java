// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import Train_util.body.Chair_car;
import Train_util.body.Sleeper_car;
import operations_util.* ;
import committie_util.* ;
import java.util.List;
import java.util.Scanner;
import static Database.traindata.*;
import static Swingdisplay.Testing.*;
import static operations_util.operations.*;
import static operations_util.operations.route_west;

public class Main {
    //adding employee
    public static void menu_add_TC() {
        String name, sex, station;
        int age, salary, hourly_shift;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sex: ");
        sex = scanner.nextLine();
        System.out.print("Enter salary: ");
        salary = scanner.nextInt();
        System.out.print("Enter station: ");
        station = scanner.next();
        System.out.print("Enter hourly shift: ");
        hourly_shift = scanner.nextInt();
        scanner.close();
        add_tc(name, age, sex, salary, station, hourly_shift);
    }
    public static void menu_add_CI() {
        String name, sex;
        int age, salary, counter_number, hourly_shift;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sex: ");
        sex = scanner.nextLine();
        System.out.print("Enter salary: ");
        salary = scanner.nextInt();
        System.out.print("Enter counter number: ");
        counter_number = scanner.nextInt();
        System.out.print("Enter hourly shift: ");
        hourly_shift = scanner.nextInt();
        scanner.close();
        add_ci(name, age, sex, salary, counter_number, hourly_shift);
    }
    public static void menu_add_CP(){
        String name, sex;
        int age, salary, counter_number, hourly_shift;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter sex: ");
        sex = scanner.nextLine();
        System.out.print("Enter salary: ");
        salary = scanner.nextInt();
        System.out.print("Enter counter number: ");
        counter_number = scanner.nextInt();
        System.out.print("Enter hourly shift: ");
        hourly_shift = scanner.nextInt();
        scanner.close();
        add_cp(name, age, sex, salary, counter_number, hourly_shift);
    }

    //showing an employee handeled at main
    //giving raise : handeled at main
    //giving task : handeled at main

    //adding train
    public static void menu_add_chair_car(){
        int pnr;
        String start, stop, etype;
        int duration, chairs;
        List<String> route = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PNR: ");
        pnr = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter starting station: ");
        start = scanner.nextLine();
        System.out.print("Enter destination station: ");
        stop = scanner.nextLine();
        System.out.print("Enter duration (in minutes): ");
        duration = scanner.nextInt();
        System.out.print("Enter number of chairs: ");
        chairs = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter equipment type: ");
        etype = scanner.nextLine();
        System.out.println("Choose a route: ");
        System.out.println("1. Route West");
        System.out.println("2. Route North");
        System.out.println("3. Route East");
        System.out.println("4. Route South");
        System.out.print("Enter the route choice (1/2/3/4): ");
        int routeChoice = scanner.nextInt();
        switch (routeChoice) {
            case 1:
                route = route_west;
                break;
            case 2:
                route = route_north;
                break;
            case 3:
                route = route_east;
                break;
            case 4:
                route = route_south;
                break;
            default:
                System.out.println("Invalid route choice. Using default route.");
                route = route_west;
        }
        scanner.close();
        add_Chair_car(pnr, start, stop, duration, chairs, etype, route);
    }
    public static void menu_add_sleeper_car(){
        int pnr;
        String start, stop, etype;
        int duration, coaches;
        List<String> route = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter PNR: ");
        pnr = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter starting station: ");
        start = scanner.nextLine();
        System.out.print("Enter destination station: ");
        stop = scanner.nextLine();
        System.out.print("Enter duration (in minutes): ");
        duration = scanner.nextInt();
        System.out.print("Enter number of coaches: ");
        coaches = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter equipment type: ");
        etype = scanner.nextLine();
        System.out.println("Choose a route: ");
        System.out.println("1. Route West");
        System.out.println("2. Route North");
        System.out.println("3. Route East");
        System.out.println("4. Route South");
        System.out.print("Enter the route choice (1/2/3/4): ");
        int routeChoice = scanner.nextInt();
        switch (routeChoice) {
            case 1:
                route = route_west;
                break;
            case 2:
                route = route_north;
                break;
            case 3:
                route = route_east;
                break;
            case 4:
                route = route_south;
                break;
            default:
                System.out.println("Invalid route choice. Using default route.");
                route = route_west;
        }
        scanner.close();
        add_sleeper_car(pnr, start, stop, duration, coaches, etype, route);
    }
    public static void menu_booking_chair_car(String email  , int password) throws TrainOccupiedException {
        String  name, gender, occ, date;
        int  start, stop, age;
        int pnr ;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pnr : ");
        pnr = scanner.nextInt();
        Chair_car cc = chaircars.get(pnr);
        System.out.print("Enter starting station: ");
        start = scanner.nextInt();
        System.out.print("Enter destination station: ");
        stop = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter name: ");
        name = scanner.nextLine();
        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter gender: ");
        gender = scanner.nextLine();
        System.out.print("Enter occupation: ");
        occ = scanner.nextLine();
        System.out.print("Enter date: ");
        date = scanner.nextLine();
        scanner.close();
        int price = booking(email, password, start, stop, name, age, gender, occ, cc, date);
        System.out.println(price);
        final_confirmation(email);
    }
    public static void menu_booking_sleeper_car(String email , int password) throws Exception {
        String name, gender, occ, date, part;
        int start, stop, age, type;
        int pnr;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter pnr: ");
        pnr = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Sleeper_car cc = sleeper.get(pnr);
        System.out.print("Enter part: ");
        part = scanner.nextLine();

        System.out.print("Enter your passenger status: ");
        type = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter starting station: ");
        start = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter destination station: ");
        stop = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter name: ");
        name = scanner.nextLine();

        System.out.print("Enter age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter gender: ");
        gender = scanner.nextLine();

        System.out.print("Enter occupation: ");
        occ = scanner.nextLine();

        System.out.print("Enter date: ");
        date = scanner.nextLine();

        int price = booking(email, password, part, type, start, stop, name, age, gender, occ, cc, date);
        System.out.println(price);

        final_confirmation(email);
        scanner.close();

    }

    public static void main(String[] args) throws Exception {


        Finance_manager Manoj_Shukla = new Finance_manager("Manoj Shukla");
        Station_manager Rishab_Shukla = new Station_manager("Rishabh Shukla");
        import_train();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
                int count = 0;
        System.out.println("describe your position : ");
        System.out.println("1. HEAD");
        System.out.println("2. finance minister");
        System.out.println("3. station minister");
        System.out.println("4. Ticket-Checker");
        System.out.println("5. Chart-projector");
        System.out.println("6. counter-incharge");
        System.out.println("7. passenger");
        System.out.println("8 . exit ");

        count = sc.nextInt();
            if(count==8){break ; }
        if (count == 7) {
            int rc = 0;
            System.out.println("you have following function : ");
            System.out.println("1. see status of a train ");
            System.out.println("2. book a tickect ");
            System.out.println("3. seek confirmation");
            System.out.println("4. exit");
            rc = sc.nextInt();
            sc.nextLine();
            if (rc == 1) {
                System.out.println("1. chair car or 2. sleeper car");
                int tem = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                int pnr;
                System.out.println("Enter the pnr of the train whose status you want to see and date:");
                pnr = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                System.out.print("Enter the date: ");
                String date = sc.nextLine();
                //ystem.out.println(date);
                if (tem == 1) {
                    show_status(chaircars.get(pnr), date);
                }
                if (tem == 2) {
                    show_status(sleeper.get(pnr), date);
                }
            }
            if (rc == 2) {
                System.out.println("Train\t\tName\t\t            PNR");
                System.out.println("c1:\t\t" + c1.name + "\t\t" + c1.pnr);
                System.out.println("c2:\t\t" + c2.name + "\t\t" + c2.pnr);
                System.out.println("c3:\t\t" + c3.name + "\t\t" + c3.pnr);
                System.out.println("c4:\t\t" + c4.name + "\t\t" + c4.pnr);
                System.out.println("c5:\t\t" + c5.name + "\t\t" + c5.pnr);
                System.out.println("c6:\t\t" + c6.name + "\t\t" + c6.pnr);
                System.out.println("s1:\t\t" + s1.name + "    "+"\t\t" + s1.pnr);
                System.out.println("s2:\t\t" + s2.name +"    "+ "\t\t" + s2.pnr);
                System.out.println("s3:\t\t" + s3.name +"        "+"\t\t" + s3.pnr);
                System.out.println("s4:\t\t" + s4.name +"        "+ "\t\t" + s4.pnr);
                System.out.println("s5:\t\t" + s5.name +"        "+ "\t\t" + s5.pnr);
                System.out.println("s6:\t\t" + s6.name +"     "+ "\t\t" + s6.pnr);
                System.out.println("s7:\t\t" + s7.name +"     "+ "\t\t" + s7.pnr);

                System.out.println("Route West: " + route_west);
                System.out.println("Route North: " + route_north);
                System.out.println("Route East: " + route_east);
                System.out.println("Route South: " + route_south);

                System.out.print("Enter email: ");
                String email = sc.nextLine();

                System.out.print("Enter password: ");
                int password = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                System.out.println("1. chair car or 2. sleeper car");
                int tem = sc.nextInt();
                //sc.nextLine(); // Consume the newline character
                System.out.println("your price ");
                if (tem == 1) {
                    menu_booking_chair_car(email, password);
                } else if (tem == 2) {
                    menu_booking_sleeper_car(email, password);
                }
                break ;
            }
            if (rc == 3) {
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                final_confirmation(email);
            }
            if (rc == 4) {
                System.out.println("thanks ");
            }
        }
        if (count == 6 || count == 5 || count == 4) {
            String pass = "102030405060";
            while (true) {
                System.out.println("enter pin :");
                sc.nextLine();
                String input = sc.nextLine();
                if (input.equals(pass)) {
                    break;
                } else {
                    System.out.println("wrong pin ");
                }
            }
            if (count == 5) {
                System.out.println("welcome chart-Projector");
                System.out.println("enter your name :");
                String name = sc.nextLine();
                show(cps.get(name));
                System.out.println("your work load : ");
                for (int i = 0; i < cps.get(name).avilable.size(); i++) {
                    System.out.println(cps.get(name).avilable.keySet() + " : " + cps.get(name).avilable.values());
                }
            }
            if (count == 4) {
                System.out.println("welcome Ticket-Checker");
                System.out.println("enter your name :");
                String name = sc.nextLine();
                show(tcs.get(name));
                for (int i = 0; i < tcs.get(name).avilable.size(); i++) {
                    System.out.println(tcs.get(name).avilable.keySet() + " : " + tcs.get(name).avilable.values());
                }
            }
            if (count == 6) {
                System.out.println("welcome counter-incharge");
                System.out.println("enter your name :");
                String name = sc.nextLine();
                show(tcs.get(name));
                for (int i = 0; i < cis.get(name).avilable.size(); i++) {
                    System.out.println(cis.get(name).avilable.keySet() + " : " + cis.get(name).avilable.values());
                }
            }
        }
        if (count == 2 || count == 3) {
            String pass = "999999999";
            while (true) {
                System.out.println("enter pin :");
                sc.nextLine();
                String input = sc.nextLine();
                if (input.equals(pass)) {
                    System.out.println("welcome committee members");
                    break;
                } else {
                    System.out.println("wrong pin ");
                }
            }

            if (count == 2) {
                System.out.println("weclcome finance minister : MANOJ SHUKLA ");
            }
            if (count == 3) {
                System.out.println("weclcome station minister : RISHABH SHUKLA ");
            }
            System.out.println("you can perfrom the following task :");
            System.out.println("1. assign task to your subordinate  ");
            System.out.println("2. list of subordinates  ");
            System.out.println("3. giving raise to a subordinate ");
            System.out.println("4. adding a subordinate ");
            System.out.println("5. exit ");
            int rc = 0;
            rc = sc.nextInt();
            if (rc == 1) {
                System.out.println("list of all your subordinates ");
                if (count == 2) {
                    for (int i = 0; i < Finance_manager.subordinates.size(); i++) {
                        int r = i + 1;
                        System.out.println(r + ".  " + Finance_manager.subordinates.get(i).name);
                    }
                    System.out.println("enter sr no of the subordinate :");
                    int z = sc.nextInt();
                    sc.nextLine();
                    System.out.println("enter date : ");
                    String date = sc.nextLine();
                    task(Finance_manager.subordinates.get(z - 1), date);
                }
                if (count == 3) {

                    int r = 0;
                    System.out.println("ticket checkers : ");
                    for (int i = 0; i < Station_manager.subordinates1.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates1.get(i).name);
                    }
                    r = 0;
                    System.out.println("counter incharge :");
                    for (int i = 0; i < Station_manager.subordinates2.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates2.get(i).name);
                    }

                    System.out.println("do you want to assign  tc(1) or subordinate(2) ");
                    int ken = sc.nextInt();
                    if (ken == 1) {
                        for (int i = 0; ; i++) {
                            System.out.println("enter sr no of the tc :");
                            int z = sc.nextInt();
                            sc.nextLine();
                            System.out.println("enter date : ");
                            String date = sc.nextLine();
                            if (tcs.get(Station_manager.subordinates1.get(z - 1).name).isAvilable(date)) {
                                task(Station_manager.subordinates1.get(z - 1), date);
                                System.out.println("the current person is avilabel and task has been assigned");
                                break;
                            } else {
                                System.out.println("current person is not avilable on date : " + date);
                                System.out.println("try for any other subordinate  : ");
                            }
                        }
                    }
                    if (ken == 2) {
                        for (int i = 0; ; i++) {
                            System.out.println("enter sr no of the tc :");
                            int z = sc.nextInt();
                            sc.nextLine();
                            System.out.println("enter date : ");
                            String date = sc.nextLine();
                            if (tcs.get(Station_manager.subordinates2.get(z - 1).name).isAvilable(date)) {
                                task(Station_manager.subordinates2.get(z - 1), date);
                                System.out.println("the current person is avilabel and task has been assigned");
                                break;
                            } else {
                                System.out.println("current person is not avilable on date : " + date);
                                System.out.println("try for any other subordinate  : ");
                            }
                        }
                    }

                }
            }
            if (rc == 2) {
                System.out.println("list of all your subordinates ");
                if (count == 2) {
                    for (int i = 0; i < Finance_manager.subordinates.size(); i++) {
                        int r = i + 1;
                        System.out.println(r + ".  " + Finance_manager.subordinates.get(i).name);
                    }
                }
                if (count == 3) {
                    int r = 0;
                    for (int i = 0; i < Station_manager.subordinates1.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates1.get(i).name);
                    }
                    for (int i = 0; i < Station_manager.subordinates2.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates2.get(i).name);
                    }
                }
            }
            if (rc == 3) {
                System.out.println("list of all your subordinates ");
                if (count == 2) {
                    for (int i = 0; i < Finance_manager.subordinates.size(); i++) {
                        int r = i + 1;
                        System.out.println(r + ".  " + Finance_manager.subordinates.get(i).name);
                    }
                    System.out.println("enter sr no of the ci :");
                    int z = sc.nextInt();
                    System.out.println("enter raise amount : ");
                    int raise = sc.nextInt();
                    raise(tcs.get(Finance_manager.subordinates.get(z - 1).name), raise);
                }
                if (count == 3) {
                    int r = 0;
                    for (int i = 0; i < Station_manager.subordinates1.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates1.get(i).name);
                    }
                    for (int i = 0; i < Station_manager.subordinates2.size(); i++) {
                        r++;
                        System.out.println(r + ".  " + Station_manager.subordinates2.get(i).name);
                    }
                    System.out.println("do you want to assign  tc(1) or subordinate(2) ");
                    int ken = sc.nextInt();
                    if (ken == 1) {

                        System.out.println("enter sr no of the tc :");
                        int z = sc.nextInt();
                        System.out.println("enter raise amount : ");
                        int raise = sc.nextInt();
                        raise(tcs.get(Station_manager.subordinates1.get(z - 1).name), raise);

                    }
                    if (ken == 2) {
                        System.out.println("enter sr no of the cp :");
                        int z = sc.nextInt();
                        System.out.println("enter raise amount : ");
                        int raise = sc.nextInt();
                        raise(tcs.get(Station_manager.subordinates2.get(z - 1).name), raise);
                    }
                }
            }
            if (rc == 4) {
                if (count == 2) {
                    menu_add_CI();
                }
                if (count == 3) {
                    System.out.println("do you want to add tc(1) or cp(2) ");
                    int ken = sc.nextInt();
                    if (ken == 1) {
                        menu_add_TC();
                    }
                    if (ken == 2) {
                        menu_add_CP();
                    }
                }
            }
        }
        if (count == 1) {
            sc.nextLine();
            String pin = "indian@rail";
            while (true) {
                System.out.println("enter pin ");
                String in = sc.nextLine();
                if (in.equals(pin)) {
                    System.out.println("correct pin");

                    break;
                } else {
                    System.out.println("wrong pin ");
                }
            }
            int rc = 0;
            System.out.println("welcome HEAD OF RAILWAY : MR SINGHANIA  ");
            System.out.println("following functions can be performed :");
            System.out.println("1. arrange meeting with your subordinates");
            System.out.println("2. list of your subordinates");
            System.out.println("3. addition of a new railway train ");
            System.out.println("4. exit ");
            rc = sc.nextInt();
            sc.nextLine();
            if (rc == 1) {
                System.out.println("enter date of your meeting ");
                String date = sc.nextLine();
                System.out.println("your meating has been arranged for date : " + date + " in the head quaters ");

            }
            if (rc == 2) {
                System.out.println("1. Finance minister : Manoj SHUKLA ");
                System.out.println("his subordinates :");
                for (int i = 0; i < Finance_manager.subordinates.size(); i++) {
                    int r = i + 1;
                    System.out.println(r + ".  " + Finance_manager.subordinates.get(i).name);
                }
                System.out.println("2. Station minister : RISHABH SHUKLA");
                System.out.println("his subordinates :");
                int r = 0;
                for (int i = 0; i < Station_manager.subordinates1.size(); i++) {
                    r++;
                    System.out.println(r + ".  " + Station_manager.subordinates1.get(i).name);
                }
                for (int i = 0; i < Station_manager.subordinates2.size(); i++) {
                    r++;
                    System.out.println(r + ".  " + Station_manager.subordinates2.get(i).name);
                }

            }
            if (rc == 3) {
                System.out.println("do you want to add");
                System.out.println("1. chair car  ");
                System.out.println("2. sleeper car ");
                int dec = sc.nextInt();
                if (dec == 1) {
                    menu_add_chair_car();
                }
                if (dec == 2) {
                    menu_add_sleeper_car();
                }

            }
        }

            System.out.println("------------------------------------------------------------------------");
    }      //adding train 90%
    }
}


