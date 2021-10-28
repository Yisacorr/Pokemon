/*
* Creates the class Map
*/
import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Map {

    private char[][] map;
    private boolean[][] revealed;
    

    public Map() {
        map = new char[5][5];
        revealed = new boolean[5][5];
        for (int i = 0; i < revealed.length; i++) {
            for (int j = 0; j < revealed[i].length; j++) {
                revealed[i][j] = false;
            }
        }
    }
    /**Loads the map
    * @param mapNum area number
    */
    public void loadMap(int mapNum) {
        ArrayList<ArrayList<Character>> collection = new ArrayList<>();
        
        try { 
            String area = "Area" + mapNum +".txt";
            Scanner s = new Scanner(new File(area));
            while (s.hasNextLine()) {
                String data = s.nextLine(); //reading data line by line from file
                data = data.replaceAll("\\s", ""); 
                ArrayList<Character> listOfchars = new ArrayList<>();
                ArrayList<Character> lists = new ArrayList<>();
                for (int i = 0; i < data.length(); i++) {
                    listOfchars.add(data.charAt(i));
                }
                collection.add(listOfchars);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND");
        
        }

        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map.length; col++) {
                map[row][col] = collection.get(row).get(col);
                revealed[row][col] = false;
            }
        }         
    }
    
    /**gets the character a given location 
    * @param p location point
    * @return the character at the given loc 
    */
    public char getCharAtLoc(Point p) {
        if (p.x < 0 || p.y < 0 || p.x > 4 || p.y > 4) {
            return 'b';
        }
        return map[p.x][p.y];
    }

    /**
    * @param p location point where we'll put the *(players location)
    * @return String representation of the map
    */
    public String mapToString(Point p) {
        findStart();
        int x = p.x;
        int y = p.y;

        String text = "";
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){


                if(i == x && j == y){
                    text += "* ";
                }
                else if (revealed[i][j]){
                    text += map[i][j] + " ";
                }

                else{
                    text += "x ";
                }
            }
            text += "\n";
        }
        return text;
    }
    /**Finds the starting poin
    * @return the index of the starting point 
    */
    public Point findStart() {

        Point point = new Point();
         for (int i = 0; i < map.length; i++) {
            if (map[0][i] == 's') {
                point.x = 0;
                point.y = i;
                return point;
            }

            if (map[map.length - 1][i] == 's') {
                point.x = map.length - 1;
                point.y = i;
                return point;

            }

        }
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] == 's') {
                point.x = i;
                point.y = 0;
                return point;
            }

            if (map[i][map.length - 1] == 's') {
                point.x = i;
                point.y = 0;
                return point;

            }
        }

        for (int i = 0; i < map.length - 1; i++) {
            for (int j = 0; j < map.length - 1; j++) {
                if (map[i][j] == 's') {
                    point.x = i;
                    point.y = j;
                    return point;
                }
            }
        }
       //if not found
        throw new RuntimeException("Starting Point could not be found!");
    }
    /**reveals the hidden map at the given point. 
    * @param p a point(location) where we want to revieal 
    */
    public void reveal(Point p) {

        int i = p.x;
        int j = p.y;
        if (revealed[i][j] == false) {        
              revealed[i][j] = true;
        }
    }
    /**Removes character at a location(changs it with 'n') 
    * @param p a point(location) where the character to be removed is located.
    */
    public void removeCharAtLoc(Point p) {
        map[p.x][p.y] = 'n';
    }
}

