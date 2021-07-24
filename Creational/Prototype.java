package Creational;

abstract class HeavyObjectImplementation {
    int heavyId = 0;
    String heavyName = null;

    public abstract Object doClone() throws CloneNotSupportedException;
}

class HeavyObject extends HeavyObjectImplementation implements Cloneable {

    public HeavyObject(int heavyId, String heavyName) {
        this.heavyId = heavyId;
        this.heavyName = heavyName;
    }

    public int getHeavyId() {
        return this.heavyId;
    }

    public void setHeavyId(int heavyId) {
        this.heavyId = heavyId;
    }

    public String getHeavyName() {
        return this.heavyName;
    }

    public void setHeavyName(String heavyName) {
        this.heavyName = heavyName;
    }
    @Override
    public String toString() {
        return "HeavyObject{" +
                "heavyId=" + this.heavyId +
                ", heavyName='" + this.heavyName + '\'' +
                '}';
    }

    @Override
    public Object doClone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        System.out.println("Prototype Demonstration...specifies type of instance to create using prototypical instance,create new objects by copying this prototype.");
        System.out.println("Prototype Design Pattern generally used to create clone of complex object that is costly to create/that consumes a lot of memory.");
        System.out.println("Design Principle Followed - 1].Depends on Abstraction(Only Interface is exposed to client , he does not know anything about implementation.) 2].Program to Interface not implementation.");

        HeavyObjectImplementation heavyObject = new HeavyObject(1 , "HeavyInstance");
        HeavyObjectImplementation heavyObject1 = (HeavyObject) heavyObject.doClone();
        System.out.println("Original Instance - " + heavyObject + ", Cloned Instance - " + heavyObject1);
    }
}
