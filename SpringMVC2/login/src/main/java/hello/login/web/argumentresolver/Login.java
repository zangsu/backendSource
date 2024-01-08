package hello.login.web.argumentresolver;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //파라미터에서 사용할것이고,
@Retention(RetentionPolicy.RUNTIME) //동작할때까지 어노테이션을 유지시켜 주어야 한다.
public @interface Login {
}
