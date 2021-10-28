/**
* Pokemon class
*/

public abstract class Pokemon extends Entity{

    /**
    * a list of lists retaining the fight interaction between types
    */
     static final double [][] battleTable = {{1, .5, 2}, {2, 1, .5}, {.5, 2, 1}};
  
    /**
    * constructor class creating Pokemon instance with the name n
    * @param n String
    */
      public Pokemon(String n){
          super(n, 20 + (int)(Math.random() * 7));
      }
    
    /**
    * abstract class for other classes to override
    */
      public abstract String getSpecialMenu();
  
    /**
    * abstract class for other classes to override
    */
      public abstract int getNumSpecialMenuItems();
  
    /**
    * abstract class for other classes to override
    * @param p - the Pokemon that is being damaged
    * @param move - the index of what move will be used
    */
      public abstract String specialAttack(Pokemon p, int move);
  
    /**
    * returns a String of the basic attack menu
    * @return the list of basic attacks that can be used
    */
      public String getBasicMenu(){ 
          return "1. Slam\n2. Tackle\n3. Punch";
      }
  
    /**
    * returns an int of the basic attack menu items
    * @return the int 3
    */
      public int getNumBasicMenuItems(){
          return 3;
      }
  
      /** 
      * executes a basic attack and returns a String of the fight interaction
      * @param p - the Pokemon being damaged
      * @param move - an int index of the attack move
      * @return String of Fighting interaction
      */
      public String basicAttack(Pokemon p, int move){ 
          if (move == 1){
              return slam(p);
          }
          else if(move == 2){
              return tackle(p);
          }
          else if(move == 3){
              return punch(p);
          }
          return "MISSED";
      }
  
    /**
    * returns a String of the attack menu options
    * @return the list of basic attacks that can be used
    */
      public String getAttackMenu(){
          return "1. Basic Attack\n2. Special Attack";
      }
  
    /**
    * returns an int of the number of attack menu items
    * @return the int 2
    */
      public int getNumAttackMenuItems(){
          return 2;
      }
  
      /** 
      * executes the attack Slam and damages the Pokemon p
      * @param p - the Pokemon being damaged
      * @return String of fight interaction
      */
      public String slam(Pokemon p){
          int d = (int)(Math.random() * 5);
          p.takeDamage(d);
          return p.getName() + " gets SLAMMED by " + this.getName() + " and takes " + d + " damage.";
      }
  
      /** 
      * executes the attack Tackle and damages the Pokemon p
      * @param p - the Pokemon being damaged
      * @return String of fight interaction
      */
      public String tackle(Pokemon p){
          int d = (int)(Math.random() * 2) + 1;
          p.takeDamage(d);
          return p.getName() + " gets TACKLED by " + this.getName() + " and takes " + d + " damage.";
      }
  
      /** 
      * executes the attack Punch and damages the Pokemon p
      * @param p - the Pokemon being damaged
      * @return String of fight interaction
      */
      public String punch(Pokemon p){
          int d = (int)(Math.random() * 3) + 1;
          p.takeDamage(d);
          return p.getName() + " gets PUNCHED by " + this.getName() + " and takes " + d + " damage.";
      }
  
      /** 
      * returns a number value of the typing of the Pokemon
      * @return an int of the type of Pokemon
      */
      public int getType(){
          int type = 0;
          if (this instanceof Fire_Interface){
              type = 0;
          }
          else if (this instanceof Water_Interface){
              type = 1;
          }
          else if(this instanceof Grass_Interface){
              type = 2;
          }
          return type;
      }
  
  }
  