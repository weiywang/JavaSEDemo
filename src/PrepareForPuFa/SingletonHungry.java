package PrepareForPuFa;

public class SingletonHungry {
    private SingletonHungry(){}
    public static SingletonHungry singletonHungry = new SingletonHungry();

    public static SingletonHungry getInstance(){
        return singletonHungry;
    }
}
