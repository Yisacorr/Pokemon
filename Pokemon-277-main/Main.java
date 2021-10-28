

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      Scanner poke = new Scanner(System.in);
      Pokemon firstPoke = null; //user's first pokemon

      System.out.println("Prof. Oak: Hello there new trainer, what is your name? ");  
      String name = CheckInput.getString();
      System.out.println("Great to meet you, " + name + "!");
      System.out.println("Choose your first pokemon:\n1. Charmander\n2. Bulbasaur\n3. Squirtle");
      
      //selecting first pokemon
      int pokeSelec = CheckInput.getIntRange(1, 3);
        if (pokeSelec == 1 ){
          firstPoke = new Charmander();
        }
        else if (pokeSelec == 2){
          firstPoke = new Bulbasaur();
        }
        else if(pokeSelec == 3){
          firstPoke = new Squirtle();
        }

        Map m = new Map(); 
        int mapNum = 1;
        m.loadMap(mapNum);

        Trainer user = new Trainer(name, 25, firstPoke, m);
       
        int menuNumber;

        do {
        //display trainer info, inventory, and map
        System.out.println("\n" + user.toString() + "\n");
        
        menuNumber = mainMenu();
        if (user.getHp() > 0 && menuNumber != 5) {
        switch (menuNumber) {
          case 1:
            if (user.goNorth() == 'b') {
            System.out.println("You cannot go that way");
            }
            else
              m.reveal(user.getLocation());
            break;
          case 2:
            if (user.goSouth() == 'b') {
            System.out.println("You cannot go that way");
            }
            else
              m.reveal(user.getLocation());
            break;
          case 3:
            if (user.goEast() == 'b') {
            System.out.println("You cannot go that way");
            }
            else
              m.reveal(user.getLocation());
            break;
          case 4:
            if (user.goWest() == 'b') {
              System.out.println("You cannot go that way");
            }
            else
              m.reveal(user.getLocation());
        }

        //user's encounters based on what is at that loc on map
        switch(m.getCharAtLoc(user.getLocation())) {

          case 'f': //found the finish    
            System.out.println("You've found the finish... ");
            if (mapNum == 1){
              mapNum = 2;
              m.loadMap(mapNum);         
            }
            else if (mapNum == 2){
              mapNum = 3;
              m.loadMap(mapNum);
            }
            else if (mapNum == 3){
              mapNum = 1;
              m.loadMap(mapNum);
            }             
            break;

          case 'n': //nothing
            System.out.println("There's nothing here...");
            break;

          case 'i': //gain either a pokeball or potion randomly
            int rand = (int)(Math.random() * 2);
            if (rand == 0){
              System.out.println("You found a pokeball!");
              user.receivePokeball();}
            else {
              System.out.println("You found a potion!");
              user.receivePotion();}
            m.removeCharAtLoc(user.getLocation());
            break;

          case 'w': //wild pokemon appears
            Pokemon wild = chooseRandPokemon(); //generate random wild pokemon
            Scanner scan = new Scanner(System.in);
            boolean pokeNotDead = true;
            System.out.println("A wild " + wild.getName() + " appeared!");
            int battleChoice = 0;
            boolean battleDecision = true;
            while (wild.getHp() > 0 && pokeNotDead && battleDecision) { 
              int health = 0; //health of all user's pokemon
                for(int i = 0; i < user.getNumPokemon(); i++){
                  health += user.getPokemon(i).getHp();
                }
              if (health <= 0){
                  pokeNotDead = false;
                  int damn = (int)(Math.random() * 6) + 1;
                  user.takeDamage(damn);
                  System.out.println("All of your pokemon have fainted. You take " + damn + " damage from Wild " + wild.getName() + ".");
                }
              else{
                System.out.println("Wild " + wild.getName() + " HP: " + wild.getHp() + "/" + wild.getMaxHp());
              System.out.println("What would you like to do?");
              System.out.println("1. Fight\n2. Use Potion\n3. Throw Poke Ball\n4. Run away");
              battleChoice = CheckInput.getIntRange(1, 4);
                if (battleChoice == 1) { //fight pokemon
                  trainerAttack(user, wild);
                }
                else if (battleChoice == 2) { //use potion
                  if (user.hasPotion()) {
                    System.out.println("What pokemon do you want to heal?");
                    System.out.println(user.getPokemonList());
                    int pokeToHeal = CheckInput.getIntRange(1, user.getNumPokemon())-1;
                    user.usePotion(pokeToHeal);
                    System.out.println(user.getPokemon(pokeToHeal) + " has been healed");
                  }
                  else {
                    System.out.println("You ran out of Potions!");
                  }
                }
                else if (battleChoice == 3) { 
                  if (user.hasPokeball()) {
                    if(user.catchPokemon(wild)){
                      System.out.println("Tick... Tick... Tick... CLICK!\nYou caught " + wild.getName() + "!!!");
                      battleDecision = false;
                      m.removeCharAtLoc(user.getLocation());
                    }
                    else{
                      int meh = (int)(Math.random()*3) + 1;
                      if (meh == 1){
                        System.out.println("Tick... POP!!!\n" + wild.getName() + " escaped!");
                      }
                      else if(meh == 2){
                        System.out.println("Tick... Tick... POP!!!\n" + wild.getName() + " escaped!");
                      }
                      else if (meh == 3){
                        System.out.println("Tick... Tick... Tick... POP!!!\n" + wild.getName() + " escaped!");
                      }
                    }    
                  }
                  else{
                    System.out.println("You ran out of Pokeballs!");
                    }    
                }
                else if (battleChoice == 4) {
                  System.out.println("You ran away.");
                  battleDecision = false;                 
                }
              }
            } //while wild still alive && all pokemon still have hp          
            break;

          case 'p': //person
            int randScenario = (int)(Math.random() * 4);
            if (randScenario == 0) { 
              System.out.println("Random person walks up to you.\nRANDOM PERSON: Here have some money!\nYou received $15\n");
              user.receiveMoney(15);
            }
            else if (randScenario == 1) {
              //Team Rocket
              System.out.println("*Menacing music plays*\nTR: Prepare for trouble\nTR: Make it double");
              System.out.println("TR: To protect the world from devastation\nTR: To unite all peoples within our nation");
              System.out.println("TR: To denounce the evils of truth and love\nTR: To extend our reach to the stars above");
              System.out.println("TR: Jesse\nTR: James\nTR: Team Rocket blasts off at the speed of light");
              System.out.println("TR: Surrender now or prepare to fight\nMeowth: Meowth that's right!");
              System.out.println("TR: Hand over Pikachu twerp... or else");
              System.out.println(user.getName() + ": you'll never have Pikachu!! Pikachu isn't even here now!");
              System.out.println("TR: Have it your way twerp\nTeam Rocket steals some of your money!");
              user.spendMoney(5);
              System.out.println("You now have: $" + user.getMoney());
            }
            else if (randScenario == 2) {
              System.out.println("You run into your mom!\nMOM: Honey! I haven't seen you in so long!");
              System.out.println(user.getName() + ": Mom!! I told you I'm traveling to be the best Pokemon trainer! Don't worry about me!");
              System.out.println("MOM: Oh honey you can't expect me to stay home and not worry about you. Here. Take this potion");
              System.out.println(user.getName() + ": (I don't think she knows these are for Pokemon...)");
              user.receivePotion();
            }
            else if (randScenario == 3){
              System.out.println("You run into Nurse Joy.\nNURSE JOY: Oh my! A trainer! Here let me heal your pokemon!\nYour Pokemon are restored to full health.");
              user.healAllPokemon();
            }
            m.removeCharAtLoc(user.getLocation());
            break;

          case 'c': //city -> choose to go store or take pokemon to hospital
            Scanner input = new Scanner(System.in);
            System.out.println("You've entered the city\nWhere would you like to go?");
            System.out.println("1. Store\n2. PokeCenter");
            int cityChoice = CheckInput.getIntRange(1, 2);
            if (cityChoice == 1)
              store(user);
            else if (cityChoice == 2) {
              System.out.println("NURSE JOY: Hello! Welcome to the PokeCenter.\nOh no! Your pokemon seem badly injured. I'll be right back and fix them up in a jiffy!\nThere you go! Take care of your pokemon now.");
              user.healAllPokemon();
            }
            break;
        }
        }
    }while (user.getHp() > 0 && menuNumber != 5);
    if(menuNumber ==5){
      System.out.println("Thanks for playing!");
    }
    else if(user.getHp() <= 0){
      System.out.println("\n\n\nGAMEOVER. YOU ARE DEAD.\n\n\nThanks for playing!");
    }

    }

//<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<end of main>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

   /**Displays the Main Menu for the user to choose which direction they want to go or to quit the game
   * @return int of the user's selection from the Main Menu
   */
    public static int mainMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Main Menu");
        System.out.println("1. Go North\n2. Go South\n3. Go East\n4. Go West\n5. Quit");
        int menuSelect = CheckInput.getIntRange(1, 5);
        return menuSelect;
    }

   /**Generates a random Pokemon
    * @return the randomly generated pokemon
    */
    public static Pokemon chooseRandPokemon() { //generates a random pokemon
        int random = (int)((Math.random() * 6) + 1);
        Pokemon randPokemon = null;
        if (random == 1) {
            randPokemon = new Charmander();
        }
        else if (random == 2) {
            randPokemon = new Squirtle();
        }
        else if (random == 3) {
            randPokemon = new Bulbasaur();
        }
        else if (random == 4) {
            randPokemon = new Ponyta();
        }
        else if (random == 5) {
            randPokemon = new Staryu();
        }
        else if (random == 6) {
            randPokemon = new Oddish();
        }
        return randPokemon;
    }

    /**
    * the interaction between the trainer and a wild Pokemon fighting against each other
    * @param t - Trainer class the player is playing as
    * @param wild - wild Pokemon encounter
    */
    public static void trainerAttack(Trainer t, Pokemon wild) {
        System.out.println("Choose a pokemon."); 
        System.out.println(t.getPokemonList());
        boolean pokeIndex = true;
        int num;
        do{
          num = CheckInput.getIntRange(1, t.getNumPokemon()) - 1;
          if (t.getPokemon(num).getHp() <= 0){
          System.out.println("This pokemon has fainted. Choose another pokemon.");
          }
          else{
            pokeIndex = false;
          }
        }while(pokeIndex);
        System.out.println(t.getPokemon(num).getName() + ", I choose you!!!");
        System.out.println(t.getPokemon(num).getAttackMenu());
        int att = CheckInput.getIntRange(1, 2);
        if (att == 1){ //basic attack
          System.out.println(t.getPokemon(num).getBasicMenu());
          int attack = CheckInput.getIntRange(1, 3);
          if(attack >= 1 && attack <= 3){
              System.out.println(t.getPokemon(num).basicAttack(wild, attack));
            }
          }
        else if (att == 2){ //special attack
          System.out.println(t.getPokemon(num).getSpecialMenu());
          int attack = CheckInput.getIntRange(1, 3);
          if(attack >= 1 && attack <= 3){
            System.out.println(t.getPokemon(num).specialAttack(wild, attack));
            }
          }
            
        int move = (int)(Math.random()*wild.getNumAttackMenuItems()) + 1;
        if(move == 1){
          System.out.println(wild.basicAttack(t.getPokemon(num), (int)(Math.random()*wild.getNumBasicMenuItems()) + 1));
        }
        else if (move == 2){
          System.out.println(wild.specialAttack(t.getPokemon(num), (int)(Math.random()*wild.getNumSpecialMenuItems()) + 1));
        }
        if (t.getPokemon(num).getHp() <= 0)
        {
          System.out.println(t.getPokemon(num).getName() + " fainted!");
        }
        if (wild.getHp() <= 0)
        {
          System.out.println(wild.getName() + " fainted!");
        }
    }

   /**Allows the user to access the store and buy items
    * @param t user's trainer
    */
    public static void store(Trainer t) {
        boolean quit = true;       
         do {
             System.out.println("Hello! What can I help you with?");
             System.out.println("1. Buy Potion - $5 ");
             System.out.println("2. Buy Poke Ball - $3");
             System.out.println("3. Exit");
             int choice = CheckInput.getIntRange(1, 3);
             switch (choice) {
                case 1:
                  if (t.getMoney() >= 5) {
                    System.out.println("Here's your potion.");
                    t.spendMoney(5);
                    System.out.println("Your money is: " + t.getMoney());
                    t.receivePotion();
                  }
                  else 
                    System.out.println("You do not have enough money for that.");
                break;
                case 2:
                  if (t.getMoney() >= 3) {
                    System.out.println("Here's your Pokeball");
                    t.spendMoney(3);
                    System.out.println("Your money is: " + t.getMoney());
                    t.receivePokeball();
                    }
                  else
                    System.out.println("You do not have enough money for that.");
                  break;
                case 3:
                  System.out.println("Thank you, come again soon!");
                  quit = false;
                  break;
                default:
                  break;
              }
            } while (quit && t.getMoney() > 0);        
    }
}

