import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AlienNumber {
    //ArrayList of a number to store the value of each special char.
    static ArrayList<Character> mapChar = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        //String input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the base of alien number system:");
        int base = Integer.parseInt(br.readLine());
        System.out.println("Enter the characters in the alien number system:");
        String chars[] = br.readLine().split(" ");
        for (String ch : chars)
            mapChar.add(ch.charAt(0));
        String str = br.readLine();
        succ_alien(str, base);
    }

    public static void succ_alien(String str1, Integer base) {
        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 0; i < str1.length(); i++) {
            number.add(mapChar.indexOf(str1.charAt(i)));
        }
        int decimal = getDecimalVal(number, base);
        String res = increasedNum(decimal, base);
        //Considering leading zeros
        int j = 0;
        for (int i = 0; i < number.size(); i++) {
            if (number.get(i) == 0)
                res = '0'+res;
            else
                break;
            j++;
        }
        if (j == number.size())
            res = res.substring(1);
        String encodedStr = encode(res);
        System.out.println(encodedStr);
    }

    //Encoding the increased number
    public static String encode (String result) {
        String encodedStr = "";
        for (int i = 0; i < result.length(); i++)
            encodedStr += mapChar.get(result.charAt(i) - 48);
        return encodedStr;
    }

    //Returns result string
    public static String increasedNum(int decimal, int base) {
        String res = "";
        //Increase the decimal value
        decimal = decimal + 1;
        while (decimal > 0) {
            int rem = decimal % base;
            res = rem + res;
            decimal = decimal / base;
        }
        return res;
    }

    //Decimal equivalent of encoded string
    public static int getDecimalVal(ArrayList<Integer> num, int base) {
        int decimal = 0;
        for (int i = 0; i < num.size(); i++) {
            decimal += Math.pow(base, num.size() - i - 1)*num.get(i);
        }
        return decimal;
    }
}