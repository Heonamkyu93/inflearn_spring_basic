package hello.core.singleton;

public class SingletonService {


    public static final SingletonService instance = new SingletonService();

    private SingletonService(){
        //private 생성자로 new를 막아둠 그래서 싱글톤
    }
    public static SingletonService getInstance(){
        return instance;
    }

    public void login(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
