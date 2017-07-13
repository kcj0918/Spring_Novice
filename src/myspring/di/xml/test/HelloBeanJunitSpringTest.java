package myspring.di.xml.test;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

import static org.junit.Assert.*;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	@Autowired
	ApplicationContext context;
	
	@Test 
	public void test1() {
		//2. getBean() 호출
		Hello hello = (Hello)context.getBean("hello2");
		//3. Hello의 sayHello() 호출
		assertEquals("Hello Spring", hello.sayHello());
		//3. Hello의 printer() 호출
		hello.print();
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		for(String value : list) {
			System.out.println(value);
		}
		
		//StringPrinter getBean()
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
	
	@Test @Ignore
	public void test2() {
		//2. getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		
		Hello hello2 = (Hello)context.getBean("hello");
		
		assertSame(hello, hello2);
	}

}
