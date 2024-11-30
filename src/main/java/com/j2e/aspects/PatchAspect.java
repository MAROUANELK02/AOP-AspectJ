package com.j2e.aspects;

import com.j2e.metier.Compte;
import com.j2e.metier.IMetierBanque;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class PatchAspect {
    @Around("execution(* com.j2e.metier.IMetierBanqueImpl.retirer(..)) && args(code,mt)")
    public void patch(Long code, double mt, JoinPoint joinPoint, ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        IMetierBanque metier=(IMetierBanque) joinPoint.getTarget();
        Compte cp=metier.getCompte(code);
        if(cp.getSolde()>mt) {
            proceedingJoinPoint.proceed();
        }
        else {
            throw new RuntimeException("Solde insuffisant");
        }
    }
}
