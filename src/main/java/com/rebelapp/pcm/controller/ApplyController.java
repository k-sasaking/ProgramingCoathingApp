package com.rebelapp.pcm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplyController {

    @RequestMapping(value = "/apply", method = RequestMethod.GET)
    public String detail(Model model) {
        return "apply/apply_form";
    }
	
}
