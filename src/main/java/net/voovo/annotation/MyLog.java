package net.voovo.annotation;

import lombok.AllArgsConstructor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;

@Target({METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyLog {
    String logMethod() default "unknown";
}
