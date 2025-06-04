package com.example.sample.sample_fortune.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sample.sample_fortune.service.SampleService;


@Controller
public class SampleController {
    private final SampleService sampleService;

    public SampleController(SampleService sampleService){
        this.sampleService = sampleService;
    }

    @PostMapping("/result")
    public String sample(@RequestParam String name,
                         @RequestParam int age,
                         Model model){
        String result = sampleService.getFortune();
        model.addAttribute("result",result);
        model.addAttribute("name",name);
        model.addAttribute("age",age);


        return "sample";
    }

    @GetMapping("/page1")
    public String paga1(){
        return "page1";
    }

    @GetMapping("/page2")
    public String paga2(){
        return "page2";
    }

    @GetMapping("/form")
    public String form(){
        return "form";
    }
    
}
