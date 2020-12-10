package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.NormOfScheme;
import cn.com.taiji.service.AwosStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/awos")
public class AwosStateController {

    @Autowired
    private AwosStateService awosStateService;

    @GetMapping("/getNewAwos")
    public String getNewState(Model model){
        List<AwosState> awosStateList = awosStateService.getNewsState();
        model.addAttribute("awosStates", awosStateList);
        return "wel";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取自观分组下面的监控指标
        catalogInfo = "自观";
        // 指标项和监控项
        Map<String, List<DataType>> types = awosStateService.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        // 计算公式及监控指标实体
        Map<String, BaseNormType> formula = awosStateService.getFormula(catalogInfo);
        model.addAttribute("formula", formula);
        // 得分（根据计算公式得出结果）
        Map<String, Integer> score = awosStateService.getBaseNormScore(catalogInfo);
        model.addAttribute("score", score);
        // 总分计算：  S1*90%+S2*5%+S3*5%=90  //返回每个监控指标所代表的百分比
        Map<String, Float> scheme= awosStateService.getBaseNormWeight(catalogInfo);
        model.addAttribute("scheme", scheme);
        // 得分占比饼图
        return "wel";
    }

}
