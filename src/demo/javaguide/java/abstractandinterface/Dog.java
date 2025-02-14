package demo.javaguide.java.abstractandinterface;

public class Dog extends AbstractAnimal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("wang wang");
    }

    @Override
    public void eat() {
        System.out.println("dog like eating meat");
        super.eat();
    }

    public String getName(){
        return super.name;
    }
}
