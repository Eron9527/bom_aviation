package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.RadarState;
import cn.com.taiji.service.RadarStateService;
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
@RequestMapping("/api/radar")
@CrossOrigin
public class RadarStateController {

    @Autowired
    private RadarStateService radarStateService;

    @GetMapping("/getNewRadar")
    public JsonResult getNewState(Model model){
        List<RadarState> radarStateList = radarStateService.getNewsState();
        JsonResult result = new JsonResult();
        result.setObj(radarStateList);
        result.setMsg("返回雷达最新信息");
        return result;
    }

    /**
     * @描述 得到监控项
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getDataTypes")
    public JsonResult getTypeDetail(Model model, String catalogInfo) {
        // 获取雷达分组下面的监控指标
        catalogInfo = "雷达图";
        // 指标项和监控项
        Map<String, List<DataType>> types = radarStateService.getScoreDetail(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(types);
        result.setMsg("指标项和监控项信息");
        return result;
    }

    /**
     * @描述   得到指标实体
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getBaseNorm")
    public JsonResult getformula(Model model,String catalogInfo) {
        // 计算公式及监控指标实体
        catalogInfo = "雷达图";
        Map<String, BaseNormType> formula = radarStateService.getFormula(catalogInfo);
        JsonResult result = new JsonResult();
        List<BaseNormType> normTypes = new ArrayList<BaseNormType>();
        for (Map.Entry<String, BaseNormType> entry : formula.entrySet()) {
            normTypes.add(entry.getValue());
        }
        result.setObj(normTypes);
        result.setMsg("计算公式及监控指标实体");
        return result;
    }

    /**
     * @描述    得到分数
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScores")
    public JsonResult getScore(Model model,String catalogInfo) {
        // 得分（根据计算公式得出结果）
        catalogInfo = "雷达图";
        Map<String, Integer> score = radarStateService.getBaseNormScore(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(score);
        result.setMsg("得分（根据计算公式得出结果）");
        return result;
    }

    /**
     * @描述    得到百分比方案
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScheme")
    public JsonResult getScheme(Model model,String catalogInfo) {
        catalogInfo = "雷达图";
        // 总分计算：  S1*90%+S2*5%+S3*5%=90  //返回每个监控指标所代表的百分比
        Map<String, Float> scheme= radarStateService.getBaseNormWeight(catalogInfo);
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
    @GetMapping("/getRadarFormula")
    public JsonResult getRadarFormula(String catalogInfo){
        catalogInfo = "雷达图";
        String radarFormula = radarStateService.getRadarFormula(catalogInfo);
        List<String> formulaScore = new ArrayList<>();
        int index = radarFormula.indexOf("=");
        String score = radarFormula.substring(index+1);
        formulaScore.add(radarFormula);
        formulaScore.add(score);
        JsonResult result = new JsonResult();
        result.setObj(formulaScore);
        result.setMsg("得分界面总分表达式");
        return result;
    }
}
