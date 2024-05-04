package demo.abstractandinterface;

/**
 * 抽象动物
 *
 * @author CatCatHead
 * @date 2024/03/04
 */
public abstract class AbstractAnimal {

    protected String name;
    public AbstractAnimal(String name){
        this.name = name;
    }

    /**
     * 声音
     */
    public abstract void sound();

    public void eat() {
        System.out.println(name + " is eating");
    }
}
