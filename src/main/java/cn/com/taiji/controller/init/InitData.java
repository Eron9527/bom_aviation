package cn.com.taiji.controller.init;

import cn.com.taiji.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *    通过调用Service 中的add 方法，为数据库中的表数据添加数据。
 */


@Controller
public class InitData {

    @Autowired
    private InitStateDataService initStateDataServicer;
    @Autowired
    private InitScoreRuleDataService initScoreRuleDataServicer ;


    @GetMapping("/initData")
    public String initData(){
        //  添加状态数据
        System.out.println("----------开始生成数据---------");
        //initStateDataServicer.initStateData();
        System.out.println("----------生成状态数据结束---------");
        //initScoreRuleDataServicer.initRuleData();
        System.out.println("----------生成评分数据结束---------");

        return "wel";
    }

}
