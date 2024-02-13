package passengers_util;

public class Passenger_S extends Passenger_A {
    static int count =0  ;
    boolean bookPlatform;
    public final String cat = "S" ;
    public Passenger_S(String email , int password ,String Name, int age, String gender, String occ, int meals, boolean platform) {
        super(email , password , Name, age, gender, occ, meals);
        this.bookPlatform = platform;
        super.mkey = 3;
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
        if (this.bookPlatform) {
            System.out.println("You have booked the platform services");
        }
        if (mkey == 3) {
            System.out.println("You are a V.VIP Passenger");
        }
    }
}
