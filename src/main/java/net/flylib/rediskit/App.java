package net.flylib.rediskit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext("appContext.xml");
		RedisClient redisClient = appContext.getBean("redisClient", RedisClient.class);
		test(redisClient);
		System.out.println("End.");
	}
	
	private static void test(RedisClient client) {
    	String k = "key1";
    	client.set(k, "aaa");
    	System.out.println("value of " + k + " is: "  + client.get(k));
	}
}
