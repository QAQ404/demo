package com.example.demo.anno;

import com.example.demo.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;

import java.lang.annotation.*;

@Documented
@Constraint(
        validatedBy = {StateValidation.class} //指定提供校验规则的类
)
@Target({ElementType.FIELD}) //可以生效在什么上，这个field是属性
@Retention(RetentionPolicy.RUNTIME)  //这个意思是在程序运行的使用

public @interface State {
    //校验失败后的提示
    String message() default "state参数的值只能是已发布或者草稿";

    //指定分组
    Class<?>[] groups() default {};

    //负载 获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
