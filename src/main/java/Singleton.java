class Singleton {
    int a = 0;

    //静态私有内部类
    private static Singleton instance;

    private Singleton(){

    }

    static Singleton getInstance(){
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}