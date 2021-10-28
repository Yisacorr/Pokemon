/**
* Interface for Fire Pokemon
*/
public interface Fire_Interface {

    public String specialMenu = "1. Ember\n2. Fire Blast\n3. Fire Punch";
    
    public int numSpecialMenuItems = 3;
    
    /**
    * method that need to be overriden by Pokemon with a fire type
    * @param p - Pokemon being damaged
    */
    public String ember(Pokemon p);

    /**
    * method that need to be overriden by Pokemon with a fire type
    * @param p - Pokemon being damaged
    */
    public String fireBlast(Pokemon p);

    /**
    * method that need to be overriden by Pokemon with a fire type
    * @param p - Pokemon being damaged
    */
    public String firePunch(Pokemon p);
}