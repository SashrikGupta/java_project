package Database;

import Train_util.body.*;
import employee_util.Ticket_checker;
import operations_util.TrainOccupiedException;

import java.io.FileNotFoundException;

import static Database.csv_cp.cp_loader;
import static Database.csv_tc.tc_loader;
import static Database.csv_ci.ci_loader;
import static Database.passenger_csv_reader_cc.passenger_loader;
import static Database.passenger_csv_reader_sc.passenger_loader ;
import static Swingdisplay.Testing.* ;
import static operations_util.operations.*;

public class traindata
{
    public static Chair_car c1 , c2 , c3 , c4 , c5 , c6 ;
    public static Sleeper_car s1 , s2 ,s3 , s4 , s5 , s6 ,s7;
    public static void import_train() throws TrainOccupiedException, FileNotFoundException {
         c1 = add_Chair_car(123456781 , "mumbai" , "panji" , 10 , 47 , "none", route_west);
        c1.name = "western chair express" ;
         c2 = add_Chair_car(111111111 , "mumbai" , "panji" , 10 , 130 , "none", route_north);
        c2.name = "northern chair express" ;
         c3 = add_Chair_car(222222222 , "mumbai" , "panji" , 10 , 130 , "none", route_south);
        c3.name = "sourthen chair express" ;
         c4 = add_Chair_car(333333333 , "mumbai" , "panji" , 10 , 130 , "none", route_south);
        c4.name = "sourthen wild express" ;
         c5 = add_Chair_car(444444444 , "mumbai" , "panji" , 10 , 130 , "none", route_east);
        c5.name = "bengal chair express" ;
         c6 = add_Chair_car(555555555 , "mumbai" , "panji" , 10 , 130 , "none", route_west);
        c6.name = "gujarat-mumbai express" ;

        // intitalising starting passenegers
        booking("1" , 1 , 1 , 4 , "sashrik" , 19 , "Male" , "doctor" , c1 , "07/11/2023");
        booking("2" , 1 , 1 , 4 , "sanaya" , 19 , "Male" , "doctor" , c2 , "07/11/2023");
        booking("3" , 1 , 1 , 4 , "Rahul" , 19 , "Male" , "doctor" , c3 , "07/11/2023");
        booking("4" , 1 , 1 , 4 , "Hardik" , 19 , "Male" , "doctor" , c4 , "07/11/2023");
        booking("5" , 1 , 1 , 4 , "Mehul" , 19 , "Male" , "doctor" , c5 , "07/11/2023");
        booking("6" , 1 , 1 , 4 , "Myanak" , 19 , "Male" , "doctor" , c6 , "07/11/2023");
        booking("7" , 1 , 1 , 4 , "Soumya" , 19 , "Male" , "doctor" , c1 , "07/11/2023");

        //passenger_loader(c1) ;
        passenger_loader(c2) ;
        passenger_loader(c4);

         s1 = add_sleeper_car(121212121 , "mumbai" , "panji" , 10 , 10 , "none", route_west) ;
        s1.name = "ahemdabad express" ;
         s2 = add_sleeper_car(999999999 , "mumbai" , "panji" , 10 , 10 , "none", route_north) ;
        s2.name = "rajdhani express" ;
         s3 = add_sleeper_car(888888888 , "mumbai" , "panji" , 10 , 10 , "none", route_east) ;
        s3.name = "assam express" ;
         s4 = add_sleeper_car(777777777 , "mumbai" , "panji" , 10 , 10 , "none", route_south) ;
        s4.name = "Chennai express" ;
         s5 = add_sleeper_car(131313131 , "mumbai" , "panji" , 10 , 10 , "none", route_north) ;
        s5.name = "uttar express" ;
         s6 = add_sleeper_car(141414141 , "mumbai" , "panji" , 10 , 10 , "none", route_west) ;
        s6.name = "paschim express" ;
         s7 = add_sleeper_car(151515151 , "mumbai" , "panji" , 10 , 10 , "none", route_south) ;
        s7.name = "dakshind express" ;

        passenger_loader(s4);
        passenger_loader(s3);
        passenger_loader(s2);
        passenger_loader(s1);

        Ticket_checker tc = add_tc("Ashok" , 35 , "male" , 30000 , "jodhpur" , 10);
        tc_loader() ;
        cp_loader() ;
        ci_loader() ;
    }

}
