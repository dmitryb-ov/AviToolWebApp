package com.avitool.develop.avitool.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class Logging {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
//    private org.apache.log4j.Logger logger = Logger.getLogger(this.getClass());
//    private CustomAppender appender = new CustomAppender();

//    public Logging(){
//        BasicConfigurator.configure();
//        logger.addAppender(appender);
//    }

    @Pointcut("execution(public * com.avitool.develop.avitool.service.*.*(..))")
    public void callService() {
    }

    @Pointcut("@annotation(com.avitool.develop.avitool.annotations.CheckPhoneNumber)")
    public void callAnnotation() {
    }

    @Before("callService()")
    public void beforeAdvice(JoinPoint joinPoint) {
        String s = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before " + joinPoint.toString() + " , parameters=(" + s + ")");
//        for (LoggingEvent loggingEvent: appender.eventsList){
//            System.out.println("QQQQQ: "+loggingEvent.getMessage());
//        }
    }

    @After("callService()")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("after " + joinPoint.toString());
    }

    @AfterThrowing(pointcut = "execution(* com.avitool.develop.avitool.service.generators.UserAgentGeneratorImpl.generate())",
            throwing = "error")
    public void logInDBNotFound(JoinPoint joinPoint, Throwable error) {
        logger.error("Exception: " + joinPoint.toString() + " Message: " + error.getMessage());
    }

    @Before("callAnnotation()")
    public void beforeCallAnnotation(JoinPoint joinPoint) {
        String s = Arrays.stream(joinPoint.getArgs())
                .map(Object::toString)
                .collect(Collectors.joining(","));
        logger.info("before annotation" + joinPoint.toString() + " , parameters=(" + s + ")");
    }

    @After("callAnnotation()")
    public void afterCallAnnotation(JoinPoint joinPoint) {
        logger.info("after " + joinPoint.toString());
    }
}
