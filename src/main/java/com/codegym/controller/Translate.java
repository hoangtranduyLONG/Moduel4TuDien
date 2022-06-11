package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Controller
public class Translate {
    Map<String, String> dic = new HashMap();

    @GetMapping("")
    public ModelAndView showList() {
        return new ModelAndView("");
    }

    @PostMapping("/translate")
    public ModelAndView translate(@RequestParam("english") String english) {
        dic.put("House", "Ngôi nhà");
        dic.put("Lion", "Sư tử");
        dic.put("Engineer", "Kỹ Sư");
        dic.put("Tea", "Trà");
        dic.put("Coffee", "Cà Phê");
        Set<String> key = dic.keySet();
        ModelAndView modelAndView = new ModelAndView("index");
        for (String k : key) {
            if (k.equals(english)) {
                modelAndView.addObject("TV", dic.get(k));
                break;
            }
            else {
                modelAndView.addObject("TV", "Not Found");
            }
        }
        return modelAndView;
    }

}
