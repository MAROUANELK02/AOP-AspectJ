package com.aop.springaop.services;

import com.aop.springaop.aspects.Log;
import com.aop.springaop.aspects.SecuredByAspect;
import org.springframework.stereotype.Service;

@Service
public class IMetierImpl implements IMetier {
    @Override
    @Log
    @SecuredByAspect(roles={"USER", "ADMIN"})
    public void process() {
        System.out.println("Business processing ...");
    }

    @Override
    @SecuredByAspect(roles={"ADMIN"})
    public double compute() {
        double data=80;
        System.out.println("Business Computing and returning result ....");
        return data;
    }
}
