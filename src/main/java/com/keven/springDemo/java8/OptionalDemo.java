package com.keven.springDemo.java8;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalDemo {

	public static void demo() {

		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia", "aqila", null);
		Optional<List<String>> name = Optional.of(names);

		// 获取值
		System.out.println(name.get());

		// 选择
		User user = null;
		User user2 = new User("aaa", "987@");
		User user3 = new User("aaa", null);
		User result = Optional.ofNullable(user).orElse(user2);
		System.out.println(result.getName());

		// 抛出异常
		User result2 = Optional.ofNullable(user2).orElseThrow(() -> new IllegalArgumentException());

		// 转换值
		String email = Optional.ofNullable(user3).map(u -> u.getEmail()).orElse("default@gmail.com");
		System.out.println(email);

		// 验证电子账户
		Optional<User> result3 = Optional.ofNullable(user)
				.filter(u -> u.getEmail() != null && u.getEmail().contains("@"));
		System.out.println(result3.isPresent()?null:result3.get());

	}

	public static void main(String[] args) {
		demo();
	}

}
