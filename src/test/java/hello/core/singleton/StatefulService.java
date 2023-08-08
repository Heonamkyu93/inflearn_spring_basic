package hello.core.singleton;

public class StatefulService {
    
    private int price; //상태를 유지하는 필드

   /*       상태가 유지되서 싱글톤의 단점이 드러난 코드
    public void order(String name, int price) {
        System.out.println("name = " + name + "  price="+price);
        this.price=price;    // 여기가 문제 멀티쓰레드환경같이 여러번 객체가 호출되면서 필드로 상태가 유지되면 값이 덮어 씌어진다

    }
    public int getPrice() {
        return price;
    }*/
    
    
    // 상태가 유지되지 않는 지역변수나 매개변수를 사용하면 상태가 유지되지 않는다 
    public int order(String name, int price) {
        System.out.println("name = " + name + "  price="+price);
        return price;
    }

}
