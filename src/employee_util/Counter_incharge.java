package employee_util;
import committie_util.* ;

public class Counter_incharge extends Finance
{

    private final int counter_number ;
    private final int hourly_shift ;
    public final String sub_role = "Counter incharge" ;
    public static int count =0 ;
    public Boolean availibility ;


    public Counter_incharge(String name, int age, String sex, int salary, int counter_number, int hourly_shift) {
        super(name, age, sex,  salary);
        this.counter_number = counter_number;
        this.hourly_shift = hourly_shift;
        Finance_manager.subordinates.add(this) ;
        count++ ;
    }
    @Override
    public boolean isAvilable(String date) {
        if(!avilable.containsKey(date)){avilable.put(date , true) ; }
        return avilable.get(date);
    }
    @Override
    public void add_work(String date)
    {
        avilable.put(date , false) ;
    }

    @Override
    public void show_detail()
    {
        System.out.println("following are the details : ");
        System.out.println("Name : " + name );
        System.out.println("role : " + role);
        System.out.println("salary : " + salary );
        System.out.println("counter : " + counter_number);
        System.out.println("your shift : " + hourly_shift);

    }
}
