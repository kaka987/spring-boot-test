package com.young.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

/**
 * Created by ygzhang on 5/24/17.
 */
@RestController
public class GreetingController {
    private static final String template = "Hello %s!";
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {

        logger.info("This is a info log.");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

}
