package ru.sbertech.reflection;
import java.lang.reflect.*;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException {
        Class<?> clazz=Tester.class;
        Method[] methods = clazz.getMethods();
        for(Method method : methods){
            if (MethodIsGetter(method))
                System.out.println(method.getName() + " is getter method");
            if (MethodIsSetter(method))
                System.out.println(method.getName()+" is setter method");
        }
    }

    public static boolean MethodIsGetter(Method method){
        if (method.getName().startsWith("get")
                && method.getParameterCount() == 0
                && !void.class.equals(method.getReturnType())
                && !Modifier.isFinal(method.getModifiers()))
            return true;
        else
            return false;
    }

    public static boolean MethodIsSetter(Method method){
        if (method.getName().startsWith("set")
                && method.getParameterCount() == 1)
            return true;
        else
            return false;
    }
}

