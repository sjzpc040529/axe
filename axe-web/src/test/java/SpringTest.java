import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

	 public static void main(String[] args) {
		 ApplicationContext ctx = new ClassPathXmlApplicationContext("application-context.xml");
		 Object userMapper = ctx.getBean("userMapper");
		 System.out.println(userMapper);
	 }
}
