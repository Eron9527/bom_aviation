package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.NormOfScheme;
import cn.com.taiji.service.AwosStateService;
import cn.com.taiji.utils.JsonResult;
import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/awos")
public class AwosStateController<add> {

    @Autowired
    private AwosStateService awosStateService;

    @GetMapping("/getNewAwos")
    public JsonResult getNewState(Model model){
        List<AwosState> awosStateList = awosStateService.getNewsState();
        JsonResult result = new JsonResult();
        result.setObj(awosStateList);
        result.setMsg("返回自观最新情况");
        return result;
    }

    /**
     * @描述 得到监控项
     * @创建人 Mayu
     * @创建时间 2020/12/11
    */
    @GetMapping("/getDataTypes")
    public JsonResult getTypeDetail(Model model,String catalogInfo) {
        // 获取自观分组下面的监控指标
        catalogInfo = "自观";
        // 指标项和监控项
        Map<String, List<DataType>> types = awosStateService.getScoreDetail(catalogInfo);
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
        catalogInfo = "自观";
        Map<String, BaseNormType> formula = awosStateService.getFormula(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(formula);
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
        catalogInfo = "自观";
        Map<String, Integer> score = awosStateService.getBaseNormScore(catalogInfo);
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
        catalogInfo = "自观";
        // 总分计算：  S1*90%+S2*5%+S3*5%=90  //返回每个监控指标所代表的百分比
        Map<String, Float> scheme= awosStateService.getBaseNormWeight(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(scheme);
        result.setMsg("返回每个监控指标所代表的百分比");
        return result;
    }
}
