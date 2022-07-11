package hello.demo.singleton;

public class SingletonService {
    //이 객체 instance는 오직 getInstance()를 통해서만 조회가능. getInstance()는 항상 같은 인스턴스를 반환
    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    //생성자를 private으로 막아서 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
