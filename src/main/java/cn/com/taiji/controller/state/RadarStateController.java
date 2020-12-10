package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.RadarState;
import cn.com.taiji.service.RadarStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/radar")
public class RadarStateController {

    @Autowired
    private RadarStateService radarStateService;

    @GetMapping("/getNewRadar")
    public String getNewState(Model model){
        List<RadarState> radarStateList = radarStateService.getNewsState();
        model.addAttribute("radarStates", radarStateList);
        return "index";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取分组下面的监控指标
        catalogInfo = "雷达图";
        Map<String, List<DataType>> types = radarStateService.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        // 计算公式及监控指标实体
        Map<String, BaseNormType> formula = radarStateService.getFormula(catalogInfo);
        model.addAttribute("formula", formula);
        // 得分（根据计算公式得出结果）
        Map<String, Integer> score = radarStateService.getBaseNormScore(catalogInfo);
        model.addAttribute("score", score);
        //返回每个监控指标所代表的百分比
        Map<String, Float> scheme= radarStateService.getBaseNormWeight(catalogInfo);
        model.addAttribute("scheme", scheme);
        return "wel";
    }
}
