package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonTest {



        @Test
        @DisplayName("스프링 없는 순수한 DI 컨테이너")
        void pureContainer() {
            AppConfig appConfig = new AppConfig();
                // 1. 조회 : 호출할 떄 마다 객체를 생성
            MemberService memberService1 =appConfig.memberService();
                // 2. 조회 : 호출할 때 마다 객체를 생성
            MemberService memberService2 =appConfig.memberService();



            // 참조값이 다른 것을 확인

            System.out.println("memberService1 = " + memberService1);
            System.out.println("memberService2 = " + memberService2);

            // 자동으로 체크해주는 버릇을 들여야한다 sysout 그만 찍고
            Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        }
        @Test
        @DisplayName("싱글톤 객체테스트")
        void 싱글톤테스트(){
      //      SingletonService singletonService1 = new SingletonService();  SingtonService의 기본생성자가 private이기 때문에 new로 새로운 객체를 생성못한다 이것이 싱글톤
                SingletonService singletonService1 = SingletonService.getInstance();
                SingletonService singletonService2 = SingletonService.getInstance();

                Assertions.assertThat(singletonService1).isSameAs(singletonService2);
                // isSameAs 는 ==    주소값 비교   같은 객체인지 비교하기위해 same 을 사용
                // isEqualto 는 .equals  힙영역 데이터 비교


         }

         @Test
         @DisplayName("스프링컨테이너의 싱글톤")
            void 스프링컨테이너싱글톤테스트(){
             ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

             MemberService memberService1 = applicationContext.getBean("memberService", MemberService.class);
             MemberService memberService2 = applicationContext.getBean("memberService", MemberService.class);


            Assertions.assertThat(memberService1).isSameAs(memberService2);

         }


}
