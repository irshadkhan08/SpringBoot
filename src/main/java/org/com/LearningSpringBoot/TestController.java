package org.com.LearningSpringBoot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

//@Controller  // @Controller is coming from Spring
@RestController // SpringBoot :combination of Controller and ResponseBody
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger("TestController.class");

    @GetMapping("/text")
//    @ResponseBody
    public String testController(){
        logger.info("This is my first log in SpringBoot",new Date());
        /*there are 5 methods in logger
        1 error
        2 warn
        3 info
        4 debug
        5 trace
         */
        logger.error("this is error mod logger");//error mod is print
        logger.warn("this is warn mod");// warn mod is print
        logger.info("this is info mod");//info mod is print
        logger.debug("this is debug mod");//debug is not print
        logger.debug("this is trace mod");//trace is not print

        System.out.println("all logger method");
        return "dummy text";
    }
    @GetMapping("/static-data")
    public ModelAndView getStaticData(){
        return new ModelAndView("demo.html");
    }
    @GetMapping("/dynamic-data")
    public ModelAndView getDynamicData(){
        ModelAndView modelAndView = new ModelAndView("ProductPage.html");
        modelAndView.getModelMap().addAttribute("name",1233);
        return modelAndView;
    }

    @PostMapping("/getData")
    public String getData(){
        return "post api";
    }
}
