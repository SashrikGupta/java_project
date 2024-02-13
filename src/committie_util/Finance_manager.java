package committie_util;
import employee_util.* ;
import java.util.ArrayList;

public class Finance_manager
{
    public String name  ;
    public final String share = "33%" ;
    public static ArrayList<Counter_incharge> subordinates = new ArrayList<Counter_incharge>() ;
    public Finance_manager(String name)
    {
        this.name = name;
        HEAD.juniorFM.add(this) ;
    }
}
