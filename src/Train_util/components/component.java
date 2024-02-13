package Train_util.components;

public interface component extends Engine , Energy , Brakes , Body
{
  String display_id() ;
}

interface Energy
{
   String energy() ;
   void change_energy(String energy) ;
}
interface Brakes
{
   int brake_power() ;
   void increase_power() ;
   void show_break() ;
}
interface Body
{
    void display_body_type() ;
}
