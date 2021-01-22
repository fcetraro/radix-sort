package controller;

import java.util.ArrayList;
import java.util.HashMap;

import static util.ArrayListUtil.*;
import static util.HashMapUtil.*;

public class Main {
    public static void main(String[] args)
    {
        int[] iArr = {3, 673, 106, 45, 2,23 };
        ArrayList<String> sortedList = radixSort(iArr);
        printList(sortedList);
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
}
