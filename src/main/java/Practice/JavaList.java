package Practice;

import java.util.ArrayList;

public class JavaList {


    public static void main(String[] args) {

       ArrayList<String> result;
         result = arrayList();
        for (String element : result) {
            System.out.println(element);
        }
    }


    public static ArrayList arrayList() {
        ArrayList<String> colour = new ArrayList<>();
        colour.add("RED");
        colour.add("BLUE");
        colour.add("WHITE");
//        Scanner in = new Scanner(System.in);
//                String s =  in.nextLine();
        for (String element : colour) {
//            if(element.equals(s)){
//                System.out.println(element+" index:"+colour.indexOf(element));
//            }
            System.out.println(element);
        }

//        ArrayList<String> copy = new ArrayList<>();
//        copy = colour;
//        colour.addAll(1, Collections.singleton("YELLOW"));
//        colour.set(1,"YELLOW");
//        colour.remove(1);
        System.out.println("After copied");
//        Collections.sort(colour);
//        for (String element : copy) {
//            System.out.println(element);
//        }
//        System.out.println(colour.get(1));
        return colour;
    }
}

