import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class DayTwo{

	public int computer(int noun, int verb) throws IOException{

        StringBuilder builder = new StringBuilder();

        //scan file
        String filename = "Java/day2Input.txt";
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) { 
            
            builder.append(inputFile.nextLine()); 

        }
        inputFile.close();

        String[] arr = builder.toString().split(",");
        int[] integerInput = new int[arr.length];
        
        for (int i=0; i<integerInput.length; i++){

            integerInput[i] = Integer.parseInt(arr[i]); 
        }
        
        //Replace position 1 with noun and position 2 with verb
        integerInput[1] = noun; 
        integerInput[2] = verb;
		
		for (int i=0; i<integerInput.length ; i+=4) {

		    if(integerInput[i] == 99) break;	

            if (integerInput[i] == 1) integerInput[integerInput[i+3]] = integerInput[integerInput[i+1]] + integerInput[integerInput[i+2]];
             else if (integerInput[i] == 2) integerInput[integerInput[i+3]] = integerInput[integerInput[i+1]] * integerInput[integerInput[i+2]];
            
		}

		return integerInput[0];
		

	}

	public static void main(String[] args){
	
    DayTwo dayTwo = new DayTwo();
    
    try {

       for (int i=0; i<100; i++){
           for (int j=0; j<100; j++){

                if(dayTwo.computer(i, j) == 19690720) {
                    
                    System.out.println("noun is "+ i + " verb is "+j+ " answer is "+ (100 * i + j));
                }

           }
        }

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }

	}

}

