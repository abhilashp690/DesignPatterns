package Creational;

class Car{
    String engineName;
    String model;
    String registerationNumber;
    int maxSpeed;
    int fuelCapacity;

    public String getEngineName() {
        return engineName;
    }

    public void setEngineName(String engineName) {
        this.engineName = engineName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engineName='" + engineName + '\'' +
                ", model='" + model + '\'' +
                ", registerationNumber='" + registerationNumber + '\'' +
                ", maxSpeed=" + maxSpeed +
                ", fuelCapacity=" + fuelCapacity +
                '}';
    }
}

class Director {
    public Car getMeACar(){
        BuilderClass builder = new BuilderClass();
        Car car = builder.setEngineName("EngineNaMe").setFuelCapacity(29).setMaxSpeed(324).setRegisterationNumber("MH-12")
                .build();
        System.out.println("Create Car Instance - " + car);
        return car;
    }
}

class BuilderClass{
    private String engineName;
    private String model;
    private String registerationNumber;
    private int maxSpeed;
    private int fuelCapacity;

    public BuilderClass setEngineName(String engineName) {
        this.engineName = engineName;
        return this;
    }

    public BuilderClass setModel(String model) {
        this.model = model;
        return this;
    }

    public BuilderClass setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
        return this;
    }

    public BuilderClass setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
        return this;
    }

    public BuilderClass setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
        return this;
    }

    public Car build(){
        Car car = new Car();
        car.setEngineName(this.engineName);
        car.setFuelCapacity(this.fuelCapacity);
        car.setModel(this.model);
        car.setMaxSpeed(this.maxSpeed);
        car.setRegisterationNumber(this.registerationNumber);
        return car;
    }
}

public class Builder {
    public static void main(String[] args) {
        System.out.println("Builder Design Pattern...Building out complex object step by step. Separate out the construction process from representation so that same construction process can give different representation.");
        System.out.println("Key Entities - 1].Builder Interface - That actually builds a product");
        System.out.println("2].Director - That customises the product using builder.");
        System.out.println("3].Concrete Product - End product that needs to be created.");

        System.out.println("Design Principle Followed - 1].Single Responsibility Pattern. 2].Encapsulate what varies. 3].Disadvantage - Too many builder classes to be created when products are high.");

        System.out.println("Client -> Director -> Builder Class -> Actual Product");
        Director director = new Director();
        director.getMeACar();
    }
}
