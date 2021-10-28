/**
* creates the object Bulbasaur
*/

class Bulbasaur extends Pokemon implements Grass_Interface{

    /** 
    * constructor for the Pokemon Bulbsaur
    */
    public Bulbasaur(){
        super("Bulbasaur");
    }

    /** 
    * returns the String of special menu
    * @return specialMenu - String of the special menu
    */
    public String getSpecialMenu() {
        return specialMenu;
    }

    /** 
    * returns the int number of special menu items
    * @return 3 - returns and int representing the number of special menu items
    */
    public int getNumSpecialMenuItems() {
        return 3;
    }
    /** 
    * executes a special attack and returns a String of the fight interaction
    * @param p - the Pokemon being damaged
    * @param move - an int index of the attack move
    * @return String of Fighting interaction
    */
    public String specialAttack(Pokemon p, int move) {
        if (move == 1){
            // return p.getName() + " used Vine Whip!";
            return vineWhip(p);
        }
        else if(move == 2){
            // return p.getName() + " used Razor Leaf!";
            return razorLeaf(p);
        }
        else if(move == 3){
            // return p.getName() + " used Solar Beam!";
            return solarBeam(p);
        }
        return p.getName() + " missed!";
    }

    /** 
    * executes the attack Vinewhip and damages the Pokemon p
    * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    public String vineWhip(Pokemon p) {
        String atk = "";
        if (p.getType() == 0)
        {
            int d = (int) (((int) (Math.random() * 3) + 1) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " is SMACKED by VINEWHIP and takes " + d + " damage.";
        }
        else if (p.getType() == 1)
        {
            int d = (int)(((int)(Math.random() * 3) + 1) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " is SMACKED by VINEWHIP and takes " + d + " damage.";
        }
        else if (p.getType() == 2)
        {
            int d = (int)(((int)(Math.random() * 3) + 1) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " is SMACKED by VINEWHIP and takes " + d + " damage.";
        }
        return atk;
    }

    /** 
    * executes the attack Razor Leaf and damages the Pokemon p
   * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    public String razorLeaf(Pokemon p) {
        String atk = "";
        if (p.getType() == 0)
        {
            int d = (int)((int)(Math.random() * 3) + 2 * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " gets HIT by RAZOR LEAF and takes " + d + " damage.";
        }
        else if (p.getType() == 1)
        {
            int d = (int)((int)(Math.random() * 3) + 2 * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " gets HIT by RAZOR LEAF and takes " + d + " damage.";
        }
        else if (p.getType() == 2)
        {
            int d = (int)((int)(Math.random() * 3) + 2 * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " gets HIT by RAZOR LEAF and takes " + d + " damage.";
        }
        return atk;
    }

    /** executes the attack Solar Beam and damages the Pokemon p
    * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    public String solarBeam(Pokemon p) {
        String atk = "";
        if (p.getType() == 0)
        {
            int d = (int)((int)(Math.random() * 6) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        else if (p.getType() == 1)
        {
            int d = (int)((int)(Math.random() * 6) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        else if (p.getType() == 2)
        {
            int d = (int)((int)(Math.random() * 6) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        return atk;
    }
}
