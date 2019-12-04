import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class DayThree{

    int[][] graph = new int[1500][1500];
    int[] origin1 = {0,0};
    int[] origin2 = {0,0};
    HashMap<Integer,HashSet<Integer>> myMap = new HashMap<>();
    ArrayList<int[]> collisions = new ArrayList<>();
    int min = Integer.MAX_VALUE;

	public int crossedWires() throws IOException{

        List<String> wiresInput = new ArrayList<>();
        
        //scan file
        String filename = "Java/day3Input.txt";
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) { 
            
            wiresInput.add(inputFile.nextLine()); 

        }
        inputFile.close();

        String[] wire1Dirs = wiresInput.get(0).split(",");
        String[] wire2Dirs = wiresInput.get(1).split(",");

        //plot paths of wire1 
        for (String dir : wire1Dirs) {

            markPathFrom(origin1, dir.charAt(0), Integer.parseInt(dir.substring(1,dir.length())), 1);
            //System.out.println("origin1 is now" + Arrays.toString(origin1));
        
        }


        //plot paths of wire2
        for (String dir : wire2Dirs) {

            markPathFrom(origin2, dir.charAt(0), Integer.parseInt(dir.substring(1,dir.length())), 2);
            //System.out.println("origin2 is now" + Arrays.toString(origin2));

        }

    
            //after this is should have all the collisions. return closest one.

            for (int[] collisionCoord : collisions){

                min = Math.min(min, Math.abs(collisionCoord[0]) + Math.abs(collisionCoord[1]));

            }


            return min;
       
     

    }
    
    public void markPathFrom(int[] origin, char direction, int steps, int wireNo) {

        // tracks paths in graph using the number 1 for wire 1, number 2 for wire 2
        // if i am wire 1 and i see a 2 , change plot to number 3
        // likewise if i am wire 2 and i see 1 , change plot to number 3

       // int[] L = {-1,0};
       // int[] R = {1,0};
      // int[] U = {0,1};
      //  int[] D = {0,-1};

        int index = 0;
       

        //L = 0, R = 1 , U = 2 , D = 3
        int[] dx= {-1,1,0,0};  
        int[] dy= {0,0,1,-1};

        if (direction == 'L') index = 0;
        if (direction == 'R') index = 1;
        if (direction == 'U') index = 2;
        if (direction == 'D') index = 3;

        int stoppingPointX = dx[index] * steps + origin[0];
        int stoppingPointY = dy[index] * steps + origin[1];
        int[] stoppingPoint = {stoppingPointX , stoppingPointY};

        for (int i=1; i<=steps; i++){ 

            int newX = (dx[index])*i + origin[0];
            int newY = (dy[index])*i + origin[1];

            if (wireNo == 1){
        
        
            if (myMap.get(newX) == null) {

                HashSet<Integer> temp = new HashSet<>();
                temp.add(newY);
                myMap.put(newX, temp);

            } else {

                HashSet<Integer> temp = myMap.get(newX);
                temp.add(newY);
                myMap.put(newX,temp);

            }

        } else { //means we are tracking through wire2

            if(myMap.get(newX) != null) { // if x coord has been seen before by wire1 O(1)

                HashSet<Integer> seenYCoords = myMap.get(newX);  //then grab the hashset of matching Ys O(1)
                if ( seenYCoords.contains(newY)) {  //check if y was also seen before O(1)
                    int[] temp = {newX,newY};
                    collisions.add(temp);
                };
            }

        }

        }

        if(wireNo == 1) origin1 = stoppingPoint; // return the new origin point after tracing path.
        if(wireNo == 2) origin2 = stoppingPoint;

    }


	public static void main(String[] args){
	
    DayThree dayThree = new DayThree();
    
    try {
        System.out.println(dayThree.crossedWires());

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

	}

}

