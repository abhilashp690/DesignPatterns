package Structural;

interface ClientInterface{
    public void display();
}

class Adapter implements ClientInterface{

    private TargetInterface adaptee;

    public Adapter(TargetInterface adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void display() {
        adaptee.show();
    }
}

interface TargetInterface{
    public void show();
}

class Adaptee implements TargetInterface{

    @Override
    public void show() {
        System.out.println("Showing details......");
    }
}

public class AdapterDesignPattern {
    public static void main(String[] args) {
        System.out.println("Adapter Pattern - Ability to communicate with classes that are incompatible with each other , mapping target interface to interface that client expects.");
        System.out.println("Key Components - 1].TARGET INTERFACE 2].CLIENT INTERFACE 3].ADAPTER 4].ADAPTEE");
        System.out.println("Design Principles followed - 1].Program to interface not implementation. 2].Single Responsibility[Delegates the call only] 3].");

        TargetInterface adaptee = new Adaptee();
        ClientInterface clientInterface = new Adapter(adaptee);
        clientInterface.display();
    }
}
