package ru;

import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

/**
 * Created by d.kudryashov on 27.01.2017.
 */
@RestController
public class BankController {

    private Long account = 0L;
    private LoggerClient loggerClient;

    @PostConstruct
    public void init() {
        loggerClient = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(LoggerClient.class, "http://localhost:8081");
    }


    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public Long getAccount() {
        loggerClient.log("GET request: info, response: " + account);
        return account;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public void putAccount(@RequestParam Long money) {
        account += money;
        loggerClient.log("PUT request: /, response: " + account);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void postAccount(@RequestParam Long money) {
        account -= money;
        loggerClient.log("POST request: /, response: " + account);
    }


}
