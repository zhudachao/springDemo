package com.keven.springDemo.redis;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
	
	
	@RequestMapping("/uid")
	String uid(HttpSession session) {
	    UUID uid = (UUID) session.getAttribute("uid");
	    if (uid == null) {
	        uid = UUID.randomUUID();
	    }
	    session.setAttribute("uid", uid);
	    return session.getId();
	}
	
}

