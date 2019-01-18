package com.example.SpringbootDemo;

import com.example.SpringbootDemo.mongodb.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Controller
public class SpringbootDemoApplicationTests {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFindUserByName() {
		String name = "moonlo";
		Query query = new Query(Criteria.where("testName").is(name));
		List<User> users = mongoTemplate.find(query, User.class);
		System.out.println("============结果输出:" + users.get(0).getTestName());
	}

}

