package com.brainstormer.controller;


import com.brainstormer.entity.User;
import com.brainstormer.model.Greeting;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@PreAuthorize("hasRole('ADMIN')")
public class GreetingController {

	private static final String template = "Hello, %s!";

	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@AuthenticationPrincipal User user) {
		return new Greeting(counter.incrementAndGet(),
				String.format(template, user.getName()));
	}

}
