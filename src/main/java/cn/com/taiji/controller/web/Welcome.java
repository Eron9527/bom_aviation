package cn.com.taiji.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Welcome {




    /**
     * 跳转index.html页面
     * 首页内容需要
     *    1. 总分
     *    2. 各监控项得分
     *    3. 报文  最新状态：
     *    4. 自观  最新状态：
     *    5. 雷达图  最新状态：
     *    6. 卫星图   最新状态：
     *
     * @return
     */
    @RequestMapping("/index")
    public String indexHtml(ModelAndView model) {



        return "index";
    }

    @GetMapping("home")
    public String index() {
        return "wel";
    }
}


