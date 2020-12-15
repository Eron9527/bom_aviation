package cn.com.taiji.controller.web;

import cn.com.taiji.service.*;
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
    @Autowired
    private TopologyStateService topologyStateService;

    static int addScore=0;

    @RequestMapping("/getAddScore")
    public JsonResult indexAddHtml(ModelAndView model) {
        addScore = 0;
        this.indexHtml();
        JsonResult result = new JsonResult();
        result.setMsg("返回总得分");
        result.setObj(addScore);
        return result;
    }

    @RequestMapping("/getWholeScore")
    public JsonResult indexHtml() {

        int score=0;

        Map<String, List<String>> allScores = new HashMap<String, List<String>>();

        String awosFormula = awosStateService.getAwosFormula("自观");
        Map<String, Float> weight = awosStateService.getBaseNormWeight("自观");
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

        awosFormula = topologyStateService.getTopologyFormula("网络拓扑");
        weight=topologyStateService.getBaseNormWeight("网络拓扑");
        allScores.put("网络拓扑",getAll(awosFormula, weight));


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
        String score = formula.substring(index+2);   // 自观总分

        float add = Integer.valueOf(score)*bili;
        System.out.println("formula:"+Math.round(add));
        addScore+=Math.round(add);
        String bi1 = (Math.round(bili*100))+"%";
        awosScore.add(bi1);
        awosScore.add(score);
        return awosScore;

    }



}


