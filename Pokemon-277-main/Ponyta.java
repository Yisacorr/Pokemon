public class Ponyta extends Pokemon implements Fire_Interface{
    /**
    * Ponyta constructor
    */
    public Ponyta() {
        super("Ponyta");
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
    * @return 3 - returns an int representing the number of special menu items
    */
    public int getNumSpecialMenuItems() {
        return 3;
    }

   /** executes Ponyta special attack and returns a String of the fight interaction
    * @param p Pokemon
    * @param move attack move
    * @return the fight interaction as a string
    */
    public String specialAttack(Pokemon p, int move) {
        if (move == 1) {
            //return p.getName() + " used Ember!";
            return ember(p);
        }

        else if (move == 2) {
            //return p.getName() + " used Fire Blast!";
            return fireBlast(p);
        }

        else if (move == 3) {
            //return p.getName() + " used Fire Punch!";
            return firePunch(p);
        }
        return p.getName() + " missed!";
    }

    /** 
    * executes the attack Ember and damages the Pokemon p
    * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    @Override
    public String ember(Pokemon p) {
        String atk = "";
        if (p.getType() == 0) {
            int d = (int)((int)(Math.random() * 5) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED with EMBER and takes " + d + " damage.";
        }
        else if (p.getType() == 1) {
            int d = (int)((int)(Math.random() * 5) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED with EMBER and takes " + d + " damage.";
        }
        else if (p.getType() == 2) {
            int d = (int)((int)(Math.random() * 5) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " gets BLASTED with EMBER and takes " + d + " damage.";
        }
        return atk;
    }
    
    /** 
    * executes the attack Fire Blast and damages the Pokemon p
    * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    @Override
    public String fireBlast(Pokemon p) {
        String atk = "";
        if (p.getType() == 0) {
            int d = (int)((int)((Math.random() * 4) + 2) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " is HIT with FIRE BLAST and takes " + d + " damage.";
        }
        else if (p.getType() == 1) {
            int d = (int)((int)((Math.random() * 4) + 2) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " is HIT with FIRE BLAST and takes " + d + " damage.";
        }
        else if (p.getType() == 2) {
            int d = (int)((int)((Math.random() * 4) + 2) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " is HIT with FIRE BLAST and takes " + d + " damage.";
        }
        return atk;
    }

    /** 
    * executes the attack Fire Punch and damages the Pokemon p
    * @param p - the Pokemon being damaged
    * @return String of fight interaction
    */
    @Override
    public String firePunch(Pokemon p) {
        String atk = "";
        if (p.getType() == 0) {
            int d = (int)((int)((Math.random() * 4) + 1) * battleTable[getType()][0]);
            p.takeDamage(d);
            atk = p.getName() + " gets KNOCKED by FIRE PUNCH and takes " + d + " damage.";
        }
        else if (p.getType() == 1) {
            int d = (int)((int)((Math.random() * 4) + 1) * battleTable[getType()][1]);
            p.takeDamage(d);
            atk = p.getName() + " gets KNOCKED by FIRE PUNCH and takes " + d + " damage.";
        }
        else if (p.getType() == 2) {
            int d = (int)((int)((Math.random() * 4) + 1) * battleTable[getType()][2]);
            p.takeDamage(d);
            atk = p.getName() + " gets KNOCKED by FIRE PUNCH and takes " + d + " damage.";
        }
        return atk;
    }
}