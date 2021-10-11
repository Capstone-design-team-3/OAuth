package org.capstone.team3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MyOauthController {

    @GetMapping("/my-oauth/authorize")
    public String codeForm(Model model){

        model.addAttribute("form", new CodeGrantForm());
        return "my-oauth/authorize";
    }

    @PostMapping("/my-oauth/authorize")
    public String code(){

        return "my-oauth/authorize";
    }

    @GetMapping("/my-oauth/token")
    public String tokenForm(){

        return "my-oauth/token";
    }
}
