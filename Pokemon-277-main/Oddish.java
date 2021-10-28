/**
* creates the object Oddish
*/

class Oddish extends Pokemon implements Grass_Interface{

    /** 
    * constructor for the Pokemon Oddish
    */
    public Oddish(){
        super("Oddish");
    }

    /** 
    * returns the String of special menu
    * @return String specialMenu
    */
    public String getSpecialMenu() {
        return specialMenu;
    }

    /** 
    * returns the int number of special menu items
    * @return int 3
    */
    public int getNumSpecialMenuItems() {
        return 3;
    }

    /** 
    * executes a special attack and returns a String of the fight interaction
    * @param p  Pokemon
    * @param move  attack move
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
    * @param p  Pokemon
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
    * @param p Pokemon
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
    * @param p Pokemon
    * @return String of fight interaction
    */
    public String solarBeam(Pokemon p) {
        String atk = "";
        if (p.getType() == 0)
        {
            int d = (int)((int)(Math.random() * 4) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        else if (p.getType() == 1)
        {
            int d = (int)((int)(Math.random() * 4) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        else if (p.getType() == 2)
        {
            int d = (int)((int)(Math.random() * 4) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED by SOLAR BEAM and takes " + d + " damage.";
        }
        return atk;
    }
}
