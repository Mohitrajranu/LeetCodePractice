package com.reflections.annotations;

import java.lang.reflect.*;

public class FieldInfo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, ClassNotFoundException, InstantiationException {
        Entity e = new Entity(10,"id");
        Class<? extends Entity> clss = e.getClass();
        //non-declared : all the public elements in that class and its super class
        Field[] fields = clss.getFields();
        Method[] methods= clss.getMethods();
        Method[] declaredMethods = clss.getDeclaredMethods();

        for(Field field : fields){
            System.out.println(field.getName());
        }
        //declared: all the elements present in that class only.
        Field[] declaredFields = clss.getDeclaredFields();
        for(Field field: declaredFields){
            System.out.println(field.getName());
        }

        Field field = clss.getField("type");
        field.set(e,"rollno");
        System.out.println(e.getType());

        Field val = clss.getDeclaredField("val");
        val.setAccessible(true);
        val.set(e,21);
        System.out.println(e.getVal());

        Method meth = clss.getMethod("setVal", int.class);

        meth.invoke(e,15);
        Method meth2 = clss.getMethod("getVal",null);
        System.out.println(meth2.invoke(e,null));

        Class <?> clsscon=Class.forName("com.reflections.annotations.Entity");
        Constructor<?>[] declaredConstructor = clsscon.getDeclaredConstructors();
        for (Constructor<?>constructor: declaredConstructor) {
            System.out.println(constructor);
        }
        Constructor<?> publicConstructor =  clsscon.getConstructor(int.class,String.class);
        Entity ent=(Entity)publicConstructor.newInstance(78,"studId");
        System.out.println(ent.getVal()+"----"+ent.getType());

        Constructor<?> privateConstructor =  clsscon.getDeclaredConstructor();
        privateConstructor.setAccessible(true);
        Entity defaultE = (Entity)privateConstructor.newInstance();
        System.out.println(defaultE.getType()+"----"+defaultE.getVal());

        int modifiersint=clss.getModifiers();
        boolean isPublicClass = Modifier.isPublic(modifiersint);
        System.out.println(isPublicClass);
        Method method1=clss.getMethod("getVal");
        int methodModifiers=method1.getModifiers();
        boolean isPublicMethod = Modifier.isPublic(methodModifiers);
        System.out.println(isPublicMethod);



    }

}
