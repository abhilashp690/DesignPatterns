package Creational;

interface Pizza {
    public void bakePizza();
    public void fryPizza();
    public void packPizza();
}

class NyCheesePizza implements Pizza{

    @Override
    public void bakePizza() {
        System.out.println("Baking Ny Cheese Pizza");
    }

    @Override
    public void fryPizza() {
        System.out.println("Frying Ny Cheese Pizza");
    }

    @Override
    public void packPizza() {
        System.out.println("Ny Cheese Pizza packed and ready to deliver");
    }
}
class NyCapsicumPizza implements Pizza{

    @Override
    public void bakePizza() {
        System.out.println("Baking Ny Capsicum Pizza");
    }

    @Override
    public void fryPizza() {
        System.out.println("Frying Ny Capsicum Pizza");
    }

    @Override
    public void packPizza() {
        System.out.println("Ny Capsicum Pizza packed and ready to deliver");
    }
}


class ChicageCheesePizza implements Pizza{

    @Override
    public void bakePizza() {
        System.out.println("Baking Chicage Cheese Pizza");
    }

    @Override
    public void fryPizza() {
        System.out.println("Frying Chicage Cheese Pizza");
    }

    @Override
    public void packPizza() {
        System.out.println("Chicago Cheese Pizza packed and ready to deliver");
    }
}
class ChicageCapsicumPizza implements Pizza{

    @Override
    public void bakePizza() {
        System.out.println("Baking Chicage Capsicum Pizza");
    }

    @Override
    public void fryPizza() {
        System.out.println("Frying Chicage Capsicum Pizza");
    }

    @Override
    public void packPizza() {
        System.out.println("Chicage Capsicum Pizza packed and ready to deliver");
    }
}


interface Factory{
    public Pizza orderPizza(String type);
}

class NYFactory implements Factory{

    @Override
    public Pizza orderPizza(String type) {
        System.out.println("Request to create NY pizza of type - " + type);
        Pizza pizza = createPizza(type);
        pizza.bakePizza();
        pizza.fryPizza();
        return pizza;
    }

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type){
            case "Cheese":
                pizza = new NyCheesePizza();
                break;

            default:
                pizza = new NyCapsicumPizza();

        }
        return pizza;
    }
}

class ChicageFactory implements Factory{

    @Override
    public Pizza orderPizza(String type) {
        System.out.println("Request to create Chicago pizza of type - " + type);
        Pizza pizza = createPizza(type);
        pizza.bakePizza();
        pizza.fryPizza();
        return pizza;
    }

    public Pizza createPizza(String type) {
        Pizza pizza = null;
        switch (type){
            case "Cheese":
                pizza = new ChicageCheesePizza();
                break;
            default:
                pizza = new ChicageCapsicumPizza();
        }
        return pizza;
    }
}

public class FactoryDesignPattern {
    public static void main(String[] args) {
        System.out.println("Factory Design Pattern Demonstration.");
        System.out.println("Factory Design pattern provides interfaces for creating objects and let subclasses decide which implementation to use.");

        Factory factory = new NYFactory();
        Pizza pizza = factory.orderPizza("Cheese");
        pizza.packPizza();
        System.out.println("------------------------------------------");

        pizza = factory.orderPizza("Capsicum");
        pizza.packPizza();
        System.out.println("------------------------------------------");

        factory = new ChicageFactory();
        pizza = factory.orderPizza("Cheese");
        pizza.packPizza();
        System.out.println("------------------------------------------");

        pizza = factory.orderPizza("Capsicum");
        pizza.packPizza();
        System.out.println("------------------------------------------");

        System.out.println("\nDesign Principles followed - 1].Single Responsibility 2].Encapsulate what varies. 3].Program to interface not implementation.");
    }
}
