package operations_util;
import Train_util.body.Train;
import employee_util.* ;
import java.util.* ;
import java.util.ArrayList;


public class operations
{
    public static ArrayList<Basic_Employee> employeelist = new ArrayList<Basic_Employee>() ;
    public static ArrayList<Train> trainlist = new ArrayList<Train>() ;
    public static List<String> route_west = new ArrayList<>(List.of("MUMBAI", "PUNE", "AHMEDABAD", "SURAT", "VADODARA", "JAIPUR", "UDAIPUR", "JODHPUR", "NAGPUR", "PANAJI"));
    public static List<String> route_north = new ArrayList<>(List.of("DELHI", "CHANDIGARH", "AMRITSAR", "LUCKNOW", "JAIPUR", "SHIMLA", "DEHRADUN", "SRINAGAR", "JAMMU", "DHARAMSALA"));
    public static List<String> route_east = new ArrayList<>(List.of("KOLKATA", "BHUBANESWAR", "PATNA", "RANCHI", "GUWAHATI", "SILIGURI", "CUTTACK", "DARJEELING", "BHOPAL", "AGARTALA"));
    public static List<String> route_south = new ArrayList<>(List.of("BENGALURU", "CHENNAI", "HYDERABAD", "KOCHI", "MYSURU", "GOA", "PUDUCHERRY", "MANGALURU", "COIMBATORE", "THIRUVANANTHAPURAM"));

}
