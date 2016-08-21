package edu.ucdavis.afs.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
    public String index() {
        return "UCD Java Developer Coding Test";
    }
}
