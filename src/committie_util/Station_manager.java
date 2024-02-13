package committie_util;
import employee_util.Chart_projector;
import employee_util.Counter_incharge;
import employee_util.Ticket_checker;

import java.util.ArrayList;

public class Station_manager
{
    public String name  ;
    public final String share = "63%" ;
    public static ArrayList<Ticket_checker> subordinates1 = new ArrayList<Ticket_checker>() ;
    public static ArrayList<Chart_projector> subordinates2 = new ArrayList<Chart_projector>() ;
    public Station_manager(String name)
    {
        this.name = name;
        HEAD.juniorSM.add(this) ;
    }
}
