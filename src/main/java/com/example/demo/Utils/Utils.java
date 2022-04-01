package com.example.demo.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Utils {
    //metoda care merge-uieste 2 obiecte pe care am folosit-o la update ca sa ii pot da
    //doar field-urile pe care vreau sa le actualizez in RequestBody si sa nu mi le faca
    //null pe celelalte
    @SuppressWarnings("unchecked")
    public static <T> T mergeObjects(T first, T second) throws IllegalAccessException, InstantiationException {
        Class<?> clazz = first.getClass();
        Field[] fields = clazz.getDeclaredFields();
        Object returnValue = clazz.newInstance();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value1 = field.get(first);
            Object value2 = field.get(second);
            Object value = (value1 != null) ? value1 : value2;
            field.set(returnValue, value);
        }
        return (T) returnValue;
    }


}
