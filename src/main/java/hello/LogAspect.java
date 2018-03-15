package hello;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {

	private List<String> messages = new ArrayList<>();

	@Around("@annotation(hello.LogExecutionTime)")
	public Object handelLogging(ProceedingJoinPoint joinPoint) throws Throwable {

		Object proceed = null;
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		proceed = joinPoint.proceed();
		stopWatch.stop();
		messages.add("method " + joinPoint.getSignature().getName() + " took " + stopWatch.getTotalTimeMillis() + "ms");
		return proceed;
	}

	public List<String> getMessages() {
		return messages;
	}
}