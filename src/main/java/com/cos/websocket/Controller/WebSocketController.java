package com.cos.websocket.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebSocketController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
