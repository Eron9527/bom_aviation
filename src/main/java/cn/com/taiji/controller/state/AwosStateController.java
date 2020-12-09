package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.DataType;
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
    private AwosStateService awosStateServicer;

    @GetMapping("/getNewAwos")
    public String getNewState(Model model){
        List<AwosState> awosStateList = awosStateServicer.getNewsState();
        model.addAttribute("awosStates", awosStateList);
        return "wel";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取自观分组下面的监控指标
        catalogInfo = "自观";
        Map<String, List<DataType>> types = awosStateServicer.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        return "wel";
    }

}
