package PrepareForPuFa;

public class Singleton {
    private Singleton(){}
    public static Singleton singleton = null;

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }
}
