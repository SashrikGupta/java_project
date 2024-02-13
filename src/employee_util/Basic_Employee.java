package employee_util;
import operations_util.* ;

import java.util.HashMap;

public abstract class Basic_Employee
{
    public String name ;
    public int age ;
    public String sex ;
    public String id ;
    public int salary ;
    public HashMap<String , Boolean> avilable = new HashMap<>();
    public static int count =0 ;

    public Basic_Employee(String name, int age, String sex,  int salary) {

        operations.employeelist.add(this) ;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.id = Integer.toString(this.hashCode());
        count++ ;
    }

    abstract boolean isAvilable(String date ) ;
    abstract void show_detail() ;
    public abstract void add_work(String Date) ;

}




abstract class Finance extends Basic_Employee
{

    public static int count ;
    public final String role = "finance" ;

    public Finance(String name, int age, String sex, int salary) {
        super(name, age, sex, salary);
        count++ ;
    }
}
abstract class Station extends Basic_Employee
{

    public static int count ;
    public final String role = "Station" ;

    public Station(String name, int age, String sex, int salary) {
        super(name, age, sex, salary);
        count++ ;
    }
}
