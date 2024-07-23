package assignments.day14.task3;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class SampleClass {
    private String privateField="Initial Value";

    public SampleClass() {

    }

    public SampleClass(String value) {
        this.privateField=value;
    }

    public String getPrivateField() {
        return privateField;
    }
    
    public void setPrivateField(String privateField) {
        this.privateField = privateField;
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // Get the Class object associated with SampleClass
            Class<?> c=SampleClass.class;
            // Print the class name
            System.out.println("Class Name: "+c.getName());

            // Inspecting methods
            Method[] methods=c.getDeclaredMethods();
            System.out.println("\nMethods:");
            for(Method method:methods) {
                System.out.println(Modifier.toString(method.getModifiers())+" "+method.getReturnType().getName()+" "+method.getName());
            }

            //Inspecting fields
            Field[] fields=c.getDeclaredFields();
            System.out.println("\nFields:");
            for(Field field: fields) {
                System.out.println(Modifier.toString(field.getModifiers())+" "+field.getType().getName()+" "+field.getName());
            }

            //Inspecting Constructors
            Constructor<?>[] constructors=c.getConstructors();
            System.out.println("\nConstructors:");
            for(Constructor constructor: constructors) {
                System.out.print(Modifier.toString(constructor.getModifiers())+" "+constructor.getName()+"(");
                Class<?>[] parameterTypes=constructor.getParameterTypes();
                for(int i=0; i<parameterTypes.length; i++) {
                    System.out.print(parameterTypes[i].getName());
                    if(i<parameterTypes.length-1) {
                        System.out.println(", ");
                    }
                }
                System.out.println(")");
            }

            // Modifying the access level of a private field and setting its value
            SampleClass sampleObject=new SampleClass();
            Field privateField=c.getDeclaredField("privateField");
            privateField.setAccessible(true); // Make the private field accessible
            System.out.println("\nOriginal privateField value: "+privateField.get(sampleObject));
            privateField.set(sampleObject, "Modified Value"); // Set the new value
            System.out.println("Modified privateField value: "+privateField.get(sampleObject));
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}