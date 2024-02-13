package Train_util.body;
import employee_util.Chart_projector;
import employee_util.Ticket_checker;
import passengers_util.* ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class passenger_car extends Train
{
   static int count  ; //counting number of passengers
    public passenger_car(int pnr , String start , String stop , int duration ,List<String> route )
   {
       super( pnr , start , stop , duration ) ;
       this.stations = route ;
       count++ ;
   }

    public Ticket_checker tc1   = null ;
    public Ticket_checker tc2   = null ;

    public List<String> stations ;
    public List<String> timing = new ArrayList<>(List.of("06:00", "08:00", "10:00", "12:00", "14:00", "16:00", "18:00", "20:00", "22:00", "24:00"));

    public HashMap<String , Integer> seats    = new HashMap<String , Integer>() ;
    public HashMap<String , Integer> waiting  = new HashMap<String ,Integer>() ;
    public HashMap<String, ArrayList<Passenger_B> > passenger_date_list = new HashMap<>() ;

    public int maintanance = 10000 ;
    abstract int occupancy(String Date) ; // function to know occupancy
    abstract void addtrain(String Date) ;
}
