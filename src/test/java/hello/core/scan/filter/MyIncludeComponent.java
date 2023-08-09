package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   // 필드에 붙냐 클래스에 붙냐 type 이면 클래스에
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}
