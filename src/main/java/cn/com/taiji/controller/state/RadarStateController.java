package cn.com.taiji.controller.state;

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
    private RadarStateService radarStateServicer;

    @GetMapping("/getNewRadar")
    public String getNewState(Model model){
        List<RadarState> radarStateList = radarStateServicer.getNewsState();
        model.addAttribute("radarStates", radarStateList);
        return "index";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取分组下面的监控指标
        catalogInfo = "雷达图";
        Map<String, List<DataType>> types = radarStateServicer.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        return "wel";
    }
}
