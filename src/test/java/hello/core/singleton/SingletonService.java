package hello.core.singleton;

public class SingletonService {

    //static 영역에 instance를 생성해서 올린다.
    //public으로 외부에서 생성된 instance에 접근할 수 있도록 한다
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
