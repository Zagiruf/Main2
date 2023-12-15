
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("введи выражение");
        String s = scanner.nextLine();
        System.out.println(calc(s));

    }


    public static String calc(String input) {
        String[] data = null;
        String znak = null;
        int vernut =0;
        String rimStr = null;
        String strVernut = null;
        int num1;
        int num2;
        String rom = null;
        input = input.replaceAll("\\s", "");


        if (input.contains("-")) {
            data = input.split("-");
            znak = "-";
        } else if (input.contains("+")) {
            data = input.split("\\+");
            znak = "+";
        } else if (input.contains("*")) {
            data = input.split("\\*");
            znak = "*";
        } else if (input.contains("/")) {
            data = input.split("\\/");
            znak = "/";
        }
        if(data.length>2 ){
            throw new UnsupportedOperationException();
        }
        if (Roman.toRoman(data[0]) && Roman.toRoman(data[1])) {
            num1 = Roman.toArabicConverter(data[0]);
            num2 = Roman.toArabicConverter(data[1]);
            rom = "true";
        } else if (!Roman.toRoman(data[0]) && !Roman.toRoman(data[1])) {
            num1 =Integer.parseInt(data[0]);
            num2 = Integer.parseInt(data[1]);
            rom = "false";
        }else {
            throw new UnsupportedOperationException();
        }
        if (num1 < 1 || num2 < 1 || num1 > 10 || num2 > 10) {
            throw new UnsupportedOperationException();
        }
        if (!"+-*\\/".contains(znak)) {
            throw new IllegalArgumentException();
        }


            if (znak.equals("-")) {
                vernut = num1-num2;

            } else if (znak.equals("+")) {
                vernut = num1+num2;

            } else if (znak.equals("*")) {
                vernut = num1 * num2;

            } else if (znak.equals("/")) {
                vernut = num1 / num2;

            }
            if(rom.equals("true") && !(vernut<0)){
                strVernut =Roman.toRomanConverter(vernut);
            }
        if (rom.equals("true") && vernut < 0) {
            throw new UnsupportedOperationException("нельзя возвращать отрицательный результат.");
            }else if(rom.equals("false")){

            strVernut = String.valueOf(vernut);
            }



        return strVernut;
    }

}
    class Roman{
    static String[] romanArray = new String[]{"0","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                                       "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX",
                                       "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII",
                                       "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
                                       "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII",
                                       "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
                                       "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

   static boolean toRoman(String val){
       for(int i=0;i<romanArray.length;i++){
           if(val.equals(romanArray[i])) {
               return true;
           }

       }
       return false;
   }
    static int toArabicConverter(String roman){
              for(int i=0;i<romanArray.length;i++){
                  if(roman.equals(romanArray[i])){
                      return i;
                  }
              }
              return -1;
     }
     static String toRomanConverter(int arabian){
                 return romanArray[arabian];
        }
    }







