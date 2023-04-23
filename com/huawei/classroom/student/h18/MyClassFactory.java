package com.huawei.classroom.student.h18;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class MyClassFactory {
   private Properties properties;

   public MyClassFactory(String filepath) throws Exception{
       FileInputStream fileInputStream = new FileInputStream(filepath);
       InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
       properties = new Properties();
       properties.load(inputStreamReader);
       inputStreamReader.close();
       fileInputStream.close();
   }
    public <T> T createInstance(Class<T> cls) throws InstantiationException, IllegalAccessException {
        T obj = cls.newInstance();
        String name = cls.getName() + ".";
        Field[] fields = cls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if(field.getType() == int.class || field.getType() == Integer.class) {
                field.set(obj, Integer.parseInt(properties.getProperty(name + field.getName())));
            } else {
                field.set(obj, properties.getProperty(name + field.getName()).replace("\"",""));
            }
        }
        return obj;
    }
}
