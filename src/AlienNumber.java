import java.util.*;

public class AlienNumber {
    static ArrayList<Character> arr = new ArrayList<>();
    public static void main(String args[]) {
        //String input
        String str1 = "!@^*!";
        //ArrayList of a number to store the value of each special char.
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
        //Decimal equivalent of encoded string
        int decimal = getDecimalVal(num);
        //Stores result string
        String res = increasedNum(decimal);
        //Adding zero at the start
        if (num.get(0) == 0)
            res = '0'+res;
        //Encoding the increased number
        System.out.println(res);
        String encodedStr = encode(res);
        System.out.println(encodedStr);
    }

    public static String encode (String result) {
        String encodedStr = "";
        for (int i = 0; i < result.length(); i++)
            encodedStr += arr.get(result.charAt(i) - 48);
        return encodedStr;
    }

    public static String increasedNum(int decimal) {
        String res = "";
        //Increase the decimal value
        decimal = decimal + 1;
        while (decimal > 0) {
            int rem = decimal % 5;
            res = rem+res;
            decimal = decimal/5;
        }
        return res;
    }
    public static int getDecimalVal(ArrayList<Integer> num) {
        int decimal = 0;
        for (int i = 0; i < num.size(); i++) {
            decimal += Math.pow(5, num.size() - i - 1)*num.get(i);
        }
        return decimal;
    }
}