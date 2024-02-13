package employee_util;

import committie_util.Station_manager;

public class Chart_projector extends Station
{

    private final int counter_number ;
    private final int hourly_shift ;
    public final String sub_role = "Chart_projector" ;
    public static int count =0 ;



    public Chart_projector(String name, int age, String sex, int salary, int counter_number, int hourly_shift) {
        super(name, age, sex,  salary);
        this.counter_number = counter_number;
        this.hourly_shift = hourly_shift;
        Station_manager.subordinates2.add(this) ;
        count++ ;
    }

    public boolean isAvilable(String date) {
        if(!avilable.containsKey(date)){avilable.put(date , true) ; }
        return avilable.get(date);
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

    @Override
    public void add_work(String date)
    {
        avilable.put(date , false) ;
    }
}
