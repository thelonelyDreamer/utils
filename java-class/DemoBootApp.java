import java.util.concurrent.ConcurrentHashMap;

public class DemoBootApp {
    private ConcurrentHashMap objectsHolder = new ConcurrentHashMap<String,>()
    
    public static void main(String[] args) {
        
    }
    
    public static interface Demo{
        void demo();
    }
    
    private static class ObjectHolder<T>{
        T object;
    }
}