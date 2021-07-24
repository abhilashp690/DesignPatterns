package Creational;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class SingletonDemo implements Cloneable , Serializable {
    private static SingletonDemo instance;

    private SingletonDemo(){
        if(instance != null)
            throw new RuntimeException("Instance created via reflection failed....");
    }

    public static SingletonDemo getSingleInstance() {
        if(instance == null){
            synchronized (SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public Object readResolve() {
        return instance;
    }

    public SingletonDemo clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

public class Singleton {
    public static void main(String[] args) throws IOException, ClassNotFoundException, CloneNotSupportedException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        System.out.println("Design Principle Followed - 1].Single Responsibility");

        SingletonDemo s1 = SingletonDemo.getSingleInstance();
        SingletonDemo s2 = SingletonDemo.getSingleInstance();
        System.out.println("S1 is - " + s1 + " , S2 is - " + s2);

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("single.ser")));
        oos.writeObject(s1);

        try {
            SingletonDemo s3 = s2.clone();
            System.out.println("Instance after cloning - " + s3);
        }
        catch(CloneNotSupportedException cs){
            System.out.println("Clone Not Supported Exception....");
        }

        try {
            Class c = Class.forName("DesignPattern.Creational.SingletonDemo");
            Constructor constr = c.getDeclaredConstructor();
            constr.setAccessible(true);
            constr.newInstance();
        }
        catch (Exception e){
            System.out.println("Received error = " + e);
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("single.ser"));
        SingletonDemo instance = (SingletonDemo) ois.readObject();
        System.out.println("Instance after deserialization - " + instance);
    }
}
