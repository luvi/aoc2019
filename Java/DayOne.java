import java.io.*;
import java.util.Scanner;

class DayOne {


    public int helper(int num) {

        return (num > 0) ? num + helper((num / 3) - 2) : 0;

    }

    public int sumWeights() throws IOException {

        int result = 0;

        String filename = "Java/day1Input.txt";
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

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