import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//        String inputStr = input.nextLine();
//        char strChars[] = inputStr.toCharArray();
        Enigma enigma = new Enigma();
        System.out.print("Please Enter the PlugBoard : ");
        String plugBoardStr =input.nextLine();
        enigma.PlugBoard(plugBoardStr);
//        for (char c:strChars) {
////            System.out.println(c);
//            System.out.println(enigma.EnigmaFindEncrypt(c));
//
//        }
    }
}


class Enigma{

    Map<Character, Character> PlugBoard = new HashMap<>();

    public void PlugBoard(String plugBoardStr){
        String arrayplugBoardStr[] =  plugBoardStr.split(",");
        System.out.println(Arrays.toString(arrayplugBoardStr));
        for (int i = 0; i < arrayplugBoardStr.length; i++) {
            PlugBoard.put(arrayplugBoardStr[i].charAt(0),arrayplugBoardStr[i].charAt(1));
        }
        System.out.println(PlugBoard);

    }

    public char EnigmaFindEncrypt(char c){

        return 'a';
    }

}