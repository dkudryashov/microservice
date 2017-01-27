package ru;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by d.kudryashov on 27.01.2017.
 */
@RestController
public class LoggerController {

    @RequestMapping(value = "/logger", method = RequestMethod.GET)
    public void log(@RequestParam String text) {
        System.out.println(text);
    }

}
