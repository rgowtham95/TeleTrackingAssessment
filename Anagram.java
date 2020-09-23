
import java.util.Arrays;

public class Anagram
{
   // input: {"ani", "ina", "Gowtham", "Gowthma", "Hi"}
   // output: {"ani", "Gowtham", "Hi"}
/*
array1: {"ani"}
array2: {"ain"}
 */

    public static String[] anagramOutput(String[] input)
    {
        String [] output = new String[input.length];
        for(int i = 0; i < input.length; i++)
        {
           for(int j = i + 1; j < input.length; j++)
           {
               if (checkAnagram(input[i], input[j]))
               {
                   output[i] = input[i];
               }
           }
        }


        output = Arrays.stream(output)
                .filter(s -> (s != null && s.length() > 0))
                .toArray(String[]::new);
        for (int k = 0; k < output.length; k++)
        {
            System.out.println(output[k]);
        }
        return output;
    }

    public static boolean checkAnagram(String str1, String str2)
    {
        if (str1.length() != str2.length())
        {
            return false;
        }

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        char[] str1Arr = str1.toCharArray();
        char[] str2Arr = str2.toCharArray();

        Arrays.sort(str1Arr);
        Arrays.sort(str2Arr);

        return Arrays.equals(str1Arr, str2Arr);

    }




    public static void main (String[] args)
    {
        //String [] arr = {"ani", "ina", "Gowtham", "Gowthma", "HI"};

        System.out.println(checkAnagram("gowtham", "gowtham"));
        String [] input = {"ani", "ina", "Gowtham", "Gowthma", "Hi"};
        anagramOutput(input);
    }

}
