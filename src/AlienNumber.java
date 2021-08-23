import java.util.*;

public class AlienNumber {
    public static void main(String args[]) {
        //String input
        String str1 = "!@^*!";
        //ArrayList of a number to store the value of each special char.
        ArrayList<Character> arr = new ArrayList<>();
        arr.add('!');
        arr.add('@');
        arr.add('^');
        arr.add('&');
        arr.add('*');
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            num.add(arr.indexOf(str1.charAt(i)));
        }
        System.out.println(num);
        //Stores result string
        String res = "";
        //Decimal equivalent of encoded string
        int decimal = 0;
        for (int i = 0; i < num.size(); i++) {
            decimal += Math.pow(5, num.size() - i - 1)*num.get(i);
        }
        System.out.println(decimal);
        decimal = decimal + 1;
        while (decimal > 0) {
            int rem = decimal % 5;
            res = rem+res;
            decimal = decimal/5;
        }
        if (num.get(0) == 0)
            res = '0'+res;
        String encodedStr = "";
        for (int i = 0; i < res.length(); i++)
            encodedStr += arr.get(res.charAt(i) - 48);
        System.out.println(res);
        System.out.println(encodedStr);
    }
}