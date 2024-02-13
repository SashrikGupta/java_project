package Train_util.body;
import Train_util.components.component ;
import operations_util.operations;
import operations_util.operations.* ;
import java.util.* ;

public abstract class Train implements component {


                            //final area//



                            //static area//


    // the following will be an abstract class that will be inherited
    private static int count =0 ;//for counting number of trains
    //when ever a train would be called it would be incremented
    public static HashSet<Integer> set = new HashSet<Integer>();
    // static function to call static member
    static void show_count()
    {
        System.out.println("total numbers of trains in system : " + Train.count);
    }


    public String name ;                            // instance areas//
    public int pnr  = 0;
    public String start ;
    public String stop ;
    public int duration  ;


                                //abstract area//

    // following are abstract methods
      abstract int coaches() ;
      abstract void route() ;
      abstract boolean isoccupied(String Date) ;
    // to be continued


                                 //construction unit//
      Train(int pnr , String start , String stop , int duration )
    {


        this.pnr = pnr ;
        this.duration = duration ;
        this.stop = stop ;
        this.start = start ;
        count++ ;
        operations.trainlist.add(this) ;
    }

                                //exprimentation work//


}
