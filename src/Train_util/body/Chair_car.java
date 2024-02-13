
                    // import bay //

package Train_util.body;
import Train_util.components.Engine;
import Train_util.components.component ;
import passengers_util.*;
import java.util.* ;
import java.util.ArrayList;


public class Chair_car extends passenger_car {

                          // to do list //

    // following functionaliteis must be there
    // unique pnr
    // should be able to hold info for date/time wise occupancy status
    // should contain a maintainance bar
    // with every increace in passenger maintainance will reduce
    // less maintainance will throw exception
    // whether to maintain or not will be handeled by
    // add a passenger will function on the basis of type of passenger
     // to add employee functionality
     // to devlope employee functionality

                      // construction unit //
     public Chair_car(int pnr , String start , String stop , int duration  , int chairs , String etype , List<String> route  )
     {
          super( pnr , start , stop , duration  , route) ;
          count++ ;
          this.chairs = chairs ;
          this.etype = etype ;

     }

                      //working ground_field//

     // private area
     private  String etype ;
     private int speed  = 210 ;
     static int count =0 ;
     public  final int chairs   ;
     private int brakepow  = 40 ;

     //public area

     public int maintanance = 10000 ;

                            // overriding set

     //---------------------------------------------------------------------------------------------------------------//
     public void route() {
          System.out.println("your route of journey  : ");
          for(int i =1 ; i<=stations.size() ; i++)
          {
               System.out.println( i + ". " + stations.get(i) + "at : " + timing.get(i));
          }
     }
     public int coaches() {return 30;}
     public boolean isoccupied(String Date) {return seats.get(Date) == chairs;}
     public int occupancy(String Date) {return seats.get(Date);}
     public void addtrain(String date){seats.put(date , 0) ; }
     //---------------------------------------------------------------------------------------------------------------//
     public String display_id() {return Integer.toString(this.hashCode()) ;}
     public void show_type(String type ) {System.out.println("engine type is : " + etype);}
     public void increase_speed(int speed) {this.speed+=speed ;}
     public String energy() {
          if(etype.equals("version3.75")){
               return "electric" ;
          }
          if(etype.equals("version2.35"))
          {
               return "diesel";
          }
          if(etype.equals("version1.25"))
          {
               return "petroleum";
          }
          return "coal"  ;
     }
     public void change_energy( String energy ) {
          if(energy.equals("electric")){
               etype = "version3.75" ;
          }
          if(energy.equals("diesel")){
               etype = "version2.35" ;
          }
          if(energy.equals("petroleum")){
               etype = "version1.25" ;
          }
          else{
               etype = "coal" ;
          }
     }
     public int brake_power() {return brakepow ;}
     public void increase_power() {brakepow+=10 ;}
     public void show_break() {System.out.println("current braking power : " + brakepow);}
     public void display_body_type() {System.out.println("body type is aluminium");}
     //---------------------------------------------------------------------------------------------------------------//

}
