package com.revature.p2.aspects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger log = LogManager.getLogger(LoggingAspect.class);

    private int counter = 0;

    // Advice - method - this is what we want Java to do when our hook method is run
    @Before("hookMethod()")
    public void logBefore() {
        log.info("The count of controller calls = " + ++counter);
    }

    @After(value = "hookMethod()", argNames = "joinPoint")
    public void logAfter(JoinPoint joinPoint) { // the name of the parameter must match argNames
        log.info(joinPoint.getSignature().getName() + " just finished executing. Counter = " + counter);
    }

    @AfterThrowing(pointcut = "within(dev.knapp.controllers.*)", throwing = "error")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
        log.warn(joinPoint.getSignature().getName() + " failed to execute.");
        log.error("Exception: " + error.getMessage());
    }

    //TODO add AfterReturning

//    @Around("hookMethod()")
//    public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//        log.info("This is the beginning of our advice");
//        joinPoint.getSignature();
//        joinPoint.proceed();
//        log.info("Does this print out?");
//        joinPoint.proceed();
//    }

    @Pointcut("within(dev.knapp.controllers.*)")
    public void hookMethod() {
        // Create a Hook Method: an empty method that serves as the target for our advice
        // It represents the method that would be called in our application's execution
        // We have it here so that we can 'intercept' that execution
    }


}
