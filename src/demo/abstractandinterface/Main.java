package demo.abstractandinterface;

public class Main {
    public static void main(String[] args) {
        AbstractAnimal animal = new Dog("GoodDog");
        Fish fish = new Fish();
        animal.sound();
        animal.eat();

    }
}
