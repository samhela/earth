package edu.mum.cs.cs544.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by samue on 2/6/2017.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String indexHome(Model model){
        System.out.println("Controller is called");
        return "index";
    }
}
