package org.jinblog.git_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class moveController {

    @GetMapping(value= {"/","/index","/home",""})
    public String homeMove(Model model) {
        model.addAttribute("mode", "home");
        return "content/index";
    }

    @GetMapping("/moveLogin")
    public String moveLogin() {
        return "content/login/loginForm";
    }
}
