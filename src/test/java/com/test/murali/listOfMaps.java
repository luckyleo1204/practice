package com.test.murali;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class listOfMaps {
    public static void main(String[] args) {
        Map<String,Object> map1 = new HashMap<>();
        map1.put("Map1 Key1", (Object) "Map1 value1");
        map1.put("Map1 Key2", (Object) "Map1 value2");

        Map<String,Object> map2 = new HashMap<>();
        map2.put("Map2 Key1", (Object) "Map2 value1");
        map2.put("Map2 Key2", (Object) "Map2 value2");

        List<Map<String,Object>> list = new ArrayList<>();
        list.add(map1);
        list.add(map2);

        list.stream().forEach(mapData->{
            mapData.entrySet().stream().forEach(mdata->{
                System.out.println(mdata.getKey()+":"+mdata.getValue());
            });
        });

        System.out.println("=================================");
        for(Map<String, Object> i : list){
            for(Map.Entry<String,Object> j: i.entrySet()){
                System.out.println(j+":"+j.getValue());
            }
        }


    }
}
