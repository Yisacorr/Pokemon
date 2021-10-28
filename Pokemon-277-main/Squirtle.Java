/*
* Creates the object Squirtle
*/
public class Squirtle extends Pokemon implements Water_Interface {
    /** 
    * constructor for the Pokemon Squirtle
    */
    public Squirtle(){
        super("Squirtle");
       
    }
    /** 
    * returns the String of special menu
    * @return String specialMenu
    */
    public String getSpecialMenu() {
        return "1. Water Gun\n2. Bubble Beam\n3. Waterfall";
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
        String saying = "";
        switch (move) {
            case 1:
                // saying = p.getName() + " used Water Gun!";
                saying = waterGun(p);
                break;
            case 2:
                // saying = p.getName() + " used Bubble Beam!";
                saying = bubbleBeam(p);
                break;
            case 3:
                // saying = p.getName() + " used water fall!";
                saying = waterFall(p);
                break;
            default:
                break;
        }
        return saying;
    }
    /** 
    * executes the attack WaterGun and damages the Pokemon p
    * @param p  Pokemon
    * @return String of fight interaction
    */
    @Override
    public String waterGun(Pokemon p) {
        String atk = "";
        switch (p.getType()) {
            case 0: {
                int d = (int) (((int) (Math.random() * 4) + 2) * battleTable[getType()][0]);
                p.takeDamage(d);
                atk = p.getName() + " gets SHOT by WATER GUN and takes " + d + " damage.";
                break;
            }
            case 1: {
                int d = (int) (((int) (Math.random() * 4) + 2) * battleTable[getType()][1]);
                p.takeDamage(d);
                atk = p.getName() + " gets SHOT by WATER GUN and takes " + d + " damage.";
                break;
            }
            case 2: {
                int d = (int) (((int) (Math.random() * 4) + 2) * battleTable[getType()][2]);
                p.takeDamage(d);
                atk = p.getName() + " gets SHOT by WATER GUN and takes " + d + " damage.";
                break;
            }
            default:
                break;
        }
        return atk;
    }
    /** 
    * executes the attack bubbleBeam and damages the Pokemon p
    * @param p  Pokemon
    * @return String of fight interaction
    */
    @Override
    public String bubbleBeam(Pokemon p) {
        String atk = "";
        switch (p.getType()) {
            case 0: {
                int d = (int) ((int) (Math.random() * 3) + 1 * battleTable[getType()][0]);
                p.takeDamage(d);
                atk = p.getName() + " is BLASTED with BUBBLE BEAM and takes " + d + " damage.";
                break;
            }
            case 1: {
                int d = (int) ((int) (Math.random() * 3) + 1 * battleTable[getType()][1]);
                p.takeDamage(d);
                atk = p.getName() + " is BLASTED with BUBBLE BEAM and takes " + d + " damage.";
                break;
            }
            case 2: {
                int d = (int) ((int) (Math.random() * 3) + 1 * battleTable[getType()][2]);
                p.takeDamage(d);
                atk = p.getName() + " is BLASTED with BUBBLE BEAM and takes " + d + " damage.";
                break;
            }
            default:
                break;
        }
        return atk;
    }
    /** 
    * executes the attack waterFall and damages the Pokemon p
    * @param p  Pokemon
    * @return String of fight interaction
    */
    @Override
    public String waterFall(Pokemon p) {
        String atk = "";
        switch (p.getType()) {
            case 0: {
                int d = (int) ((int) (Math.random() * 4) + 1 * battleTable[getType()][0]);
                p.takeDamage(d);
                atk = p.getName() + " gets FLUSHED with WATERFALL and takes " + d + " damage.";
                break;
            }
            case 1: {
                int d = (int) ((int) (Math.random() * 4) + 1 * battleTable[getType()][1]);
                p.takeDamage(d);
                atk = p.getName() + " gets FLUSHED with WATERFALL and takes " + d + " damage.";
                break;
            }
            case 2: {
                int d = (int) ((int) (Math.random() * 4) + 1 * battleTable[getType()][2]);
                p.takeDamage(d);
                atk = p.getName() + " gets FLUSHED with WATERFALL and takes " + d + " damage.";
                break;
            }
            default:
                break;
        }
        return atk;
    }
}
