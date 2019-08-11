package com.aqdamnaseem.projects.employee.management.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MethodLoggingAspect {

	private static Map<Class<?>, Logger> loggerMap = new HashMap<Class<?>, Logger>();

	@Around("execution(* com.aqdamnaseem.projects..*.*(..)) && !execution(* com.aqdamnaseem.projects..*.get*(..)) && !execution(* com.aqdamnaseem.projects..*.set*(..))")
	public Object logMethodInformation(ProceedingJoinPoint joinPoint) throws Throwable {
		Object result = null;
		Logger logger = null;
		String methodName = null;
		try {
			logger = getLogger(joinPoint.getSignature().getDeclaringType());
			methodName = joinPoint.getSignature().getName();
			if (null != joinPoint.getArgs() && joinPoint.getArgs().length > 0) {
				Object[] args = joinPoint.getArgs();
				int i = 0;
				for (Object element : args) {
					logger.info(methodName + " arg[" + i++ + "]: ", new Object[] { element });
				}
			}
			result = joinPoint.proceed();
		} catch (Throwable ex) {
			logger.error("Exception thrown while processing: " + methodName, ex);
			throw ex;
		} finally {
			if (null != result) {
				logger.info("\tReturn value: \t", new Object[] { result });
			}
		}
		return result;
	}

	/**
	 * @param clazz
	 * @return
	 */
	private Logger getLogger(Class<?> clazz) {
		if (clazz == null) {
			return LoggerFactory.getLogger(MethodLoggingAspect.class);
		}
		Logger logger = loggerMap.get(clazz);
		if (logger == null) {
			logger = LoggerFactory.getLogger(clazz);
			loggerMap.put(clazz, logger);
		}
		return logger;
	}
}
