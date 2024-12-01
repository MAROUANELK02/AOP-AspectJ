package com.j2e.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

@Aspect
public class SecondAspect {
    @Pointcut("execution(* com.j2e.test.Main.main(..))")
    public void pc1() {}

    /*@Before("pc1()")
    public void before() {
        System.out.println("Before main from Aspect with class syntax");
    }

    @After("pc1()")
    public void after() {
        System.out.println("After main from Aspect with class syntax");
    }*/

    @Around("pc1()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) {
        System.out.println("Before main from Aspect with around class syntax");
        try {
            proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        System.out.println("Around main from Aspect with around class syntax");
    }
}
