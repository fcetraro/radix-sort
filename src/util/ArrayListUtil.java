package util;

import java.util.ArrayList;

    public class ArrayListUtil {
        public static void printList(ArrayList<String> list ){
            for (String s : list) {
                System.out.println(s);
            }
        }
        public static ArrayList<String> toStringArray(int[] iArr){
            ArrayList<String> list = new ArrayList<>();
            int maxValue = 0;
            for (int j : iArr) {
                list.add(j + "");
                if (j > maxValue) {
                    maxValue = j;
                }
            }
            return add0ToStrings(list, maxValue+"");
        }
        static ArrayList<String> add0ToStrings(ArrayList<String> list, String maxValue){
            int lenghtString = maxValue.length();
            for (int i = 0; i < list.size(); i++) {
                StringBuilder elementAtI = new StringBuilder(list.get(i));
                while(elementAtI.length() != lenghtString){
                    elementAtI.insert(0, "0");
                }
                list.set(i, elementAtI.toString());
            }
            return list;
        }
}
