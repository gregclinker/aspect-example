package hello;

import org.springframework.stereotype.Service;

@Service
public class FooService {

	@LogExecutionTime
	public void doSomething() {
		try {
			Thread.sleep(500l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
