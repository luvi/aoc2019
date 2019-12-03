import java.io.*;
import java.util.Scanner;

class DayOne {


    public int helper(int num) {

        return (num > 0) ? num + helper((num / 3) - 2) : 0;

    }

    public int sumWeights() throws IOException {

        int result = 0;

        String filename = "day1Input.txt";
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

       
        while (inputFile.hasNext()) {

            String nextLine = inputFile.nextLine();
            result += helper(Integer.parseInt(nextLine)/3 - 2); 

        }

       inputFile.close();

        return result;
        
    }

    public static void main(String[] args) {

        DayOne dayOne = new DayOne();
        try {
            System.out.println(dayOne.sumWeights());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}