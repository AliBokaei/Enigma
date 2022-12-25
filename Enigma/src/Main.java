import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Enigma enigma = new Enigma();

        print4();

        System.out.print("  - Please Enter the PlugBoard Like (AF,BM,GH,JC,XE,OP,NR,ZL) : ");
//        String plugBoardStr =input.nextLine();
        String plugBoardStr ="AF,BM,GH,JC,XE,OP,NR,ZL";
        enigma.PlugBoard(plugBoardStr);
        System.out.println();

        print4();


        System.out.print("  - Please Enter the Rotator1 Like (CMFQSBHIOAKRTENZLDYWUGPJXV) : ");
        String rotate1Str ="CMFQSBHIOAKRTENZLDYWUGPJXV";
//        String rotate1Str =input.nextLine();
        System.out.println();
        enigma.Rotator1(rotate1Str);
        System.out.println();


        print4();

        System.out.print("  - Please Enter the Rotator2 Like (QNGHSZAFEBJRLUCTXYIMPDWKOV) : ");
        String rotate2Str ="QNGHSZAFEBJRLUCTXYIMPDWKOV";
//        String rotate2Str =input.nextLine();
        System.out.println();
        enigma.Rotator2(rotate2Str);
        System.out.println();

        print4();


        System.out.print("  - Please Enter the Rotator3 Like (LUWJHIKDYCAXMNQBZTRFGESVPO) : ");
        String rotate3Str ="LUWJHIKDYCAXMNQBZTRFGESVPO";
//        String rotate3Str =input.nextLine();
        System.out.println();
        enigma.Rotator3(rotate3Str);
        System.out.println();



        print4();

        System.out.print(" *****   Please Enter the Encrypted String Code : ");
        String inputStr = input.nextLine();
        char strChars[] = inputStr.toCharArray();
        for (char c:strChars) {
            System.out.print(enigma.EnigmaFindEncrypt(c));
        }
    }

    public static void print4(){
        System.out.println();System.out.println();
        System.out.println();
        System.out.println();
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
        for (int i = 0; i < 26; i++) {
            cFirst=(char) asciNumFirst;
            c1Last=(char) asciNumLast;
            Reflector.put(cFirst,c1Last);
            asciNumFirst++;
            asciNumLast--;
        }
        System.out.println("Reflector : "+ Reflector);


    }

    public void PlugBoard(String plugBoardStr){
        String arrayplugBoardStr[] =  plugBoardStr.split(",");
//        System.out.println(Arrays.toString(arrayplugBoardStr));
        for (int i = 0; i < arrayplugBoardStr.length; i++) {
            PlugBoard.put(arrayplugBoardStr[i].charAt(0),arrayplugBoardStr[i].charAt(1));
        }
        for (int i = 0; i < arrayplugBoardStr.length; i++) {
            PlugBoard.put(arrayplugBoardStr[i].charAt(1),arrayplugBoardStr[i].charAt(0));
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


//     Constructors performance
    public char getPlugBoardValueByKey(char c){
        if (PlugBoard.get(c)==null) {
            System.out.println("char is null in PlugBoard : " + c);
            exit(0);
        }
        return PlugBoard.get(c);
    }

    public char getReflectorValueByKey(char c){
        return Reflector.get(c);
    }

    public char getRotator1ValueByKey(char c){
        return Rotator1.get(c);
    }

    public char getRotator2ValueByKey(char c){
        return Rotator2.get(c);
    }

    public char getRotator3ValueByKey(char c){
        return Rotator3.get(c);
    }


    public void changeRotator1(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator1.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator1.put(c, Rotator1.get(c2));
            asciNum--;
        }
        Rotator1.put('A' ,last);
        System.out.println(Rotator1);
    }

    public void changeRotator2(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator2.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator2.put(c, Rotator2.get(c2));
            asciNum--;
        }
        Rotator2.put('A' ,last);
        System.out.println(Rotator2);
    }


    public void changeRotator3(){
        int asciNum = 90;
        char c,c2;
        char last = Rotator3.get('Z');
        for (int i = 0; i < 25; i++) {
            c = (char) asciNum;
            c2 = (char) (asciNum-1) ;
            Rotator3.put(c, Rotator3.get(c2));
            asciNum--;
        }
        Rotator3.put('A' ,last);
        System.out.println(Rotator3);
    }


    public char EnigmaFindEncrypt(char c){

        char answer = getPlugBoardValueByKey(getRotator3ValueByKey(getRotator2ValueByKey(getRotator1ValueByKey(getReflectorValueByKey(getRotator1ValueByKey(getRotator2ValueByKey(getRotator3ValueByKey(getPlugBoardValueByKey(c)))))))));


        nRotate1++;
        if (nRotate1==26){
            changeRotator1();
            nRotate2++;
            nRotate1=0;
        }
        if (nRotate2==26){
            changeRotator2();
            nRotate3++;
            nRotate2=0;
        }
        if (nRotate3==26){
            changeRotator3();
            // i don know :)
        }

        // change rotate

        return answer;
    }

}





//public class MyHashMap<K, V> {
//    private int CAPACITY = 10;
//    private MyMapBucket[] bucket;
//    private int size = 0;
//
//    public MyHashMap() {
//        this.bucket = new MyMapBucket[CAPACITY];
//    }
//    private int getHash(K key) {
//        return (key.hashCode() & 0xfffffff) % CAPACITY;
//    }
//
//    private MyKeyValueEntry getEntry(K key) {
//        int hash = getHash(key);
//        for (int i = 0; i < bucket[hash].getEntries().size(); i++) {
//            MyKeyValueEntry myKeyValueEntry = bucket[hash].getEntries().get(i);
//            if(myKeyValueEntry.getKey().equals(key)) {
//                return myKeyValueEntry;
//            }
//        }
//        return null;
//    }
//    public void put(K key, V value) {
//        if(containsKey(key)) {
//            MyKeyValueEntry entry = getEntry(key);
//            entry.setValue(value);
//        } else {
//            int hash = getHash(key);
//            if(bucket[hash] == null) {
//                bucket[hash] = new MyMapBucket();
//            }
//            bucket[hash].addEntry(new MyKeyValueEntry<>(key, value));
//            size++;
//        }
//    }
//
//    public V get(K key) {
//        return containsKey(key) ? (V) getEntry(key).getValue() : null;
//    }
//
//    public boolean containsKey(K key) {
//        int hash = getHash(key);
//        return !(Objects.isNull(bucket[hash]) || Objects.isNull(getEntry(key)));
//    }
//
//    public void delete(K key) {
//        if(containsKey(key)) {
//            int hash = getHash(key);
//            bucket[hash].removeEntry(getEntry(key));
//            size--;
//        }
//    }
//    public int size() {
//        return size;
//    }
//}