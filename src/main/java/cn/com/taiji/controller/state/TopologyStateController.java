package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**
     * @描述 得到监控项
     *          监控项是点开得分页面后，加载到表格中的数据。 循环加在通过List
     *          把List<DataType>  加载到表中中</>
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getDataTypes")
    public JsonResult getTypeDetail(Model model,String catalogInfo) {
        // 获取网络拓扑分组下面的监控指标
        catalogInfo = "网络拓扑";
        // 指标项和监控项
        Map<String, List<DataType>> types = topologyStateService.getScoreDetail(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(types);
        result.setMsg("指标项和监控项信息");
        return result;
    }

    /**
     * @描述   得到指标实体
     *             是点击得分后，
     *             BaseNormType : info 字段： 显示在表头的位置。
     *                           formula  ：  显示在公式的位置
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getBaseNorm")
    public JsonResult getformula(Model model,String catalogInfo) {
        // 计算公式及监控指标实体
        catalogInfo = "网络拓扑";
        Map<String, BaseNormType> formula = topologyStateService.getFormula(catalogInfo);
        List<BaseNormType> normTypes = new ArrayList<BaseNormType>();
        for (Map.Entry<String, BaseNormType> entry : formula.entrySet()) {
            normTypes.add(entry.getValue());
        }
        JsonResult result = new JsonResult();
        result.setObj(normTypes);
        result.setMsg("计算公式及监控指标实体");
        return result;
    }

    /**
     * @描述    得到分数
     *              是点击得分后，
     *      *       key: 跑道现场环境实时状态     value:   score
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScores")
    public JsonResult getScore(Model model,String catalogInfo) {
        // 得分（根据计算公式得出结果）
        catalogInfo = "网络拓扑";
        Map<String, Integer> score = topologyStateService.getBaseNormScore(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(score);
        result.setMsg("得分（根据计算公式得出结果）");
        return result;
    }

    /**
     * @描述    得到百分比方案
     *              key:  跑道现场环境实时状态     , value : 百分比
     *
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScheme")
    public JsonResult getScheme(Model model,String catalogInfo) {
        catalogInfo = "网络拓扑";
        // 总分计算：  S1*90%+S2*5%+S3*5%=90  //返回每个监控指标所代表的百分比
        Map<String, Float> scheme= topologyStateService.getBaseNormWeight(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(scheme);
        result.setMsg("返回每个监控指标所代表的百分比");
        return result;
    }

    /**
     * @描述   得到得分页面的得分表达式， 及总分， 到时候在页面上把等号后的分数截取，放大显示
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getTopologyFormula")
    public JsonResult getTopologyFormula(String catalogInfo){
        catalogInfo = "网络拓扑";
        String awosFormula = topologyStateService.getTopologyFormula(catalogInfo);
        List<String> formulaScore = new ArrayList<>();
        int index = awosFormula.indexOf("=");
        String score = awosFormula.substring(index+1);
        formulaScore.add(awosFormula);
        formulaScore.add(score);
        JsonResult result = new JsonResult();
        result.setObj(formulaScore);
        result.setMsg("得分界面总分表达式");
        return result;
    }
}
