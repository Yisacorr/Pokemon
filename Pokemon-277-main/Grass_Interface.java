

public interface Grass_Interface {

    public String specialMenu = "1. Vinewhip\n2. Razor Leaf\n3. Solar Beam";
    public int numSpecialMenuItems = 3;
    
    /**
    * method that need to be overriden by Pokemon with a grass typing
    * @param p - Pokemon being damaged
    */
    public String vineWhip(Pokemon p);

    /**
    * method that need to be overriden by Pokemon with a grass typing
    * @param p - Pokemon being damaged
    */
    public String razorLeaf(Pokemon p);

    /**
    * method that need to be overriden by Pokemon with a grass typing
    * @param p - Pokemon being damaged
    */
    public String solarBeam(Pokemon p);
}
