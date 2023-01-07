package com.example.tcp;

import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class Session {
    @ModelAttribute("user")
    public User setUserFrom() {
        return new User();
    }
}
