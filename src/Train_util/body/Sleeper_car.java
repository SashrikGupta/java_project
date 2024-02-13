package Train_util.body;

import java.util.*;

public class Sleeper_car extends passenger_car {

    // Following functionalities must be implemented:
    // - Unique pnr
    // - Ability to hold information for date/time-wise occupancy status
    // - Maintenance bar
    // - Maintenance reduction with every increase in passengers
    // - Exception handling for low maintenance
    // - Adding passengers based on passenger type
    // - Employee functionality

    // Constructor
    public Sleeper_car(int pnr, String start, String stop, int duration,  String etype ,  int coaches , List<String> route)
    {
        super( pnr , start , stop , duration  , route) ;
        count++;
        this.coaches = coaches ;
        this.etype = etype;
        this.first_class = 18*15*coaches/100 ;
        this.second_class = 46*25*coaches/100 ;
        this.third_class = 64*30*coaches/100 ;
        this.sleeper = 64*15*coaches/100 ;
        this.general = 64*(coaches - (first_class/18+second_class/46+third_class/64+sleeper/64)) ;
        this.capacity = 18*first_class + 46*second_class + 64*third_class + 64*sleeper + 64*general ;

    }

    //working ground_field//

    // private area
    private final int coaches ;
    private  String etype ;
    private int speed  = 120 ;
    static int count =0 ;
    private int brakepow  = 50 ;

    //public area
    public int capacity  ;
    public int first_class  ;
    public int second_class ;
    public int third_class ;
    public int sleeper ;
    public int general ;
    public HashMap<String , Integer> cap = new HashMap<String , Integer>() ;

    public void dater(String date)
    {
        cap.put("sleeper:" + date , 0) ;
        cap.put("first_class:" + date , 0) ;
        cap.put("second_class:" + date , 0) ;
        cap.put("third_class:" + date , 0) ;
        cap.put("general:" + date , 0) ;
    }
    // Override methods
    @Override
    public void route() {
        System.out.println("Your route of journey:");
        for (int i = 1; i <= stations.size(); i++) {
            System.out.println(i + ". " + stations.get(i) + " at: " + timing.get(i));
        }
    }
    public void addtrain(String date){seats.put(date , 0) ; }
    public int coaches() {return coaches;}
    public boolean isoccupied(String Date) {return seats.get(Date) == capacity;}
    public int occupancy(String Date) {
        return seats.get(Date);
    }
    public String display_id() {
        return Integer.toString(this.hashCode());
    }
    public void show_type(String type) {
        System.out.println("Engine type is: " + etype);
    }
    public void increase_speed(int speed) {
        this.speed += speed;
    }
    public String energy() {
        if (etype.equals("version3.75")) {
            return "electric";
        }
        if (etype.equals("version2.35")) {
            return "diesel";
        }
        if (etype.equals("version1.25")) {
            return "petroleum";
        }
        return "coal";
    }
    public void change_energy(String energy) {
        if (energy.equals("electric")) {
            etype = "version3.75";
        }
        if (energy.equals("diesel")) {
            etype = "version2.35";
        }
        if (energy.equals("petroleum")) {
            etype = "version1.25";
        } else {
            etype = "coal";
        }
    }
    public int brake_power() {
        return brakepow;
    }
    public void increase_power() {
        brakepow += 20;
    }
    public void show_break() {
        System.out.println("Current braking power: " + brakepow);
    }
    public void display_body_type() {
        System.out.println("Body type is aluminum");
    }
}
