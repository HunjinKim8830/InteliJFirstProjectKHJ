package org.jinblog.git_test.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/moveAdminForm")
    public String moveAdminForm() {
        return "content/admin/adminForm";
    }

    @GetMapping("/moveMypage")
    public String moveMypage() {
        return "content/mypage/mypageForm";
    }



}
