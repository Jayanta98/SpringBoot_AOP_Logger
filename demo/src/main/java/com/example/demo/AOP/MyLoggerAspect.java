package com.example.demo.AOP;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggerAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(MyLoggerAspect.class);
	
	@Around("@annotation(com.example.demo.annonation.EnableLoggTracer)")
	public Object loggTracer(ProceedingJoinPoint pjp ) throws Throwable {
		logger.info("Method Started :: ************************************");
		
		Long start = System.currentTimeMillis();
		
		Class<? extends ProceedingJoinPoint> cName=pjp.getClass();
		Signature singnature = pjp.getSignature();
		
		Long end = System.currentTimeMillis();
		logger.info("Method End :: ************************************");
		logger.info("Time Taken :: *******************"+(start-end)+"*****************");
		
		Object obj= pjp.proceed();
		return obj;
		
	
		
		
	
		
	}

}
