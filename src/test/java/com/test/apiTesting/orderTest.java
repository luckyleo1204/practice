package com.test.apiTesting;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class orderTest {

    @Test
    public void ordersTest() throws JsonProcessingException {
        orders o = new orders();
        o.setBookId(6);
        o.setCustomerName("Raj");
        String s = retunrnJsonObject(o);
        System.out.println(s);
    }

    @Test
    public void valueData() throws JsonProcessingException, IllegalAccessException {
        ValueItems v=new ValueItems();
        v.setData("Mi");
        v.setEan(5);
        List<ValueItems> vl=new ArrayList<>();
        vl.add(v);
       ValueData vi=new ValueData();
       vi.setInformation(vl);
       String s=retunrnJsonObject2(vi);

    }
    public static String retunrnJsonObject(orders o) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(o);
    }

    public static String retunrnJsonObject2(ValueData  o) throws JsonProcessingException, IllegalAccessException {

        JSONArray jsonArray = new JSONArray();
//        for (Object i : o) {
//            String jstr = toJSON(i);
//            JSONObject jsonObject = new JSONObject();
//           // jsonArray.put(jstr);
//        }
        return jsonArray.toString();
//        ObjectMapper mapper = new ObjectMapper();
//        return mapper.writeValueAsString(o);
    }

    public static String toJSON(Object object) throws  IllegalAccessException {
        String str = "";
        Class c = object.getClass();
        JSONObject jsonObject = new JSONObject();
        for (Field field : c.getDeclaredFields()) {
            field.setAccessible(true);
            String name = field.getName();
            String value = String.valueOf(field.get(object));
            jsonObject.put(name, value);
        }
        System.out.println(jsonObject.toString());
        return jsonObject.toString();
    }


}
