package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args)
    {
        int[] iArr = {3, 673, 106, 45, 2,23 };
        ArrayList<String> sortedList = radixSort(iArr);
        printList(sortedList);
    }
    static void printList(ArrayList<String> list ){
        for (String s : list) {
            System.out.println(s);
        }
    }
    static ArrayList<String> toStringArray(int[] iArr){
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
    static ArrayList<String> radixSort(int[] iArr){
        ArrayList<String> list = toStringArray(iArr);
        int size = list.get(0).length();
        for (int i = 0; i < size; i++) {
            HashMap<Integer, ArrayList<String>> hashMap = insertToHashMap(list, i);
            list = hashMapToList(hashMap);
        }
        return list;
    }
    static HashMap<Integer, ArrayList<String>> insertToHashMap(ArrayList<String> list, int iteration){
        HashMap<Integer, ArrayList<String>> hashMap = initHashMap();
        int indexToCheck = list.get(0).length()-1-iteration;
        for (String s : list) {
            int value = Character.getNumericValue(s.charAt(indexToCheck));
            ArrayList<String> listAtIndex = hashMap.get(value);
            listAtIndex.add(s);
            hashMap.put(value, listAtIndex);
        }
        return hashMap;
    }
    static ArrayList<String> hashMapToList(HashMap<Integer, ArrayList<String>> hashMap){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<String> iterationList = hashMap.get(i);
            list.addAll(iterationList);
        }
        return list;
    }
    static HashMap<Integer, ArrayList<String>> initHashMap(){
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, new ArrayList<>());
        }
        return hashMap;
    }
}
