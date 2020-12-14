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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

        int score=0;

        Map<String, List<String>> allScores = new HashMap<String, List<String>>();

        Map<String, Float> weight = awosStateService.getBaseNormWeight("自观");
        String awosFormula = awosStateService.getAwosFormula("自观");
        allScores.put("自观",getAll(awosFormula, weight));



        awosFormula = messageStateService.getMessageFormula("报文");
        weight=messageStateService.getBaseNormWeight("报文");
        allScores.put("报文",getAll(awosFormula, weight));

        awosFormula = radarStateService.getRadarFormula("雷达图");
        weight=radarStateService.getBaseNormWeight("雷达图");
        allScores.put("雷达图",getAll(awosFormula, weight));


        awosFormula = satelStateService.getSatelFormula("卫星图");
        weight=satelStateService.getBaseNormWeight("卫星图");
        allScores.put("卫星图",getAll(awosFormula, weight));




        JsonResult result = new JsonResult();
        result.setMsg("返回总得分");
        result.setObj(allScores);
        return result;
    }


    public List<String> getAll(String formula,Map<String, Float> weight) {
        List<String> awosScore = new ArrayList<>();
        int index = formula.indexOf("=");
        float bili = 0f;
        for (Map.Entry<String, Float> m : weight.entrySet()) {
            bili+=m.getValue();
        }
        String bi1 = (int)(bili*100)+"%";
        String score = formula.substring(index+1);   // 自观总分
        awosScore.add(bi1);
        awosScore.add(score);
        return awosScore;

    }



}


