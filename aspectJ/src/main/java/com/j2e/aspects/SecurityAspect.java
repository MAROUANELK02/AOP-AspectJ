package com.j2e.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Scanner;

@Aspect
public class SecurityAspect {
    @Around("call(* com.j2e.test.Application.start(..))")
    public void secureApp(JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Authentication");
        System.out.print("Username :");
        String username=scanner.next();
        System.out.print("Password :");
        String pass=scanner.next();
        if(username.equals("root") && pass.equals("123")) {
            System.out.println("Before starting");
            proceedingJoinPoint.proceed();
            System.out.println("End of Application");
        }
        else{
            System.out.println("Access denied ...");
        }
    }
}
