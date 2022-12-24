import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Enigma enigma = new Enigma();

        System.out.print("  - Please Enter the PlugBoard Like (AF,BM,GH,JC,XE,OP,NR,ZL) : ");
        String plugBoardStr =input.nextLine();
        System.out.println();
        enigma.PlugBoard(plugBoardStr);
        System.out.println();

        System.out.print("  - Please Enter the Rotator1 Like (LUWJHIKDYCAXMNQBZTRFGESVPO) : ");
        String rotate1Str =input.nextLine();
        System.out.println();
        enigma.Rotator1(rotate1Str);
        System.out.println();

        System.out.print("  - Please Enter the Rotator2 Like (QNGHSZAFEBJRLUCTXYIMPDWKOV) : ");
        String rotate2Str =input.nextLine();
        System.out.println();
        enigma.Rotator2(rotate2Str);
        System.out.println();

        System.out.print("  - Please Enter the Rotator3 Like (CMFQSBHIOAKRTENZLDYWUGPJXV) : ");
        String rotate3Str =input.nextLine();
        System.out.println();
        enigma.Rotator3(rotate3Str);
        System.out.println();


        System.out.print(" *****   Please Enter the Encrypted String Code : ");
        String inputStr = input.nextLine();
        char strChars[] = inputStr.toCharArray();
        for (char c:strChars) {
            System.out.println(enigma.EnigmaFindEncrypt(c));
        }
    }
}


class Enigma{

    int nRotate1 = 0; // (nRotate1+1)%26
    int nRotate2 = 0;
    int nRotate3 = 0;


    Map<Character, Character> PlugBoard = new HashMap<>();
    Map<Character, Character> Rotator1 = new HashMap<>();
    Map<Character, Character> Rotator2 = new HashMap<>();
    Map<Character, Character> Rotator3 = new HashMap<>();

    Map<Character, Character> Reflector = new HashMap<>();

    Enigma(){   //make ReflectorMap
        int asciNumFirst = 65;
        int asciNumLast = 90;
        char cFirst;
        char c1Last;
        for (int i = 0; i < 13; i++) {
            cFirst=(char) asciNumFirst;
            c1Last=(char) asciNumLast;
            Reflector.put(cFirst,c1Last);
            asciNumFirst++;
            asciNumLast--;
        }
//        System.out.println(Reflector);


    }

    public void PlugBoard(String plugBoardStr){
        String arrayplugBoardStr[] =  plugBoardStr.split(",");
        System.out.println(Arrays.toString(arrayplugBoardStr));
        for (int i = 0; i < arrayplugBoardStr.length; i++) {
            PlugBoard.put(arrayplugBoardStr[i].charAt(0),arrayplugBoardStr[i].charAt(1));
        }
        System.out.println(PlugBoard);

    }


    public void Rotator1(String rotate1Str){  //    ascii A to Z is 65 to  90
        int asciNum = 65;
        char c;
        for (int i = 0; i < rotate1Str.length(); i++) {
            c = (char) asciNum;
            Rotator1.put(c, rotate1Str.charAt(i));
            asciNum++;
        }
        System.out.println(Rotator1);

    }

    public void Rotator2(String rotate2Str){  //    ascii A to Z is 65 to  90
        int asciNum = 65;
        char c;
        for (int i = 0; i < rotate2Str.length(); i++) {
            c = (char) asciNum;
            Rotator2.put(c, rotate2Str.charAt(i));
            asciNum++;
        }
        System.out.println(Rotator2);

    }


    public void Rotator3(String rotate3Str){  //    ascii A to Z is 65 to  90
        int asciNum = 65;
        char c;
        for (int i = 0; i < rotate3Str.length(); i++) {
            c = (char) asciNum;
            Rotator3.put(c, rotate3Str.charAt(i));
            asciNum++;
        }
        System.out.println(Rotator3);

    }



    public char EnigmaFindEncrypt(char c){


        return 'a';
    }

}