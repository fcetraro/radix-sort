package util;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapUtil {
    public static ArrayList<String> hashMapToList(HashMap<Integer, ArrayList<String>> hashMap){
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            ArrayList<String> iterationList = hashMap.get(i);
            list.addAll(iterationList);
        }
        return list;
    }
    public static HashMap<Integer, ArrayList<String>> initHashMap(){
        HashMap<Integer, ArrayList<String>> hashMap = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            hashMap.put(i, new ArrayList<>());
        }
        return hashMap;
    }
}
