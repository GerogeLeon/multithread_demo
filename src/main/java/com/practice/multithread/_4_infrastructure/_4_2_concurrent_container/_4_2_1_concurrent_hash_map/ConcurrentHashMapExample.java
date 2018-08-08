package com.practice.multithread._4_infrastructure._4_2_concurrent_container._4_2_1_concurrent_hash_map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ConcurrentHashMapExample {

    public static void main(String[] args) {

        Map<String, String> myMap = new HashMap<>();//lkm: for contrast
//		Map<String,String> myMap = new ConcurrentHashMap<String,String>();
        myMap.put("1", "1");
        myMap.put("2", "1");
        myMap.put("3", "1");
        myMap.put("4", "1");
        myMap.put("5", "1");
        myMap.put("6", "1");
        System.out.println("ConcurrentHashMap before iterator: " + myMap);
        Iterator<String> it = myMap.keySet().iterator();

        while (it.hasNext()) {
            String key = it.next();
            if (key.equals("3")) myMap.put(key + "new", "new3");
        }
        System.out.println("ConcurrentHashMap after iterator: " + myMap);

    }

}
