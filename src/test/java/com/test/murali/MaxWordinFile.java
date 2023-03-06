package com.test.murali;

import java.io.*;
import java.util.*;

public class MaxWordinFile {
    public static void main(String[] args) throws IOException {
        Map<String,Integer> wordMap=new HashMap<>();
        FileInputStream fis=new FileInputStream("/Users/muralic/Desktop/Documents/BasicsofStockMarket.txt");
        DataInputStream dis=new DataInputStream(fis);
        BufferedReader br=new BufferedReader(new InputStreamReader(dis));
        String line=null;
        while((line=br.readLine())!=null){
            StringTokenizer st = new StringTokenizer(line, " ");
            while(st.hasMoreTokens()){
                String tmp = st.nextToken().toLowerCase();
                if(wordMap.containsKey(tmp)){
                    wordMap.put(tmp, wordMap.get(tmp)+1);
                } else {
                    wordMap.put(tmp, 1);
                }
            }

        }

        Set<Map.Entry<String, Integer>> set = wordMap.entrySet();
        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(set);
        Collections.sort( list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare( Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2 )
            {
                return (o2.getValue()).compareTo( o1.getValue() );
            }
        } );

      //  Collections.sort(list, (o1,o2)->o1.getValue().compareTo(o2.getValue()));

        for(Map.Entry<String, Integer> entry:list){
            System.out.println(entry.getKey()+" ==== "+entry.getValue());
        }

    }
}
