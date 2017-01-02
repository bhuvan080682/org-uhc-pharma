package org.uhc.ws.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class pharmaAspects {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("execForAllGetters()")
	public void uhcLoggingAdviseBefore(){
		logger.info("Logging Advise called Before getAll()@@@@@@@@@@@@@");
	}
	
	@After("execForAllGetters()")
	public void uhcLoggingAdviseAfter(){
		logger.info("Logging Advise called After getAll()@@@@@@@@@@@@@");
	}
	
	@Pointcut("execution(* org.uhc.ws.service.*.get*(..))")
	public void execForAllGetters(){
		
	}
	
	@After("execution(* org.uhc.ws.service.*.save*(..))")
	public void execCreate(JoinPoint joinpoint){
		logger.info("create entity called>>>>>>>");
		logger.info("Args >>> "+joinpoint.getArgs().toString());
		logger.info("Signature >>>"+joinpoint.getSignature().toString());
		logger.info("class>>>"+joinpoint.getTarget().getClass().toString());
	}
	
	@After("execution(* org.uhc.ws.service.*.modify*(..))")
	public void execModify(JoinPoint joinpoint){
		logger.info("update entity called>>>>>>>");
		logger.info("Args >>> "+joinpoint.getArgs().toString());
		logger.info("Signature >>>"+joinpoint.getSignature().toString());
		logger.info("class>>>"+joinpoint.getTarget().getClass().toString());
	}
	
	/*
	 * Below aspects are not working need to identify the cause for it
	 */
	
	/*@Before("args(user)")
	public void welcomeAdvise(String user){
		logger.info("user logged in is :" + user);
	}*/
	
	/*@AfterReturning(pointcut="args(user)",returning="returnString")
	public void welcomeAdviseAfter(String user,Object returnString){
		logger.info("user logged in is :" + user);
	}*/
	
	/*@Around("execForAllGetters()")
	public void execAroundForDrugs(ProceedingJoinPoint proceedingJoinPoint){
		
		try{
			logger.info("proceeding Join Point before!!!!!!!");
			proceedingJoinPoint.proceed();
			logger.info("proceeding Join Point After return!!!!!!");
		}catch(Throwable ex){
			logger.info("proceeding Join points AFter throwing!!!!!!");
		}
		logger.info("proceeding Join points After finally!!!!!!");
	} */
	
}
