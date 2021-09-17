import java.util.ArrayList;
import java.util.List;

public class ReverseFizzBuzz {

    public static void main(String[] args) {
        // Expected output: 3 5
        String[] input1 = {"1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
                "FizzBuzz"};

        // Expected output: 1 5
        String[] input2 = {"Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz", "Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz", "Fizz",
                "Fizz", "Fizz", "Fizz", "FizzBuzz", "Fizz", "Fizz", "Fizz", "Fizz", "FizzBuzz"};

        // Expected output: 5 5 // this case seems wrong to me.
        String[] input3 = {"14", "FizzBuzz", "16", "17", "18", "19", "FizzBuzz", "21", "22", "23", "24", "FizzBuzz", "26",
                "27", "28", "29", "FizzBuzz", "31", "32", "33"};

        // Expected output: 30 9
        String[] input4 = {"1", "2", "3", "4", "5", "6", "7", "8", "Buzz", "10", "11", "12", "13", "14", "15", "16", "17",
                "Buzz", "19", "20", "21", "22", "23", "24", "25", "26", "Buzz", "28", "29", "Fizz"};

        // Expected output: 5 51
        String[] input5 = {"Fizz", "Buzz", "52", "53", "54", "Fizz", "56", "57", "58", "59", "Fizz", "61", "62", "63",
                "64", "Fizz", "66", "67", "68", "69", "Fizz"};

        evaluateMultiplierIntegers(input1);
        evaluateMultiplierIntegers(input2);
        evaluateMultiplierIntegers(input3);
        evaluateMultiplierIntegers(input4);
        evaluateMultiplierIntegers(input5);

    }

    public static void evaluateMultiplierIntegers(String[] args) {
        int fizz = 0;
        int buzz = 0;
        int fizzBuzz = 0;
        boolean fizzFound = false;
        boolean buzzFound = false;
        boolean fizzBuzzFound = false;

        for (int i = 0; i < args.length; i++) {
          // logic ,if value at index 0, 1 is same ,as in case "input2".
            if (args[0].equalsIgnoreCase(args[1])) {
                fizz = 1;
                int j = i;
                while (!args[j].equalsIgnoreCase("fizzbuzz")) {
                    j++;
                }
                buzz = j + 1;
                System.out.println("Fizz is " + fizz);
                System.out.println("Buzz is " + buzz);
                return;
            }

          // This is the case ,where the mind boggles from here and there and a good case (input5) ,a different type of fizzBuzz i would say.
          //This logic checks for string(fizz/buzz) or number.
            if(!args[0].equalsIgnoreCase("1") && args[0].equalsIgnoreCase("fizz")) {
                    List<Integer> fizzList = new ArrayList<>();
                    List<Integer> buzzList = new ArrayList<>();
                    for(int j=1; j < args.length - 1; j++) {
                        if(args[j].equalsIgnoreCase("buzz")) {
                            if((j+1 < args.length)) {
                                try {
                                    Integer elementAfterBuzz = Integer.parseInt(args[j + 1]);
                                    buzzList.add(elementAfterBuzz - 1);
                                }
                                catch (NullPointerException e) {
                                    // Ignoring String values
                                }

                            }
                        }
                        if(args[j].equalsIgnoreCase("fizz")) {
                            if((j+1 < args.length)) {
                                try {
                                    Integer elementAfterBuzz = Integer.parseInt(args[j + 1]);
                                    fizzList.add(elementAfterBuzz - 1);
                                }
                                catch (NullPointerException e) {
                                    // Ingoring String values
                                }
                            }
                        }
                    }
              // this call the method GCD which get the multiplier.
                    int finalFizz = findGCD(fizzList);
                    int finalBuzz = findGCD(buzzList);
                    System.out.println("Fizz is " + finalFizz);
                    System.out.println("Buzz is " + finalBuzz);
                    return;

            }

            // checking for fizz in the array
            if (!fizzFound && args[i].equalsIgnoreCase("fizz")) {
                fizz = i + 1;
                fizzFound = true;
                System.out.println("Fizz is " + fizz);
            }
            if (!buzzFound && args[i].equalsIgnoreCase("buzz")) {
                buzz = i + 1;
                buzzFound = true;
                System.out.println("Buzz is " + buzz);
            }
            if (!fizzBuzzFound && args[i].equalsIgnoreCase("FizzBuzz")) {
                fizzBuzz = i + 1;
                fizzBuzzFound = true;
                System.out.println("FizzBuzz is " + fizzBuzz);
            }
        }
    }

   //This method is after lot of thoughts for case "input5"  ,in which we can see fizz is there multiple times and buzz is just once , 
   //as Fizz ,coming multiple times and finding the way of multiplier ,recalled my childhood and primary maths logic of Greatest common divisor(GCD) ,
   //which i tried and found it worked. Frankly saying ,it took my around 45 minutes in morning, as i was not able to recall it on initial look.
  
    public static int findGCD(List<Integer> list)
    {
        if(list.size() > 0) {
            int result = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                result = gcd(list.get(i), result);

                if (result == 1) {
                    return 1;
                }
            }
            return result;
        }
        return 0;
    }

    public static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
