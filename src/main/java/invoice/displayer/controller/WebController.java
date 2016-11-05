/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice.displayer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author konstantinos
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {
    
    @GetMapping("/index")
    public String showIndex() {
        return "index";
    }
    
}
