/**
 * Created by Gary Wu.
 *
 * @author <a href="mailto:gary.wu@crown.com">Gary Wu</a>
 * @date 2020/01/10 13:52
 * @project JavaTutorial_2
 * @Description
 */
public class TestEdible {
    public static void main(String[] args) {
        Object[] objects = {new Tiger(), new Chicken(), new Apple()};
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] instanceof Edible) {
                ((Edible)objects[i]).howToEat();
            }
            if (objects[i] instanceof Animal) {
                ((Animal)objects[i]).sound();
            }
        }
    }
}

abstract class Animal{
    public abstract void sound();
}

class Chicken extends Animal implements Edible{

    @Override
    public void sound() {
        System.out.println("Chik chik chik");
    }

    @Override
    public void howToEat() {
        System.out.println("Stir-fry");
    }
}

class Tiger extends Animal{

    @Override
    public void sound() {
        System.out.println("Wao!");
    }
}


abstract class Fruit implements Edible {
    // 数据域等都会被继承
}

class Apple extends Fruit {

    @Override
    public void howToEat() {
        System.out.println("Apple: Make apple cider");
    }
}

class Orange extends Fruit {

    @Override
    public void howToEat() {
        System.out.println("Orange: Make orange juice..");
    }
}