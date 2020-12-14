package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.TopologySpeed;
import cn.com.taiji.domain.state.TopologyState;
import cn.com.taiji.service.TopologyStateService;
import cn.com.taiji.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/topology")
@CrossOrigin
public class TopologyStateController {

    @Autowired
    private TopologyStateService topologyStateService;

    @GetMapping("/getNewState")
    public JsonResult getNewState(Model model){
        List<TopologyState> stateList = topologyStateService.getNewsState();
        JsonResult result = new JsonResult();
        result.setObj(stateList);
        result.setMsg("返回最新的拓扑图信息");
        return result;
    }

    @GetMapping("/getNewSpeed")
    public JsonResult getNewsSpeed(Model model){
        List<TopologySpeed> speedList = topologyStateService.getNewsSpeed();
        JsonResult result = new JsonResult();
        result.setObj(speedList);
        result.setMsg("返回最新的拓扑图的网络连接速度");
        return result;
    }
}
