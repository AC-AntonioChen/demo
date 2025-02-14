package demo.javaguide.java.abstractandinterface;

public class Fish implements ISwimmingAbility{
    @Override
    public void swimming() {
        System.out.println("I am swimming!");
    }
}
