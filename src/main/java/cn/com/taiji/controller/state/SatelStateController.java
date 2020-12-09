package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.SatelState;
import cn.com.taiji.service.SatelStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/satel")
public class SatelStateController {

    @Autowired
    private SatelStateService satelStateServicer;

    @GetMapping("/getNewSatel")
    public String getNewState(Model model){
        List<SatelState> satelStateList = satelStateServicer.getNewsState();
        model.addAttribute("satelStates", satelStateList);
        return "index";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取分组下面的监控指标
        catalogInfo = "卫星图";
        Map<String, List<DataType>> types = satelStateServicer.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        return "wel";
    }
}
