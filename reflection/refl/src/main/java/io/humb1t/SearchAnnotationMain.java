package io.humb1t;

import io.humb1t.classes.*;
import org.reflections.Reflections;

import java.util.Arrays;
import java.util.Set;


public class SearchAnnotationMain {
    private static Object[] allObjects = {new A(), new B(), new C(),
            new D(), new F(), new G(), new J(), new I()};

    public static void main(String[] args) {
        findDeprecatedObjects();
        findDeprecatedObjectsAndSuggestAlternatives();
    }

    private static void findDeprecatedObjects() {
        System.out.println("FIRST TASK");
        System.out.println(Arrays.toString(allObjects));
        Object[] deprecatedObjects = Arrays.stream(allObjects).filter(object -> (null != object.getClass().getDeclaredAnnotation(Deprecated.class))).toArray();
        System.out.println(Arrays.toString(deprecatedObjects));
    }

    private static void findDeprecatedObjectsAndSuggestAlternatives() {
        System.out.println("SECOND TASK");
        System.out.println(Arrays.toString(allObjects));
        for (Object object : allObjects) {
            if (null != object.getClass().getAnnotation(Deprecated.class)) {
                System.out.println("_________________________________________");
                System.out.println("Class " + object.getClass().getSimpleName() + " is Deprecated.");
                findAlternativeForSuperclass(object);
                findAlternativeForInterface(object);
            }
        }
    }

    private static void findAlternativeForSuperclass(Object object) {
        Class superclass = object.getClass().getSuperclass();
        if (superclass != null && !superclass.getSimpleName().equals("Object")) {
            System.out.println("Found superclass " + superclass.getSimpleName() + ". Trying to find Alternative...");
            find(object, superclass);
        }
    }

    private static void find(Object object, Class superclass) {
        Reflections reflections = new Reflections(superclass.getPackageName());
        Set<Class> set = reflections.getSubTypesOf(superclass);
        for (Class c : set) {
            if (c.getDeclaredAnnotation(Deprecated.class) == null) {
                System.out.println("Use class " + c.getSimpleName() + " instead of " + object.getClass().getSimpleName());
            }
        }
        System.out.println("_________________________________________");
    }

    private static void findAlternativeForInterface(Object object) {
        Class[] interfaces = object.getClass().getInterfaces();
        if (interfaces.length != 0) {
            System.out.println("Found interface(s) " + Arrays.toString(interfaces) + ". Trying to find Alternative...");
            for (Class implementedInterface : interfaces) {
                find(object, implementedInterface);
            }
        }

    }
}