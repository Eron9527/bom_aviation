package cn.com.taiji.controller.web;

import cn.com.taiji.service.AwosStateService;
import cn.com.taiji.service.MessageStateService;
import cn.com.taiji.service.RadarStateService;
import cn.com.taiji.service.SatelStateService;
import cn.com.taiji.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 *  welcome Controller 为了便于页面展示，将总分计算逻辑直接写道welcome
 */

@RestController
@RequestMapping("/api/index")
public class Welcome {

    @Autowired
    private AwosStateService awosStateService;
    @Autowired
    private MessageStateService messageStateService;
    @Autowired
    private RadarStateService radarStateService;
    @Autowired
    private SatelStateService satelStateService;


    @RequestMapping("/getWholeScore")
    public JsonResult indexHtml(ModelAndView model) {

        awosStateService.getAwosFormula("自观");
        awosStateService.getBaseNormWeight("自观");
        messageStateService.getMessageFormula("报文");
        messageStateService.getBaseNormWeight("报文");
        radarStateService.getRadarFormula("雷达图");
        radarStateService.getBaseNormWeight("雷达图");
        satelStateService.getSatelFormula("卫星图");
        satelStateService.getBaseNormWeight("卫星图");


        JsonResult result = new JsonResult();
        result.setMsg("返回总得分");
        result.setObj(90);
        return result;
    }

    @GetMapping("getAllWeight")
    public JsonResult getAllWeight() {
        JsonResult result = new JsonResult();
        Map<String,Integer> weightMap = new HashMap<String,Integer>();

        result.setObj(11);
        return result;
    }
}


