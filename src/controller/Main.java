package controller;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String args[])
    {
        int iArr[] = {3, 673, 106, 45, 2,23 };
        ArrayList<String> sortedList = radixSort(iArr);
        printList(sortedList);
    }
    static void printList(ArrayList<String> list ){
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    static ArrayList<String> toStringArray(int[] iArr){
        ArrayList<String> list = new ArrayList<String>();
        int maxValue = 0;
        for (int i = 0; i < iArr.length; i++) {
            list.add(iArr[i]+"");
            if(iArr[i]>maxValue){
                maxValue=iArr[i];
            }
        }
        return add0ToStrings(list, maxValue+"");
    }
    static ArrayList<String> add0ToStrings(ArrayList<String> list, String maxValue){
        int lenghtString = maxValue.length();
        for (int i = 0; i < list.size(); i++) {
           String elementAtI = list.get(i);
           while(elementAtI.length() != lenghtString){
               elementAtI = "0" + elementAtI;
           }
           list.set(i,elementAtI);
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
        for (int i = 0; i < list.size(); i++) {
            int value = Character.getNumericValue(list.get(i).charAt(indexToCheck));
            ArrayList<String> listAtIndex = hashMap.get(value);
            listAtIndex.add(list.get(i));
            hashMap.put(value,listAtIndex);
        }
        return hashMap;
    }
    static ArrayList<String> hashMapToList(HashMap<Integer, ArrayList<String>> hashMap){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            ArrayList<String> iterationList = hashMap.get(i);
            for (int j = 0; j < iterationList.size(); j++) {
                list.add(iterationList.get(j));
            }
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
