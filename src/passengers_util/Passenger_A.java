package passengers_util;

public class Passenger_A extends Passenger_B {
    public static int count= 0;
    public int meals;
    public boolean ac;
    public Bedding bedding = new Bedding();
    public boolean amenities = false;
    public final String cat = "A" ;

    public Passenger_A(String email , int password ,String Name, int age, String gender, String occ, int meals) {
        super(email , password , Name, age, gender, occ );
            this.meals = meals;
            this.amenities = true;
            this.ac = true;
            bedding.bedSheets = true;
            bedding.pillow = true;
            bedding.towels = true;
            bedding.curtains = true;
        super.mkey = 2;
        count++ ;
    }

    public String getcat()
    {
        return cat  ;
    }
    void showDetails() {
        System.out.println("Name: " + this.Name);
        System.out.println("Age: " + this.age);
        System.out.println("Number of meals selected: " + this.meals);
        System.out.println("Selected Bedding items:");
        if (bedding.bedSheets) {
            System.out.println("Bedsheets");
        }
        if (bedding.pillow) {
            System.out.println("Pillow");
        }
        if (bedding.towels) {
            System.out.println("Towel");
        }
        if (bedding.curtains) {
            System.out.println("Curtains/Dividers");
        }
        if (mkey == 2) {
            System.out.println("You are a VIP Passenger");
        }
    }
}
