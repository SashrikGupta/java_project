package employee_util;

import committie_util.Station_manager;

public class Ticket_checker extends Station
{

    private final String station ;
    private final int hourly_shift ;
    public final String sub_role = "Ticket checker" ;
    public static int count =0 ;



    public Ticket_checker(String name, int age, String sex, int salary, String station, int hourly_shift) {
        super(name, age, sex,  salary);
        this.station = station;
        this.hourly_shift = hourly_shift;
        Station_manager.subordinates1.add(this) ;
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
        System.out.println("station  : " + station);
        System.out.println("your shift : " + hourly_shift);

    }
}
