package ru.javawebinar.basejava.util;

public class LazySingleton {
    volatile private static LazySingleton INSTANCE;

    double sin = Math.sin(13.);

    private LazySingleton(){
    }

    private static class LazySingletonHolder{
        private static final LazySingleton INSTANCE = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        // Initialization-on-demand holder idiom
        return LazySingletonHolder.INSTANCE;
        // double-checked locking
//        if(INSTANCE == null) {
//            synchronized (LazySeingleton.class) {
//                if(INSTANCE == null) {
//                    INSTANCE = new LazySeingleton();
//                }
//            }
//        }
//        return INSTANCE;
    }
}
