package hello.core.singletone;

public class SingletoneService {

    private static final SingletoneService instance = new SingletoneService();
    //자기 자신을 static final로 가지고 있는다.

     public static  SingletoneService getInstance(){
         return instance;
     }

     private SingletoneService(){}


    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");

    }

}
