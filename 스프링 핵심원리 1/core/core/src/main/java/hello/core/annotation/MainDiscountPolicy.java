package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")//이 위로의 annotation을 붙여주면 이제, @Qualifier("mainDiscountPolicy") annotation에 대해 아래 코드가 동작하는듯.
public @interface MainDiscountPolicy {
}
