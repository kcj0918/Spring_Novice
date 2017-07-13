package myspring.di.xml.test;

import org.junit.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.assertEquals;

public class HelloBeanJunitTest {
	ApplicationContext context;
	
	@Before
	public void init() {
		//IoC 컨테이너 생성
		//1.ApplicationContext 객체 생성
		context = new GenericXmlApplicationContext("classpath:config/beans.xml");
	}
	
	@Test
	public void test1() {
		//2. getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		//3. Hello의 sayHello() 호출
		assertEquals("Hello Spring", hello.sayHello());
		//3. Hello의 printer() 호출
		hello.print();
		
		//StringPrinter getBean()
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}

}
