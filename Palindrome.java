public class Palindrome
{
    public static boolean isPalindrome(String str)
    {
        String reverse = "";
        //char [] characters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
        //        's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        str = str.replaceAll("[^a-zA-Z0-9]", "");


        for (int i = str.length() - 1; i >= 0; i--)
        {
                reverse += str.charAt(i);
                //System.out.println(reverse);
        }
        if (str.toLowerCase().equals(reverse.toLowerCase()))
        {
            return true;
        }
        else
            {
            return false;
        }
    }

    public static void main (String[] args)
    {
        System.out.println(isPalindrome("A man, a plan, a c---------------------anal, panam,a,"));
    }

}
