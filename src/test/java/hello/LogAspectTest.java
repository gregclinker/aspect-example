package hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LogAspectTest {

	@Autowired
	private FooService service;

	@Autowired
	private LogAspect aspect;

	@Test
	public void test1() throws Exception {
		service.doSomething();
		assertEquals(1, aspect.getMessages().size());
		System.out.println(aspect.getMessages().get(0));
	}
}
