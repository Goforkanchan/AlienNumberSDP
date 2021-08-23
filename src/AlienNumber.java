import java.util.*;

public class AlienNumber {
    //ArrayList of a number to store the value of each special char.
    static ArrayList<Character> arr = new ArrayList<>();
    public static void main(String args[]) {
        //String input
        String str1 = "!@^*!";
        String str2 = "!!!";
        String str3 = "^!@*!";
        String str4 = "@@@!!!!";
        String str5 = "!!!@@";
        arr.add('!');
        arr.add('@');
        arr.add('^');
        arr.add('&');
        arr.add('*');
        succ_alien(str1);
        succ_alien(str2);
        succ_alien(str3);
        succ_alien(str4);
        succ_alien(str5);
    }

    public static void succ_alien(String str1) {
        ArrayList<Integer> num = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            num.add(arr.indexOf(str1.charAt(i)));
        }
        System.out.println(num);
        int decimal = getDecimalVal(num);
        String res = increasedNum(decimal);

        //Considering leading zeros
        int j = 0;
        for (int i = 0; i < num.size(); i++) {
            if (num.get(i) == 0)
                res = '0'+res;
            else
                break;
            j++;
        }
        if (j == num.size())
            res = res.substring(1);
        System.out.println(res);
        String encodedStr = encode(res);
        System.out.println(encodedStr);
    }

    //Encoding the increased number
    public static String encode (String result) {
        String encodedStr = "";
        for (int i = 0; i < result.length(); i++)
            encodedStr += arr.get(result.charAt(i) - 48);
        return encodedStr;
    }

    //Returns result string
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

    //Decimal equivalent of encoded string
    public static int getDecimalVal(ArrayList<Integer> num) {
        int decimal = 0;
        for (int i = 0; i < num.size(); i++) {
            decimal += Math.pow(5, num.size() - i - 1)*num.get(i);
        }
        return decimal;
    }
}