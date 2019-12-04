import javax.xml.namespace.QName;

class DayFour {

    public boolean hasDoubles(int num) {
        boolean flag = false;
        int digit = 99;
      
        while (num != 0) {
            
            if (digit == num%10) flag = true;
            digit = num%10;

            num = num/10;
       }

       return flag;

    }

    public boolean allDigitsIncrease(int num){

        int digit = Integer.MAX_VALUE;

        while (num != 0) {

            if (digit < num%10) return false;
            digit = num%10;
            num = num/10;

        }

        return true;

    }

    public int solution(){

        int res = 0;
        for (int i=134564; i<=585159; i++) {

            if (i /10 == 0) break;
            
            if (hasDoubles(i) && allDigitsIncrease(i)) res++;

        }

        return res;


    }




    public static void main(String[] args){

        DayFour dayFour = new DayFour();

        //dayFour.hasDoubles(12345567);

        System.out.println(dayFour.solution());

    }



}