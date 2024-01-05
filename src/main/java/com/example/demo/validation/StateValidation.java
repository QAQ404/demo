package com.example.demo.validation;

import com.example.demo.anno.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
                                        //Con...Vali...<给哪个注解提供校验规则，校验的数据类型>
public class StateValidation implements ConstraintValidator<State,String> {
                                            /**
                                             *
                                             * @param value 将来要校验的数据
                                             * @param context
                                             * @return 如果返回false，则校验不通过，如果返回true则通过
                                             */

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        //提供校验规则
        if(value == null) return false;
        if(value.equals("已发布")||value.equals("草稿")) return true;
        return false;
    }
}
