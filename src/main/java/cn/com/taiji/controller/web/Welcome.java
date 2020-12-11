package cn.com.taiji.controller.web;

import cn.com.taiji.service.AwosStateService;
import cn.com.taiji.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/api/index")
public class Welcome {

    @Autowired
    private AwosStateService awosStateService;

    @RequestMapping("/getWholeScore")
    public JsonResult indexHtml(ModelAndView model) {



        return "index";
    }

    @GetMapping("home")
    public String index() {
        return "wel";
    }
}


