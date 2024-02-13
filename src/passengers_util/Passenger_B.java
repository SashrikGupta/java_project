package passengers_util;

public class Passenger_B {
    public static long count= 0;
    public String Name;
    public int age;
    public String gender ;
    public int category;
    public boolean doctor = false;
    public int mkey;
    public int password  ;
    public String email ;
    public String  coach;
    public String Seatno ;
    public  final String cat = "B" ;
   public  Passenger_B(String email , int password , String Name, int age, String gender, String occ) {
        count++;
        this.email = email ;
        this.password = password ;
        this.Name = Name;
        this.age = age;
        if (age <= 14) {
            this.category = 1;
        } else if (age >= 65) {
            this.category = 3;
        } else {
            this.category = 2;
        }
        gender = gender.toLowerCase();
        this.gender = gender ;
        occ = occ.toLowerCase();
        if (occ.equals("doctor")) {
            this.doctor = true;
        }
        mkey = 1;
    }
    public String getcat()
    {
        return cat  ;
    }
    void showDetails() {
        System.out.println("Name: " + this.Name);
        System.out.println("Age: " + this.age);
        if (mkey == 1) {
            System.out.println("Travelling in: Economy class");
        }
    }
}

