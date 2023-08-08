package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 필드사용시 문제")
    void 상태유지컨테이너() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = annotationConfigApplicationContext.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = annotationConfigApplicationContext.getBean("statefulService", StatefulService.class);

        //  statefulService.order("첫번쨰사용자",10000);
        //  statefulService2.order("두번째 사용자",40000);
        //   System.out.println("statefulService = " + statefulService.getPrice());      // 첫번째 사용자는 price가 10000 이지만 필드에 상태가 유지되기 때문에 \
        // 나중에 쓰여진 값으로 값이 변한다
        //  Assertions.assertThat(statefulService.getPrice()).isNotSameAs(10000);

        int priceA = statefulService.order("첫번쨰사용자", 10000);
        int priceB = statefulService2.order("두번째 사용자", 40000);
        System.out.println("priceA = " + priceA);
        System.out.println("priceB = " + priceB);
        Assertions.assertThat(statefulService.order("A", 10000)).isNotSameAs(statefulService2.order("B", 40000));
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();

        }


    }

}