package net.voovo.annotation;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLogImpl{

    /*当ioc bean实例化的时候, 才会触发aop, 然后NutIoc的所有ioc bean都是懒加载, 第一次使用的时候才会初始化
      makeIt是对应一个个方法的, 每个方法对应一个aop拦截器列表. 有多少个被aop拦截的方法, 就会调用多少次makeIt*/
    @Before("execution (* net.voovo..*Controller.*(..)) && @annotation(limit)")
    public void requestLimit(final JoinPoint joinPoint, MyLog limit) throws Exception {
        Object[] args = joinPoint.getArgs();
        System.out.println(1);
        System.out.println(joinPoint.getTarget().getClass().getSimpleName());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(JSONObject.toJSONString(args));
    }
}
