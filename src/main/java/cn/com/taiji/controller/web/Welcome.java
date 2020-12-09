package cn.com.taiji.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Welcome {
    /**
     * 跳转index.html页面
     * @return
     */
    @RequestMapping("/index")
    public String indexHtml() {
        return "index";
    }

    @GetMapping("home")
    public String index() {
        return "wel";
    }
}


