package app.rest.data;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by joaok on 09/06/2018.
 */
@Aspect
@Configuration
public class AutoshopAspectHandler {

	@Autowired
	private HttpServletRequest request;

	private Logger logger = LoggerFactory.getLogger(AutoshopAspectHandler.class);

	@Before("execution(* app.rest.*.*(..))")
	public void before(JoinPoint _joinPoint) {
		MethodInvocationProceedingJoinPoint joinPoint = (MethodInvocationProceedingJoinPoint) _joinPoint;
		String method = joinPoint.getSignature().getName();
		logger.info("\t\t'" + method + "' was called.");
	}

	@Before("execution (* app.rest.InboundAutoshop.*(..))")
	public void checkCredentials(JoinPoint _joinPoint) {
		MethodInvocationProceedingJoinPoint joinPoint = (MethodInvocationProceedingJoinPoint) _joinPoint;
		Map<String, String> headers = (Map<String, String>) joinPoint.getArgs()[0];
		String clientId = headers.get("client-id");
		String endpoint = request.getRequestURI();
		logger.info("\t\t'" + clientId + "' was granted entry to resource '" + endpoint + "'.");
	}

	@AfterReturning(value = "execution(* app.rest.*.*(..))",
					returning = "result")
	public void after(JoinPoint _joinPoint, Object result) {
		MethodInvocationProceedingJoinPoint joinPoint = (MethodInvocationProceedingJoinPoint) _joinPoint;
		String message;
		String method = joinPoint.getSignature().getName();
		if (result instanceof List) {
			int numOfReturnedItems = ((List) result).size();
			message = "\t\t'" + method + "' executed and returned '" + numOfReturnedItems + "' items.";
		} else {
			message = "\t\t'" + method + "' executed and returned an instance of '" + result.getClass().getName() + "'.";
		}
		logger.info(message);
	}
}
