package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.MessageState;
import cn.com.taiji.service.MessageStateService;
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
@RequestMapping("/api/message")
@CrossOrigin
public class MessageStateController {

    @Autowired
    private MessageStateService messageStateService;

    @GetMapping("/getNewMessage")
    public JsonResult getNewState(Model model) {
        List<MessageState> messageStateList = messageStateService.getNewsState();
        JsonResult result = new JsonResult();
        result.setObj(messageStateList);
        result.setMsg("返回报文最新信息");
        return result;
    }

    /**
     * @描述 得到监控项
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getDataTypes")
    public JsonResult getTypeDetail(Model model, String catalogInfo) {
        // 获取报文分组下面的监控指标
        catalogInfo = "报文";
        // 指标项和监控项
        Map<String, List<DataType>> types = messageStateService.getScoreDetail(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(types);
        result.setMsg("指标项和监控项信息");
        return result;
    }

    /**
     * @描述 得到指标实体
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getBaseNorm")
    public JsonResult getformula(Model model, String catalogInfo) {
        // 计算公式及监控指标实体
        catalogInfo = "报文";
        Map<String, BaseNormType> formula = messageStateService.getFormula(catalogInfo);
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
     * @描述 得到分数
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScores")
    public JsonResult getScore(Model model, String catalogInfo) {
        // 得分（根据计算公式得出结果）
        catalogInfo = "报文";
        Map<String, Integer> score = messageStateService.getBaseNormScore(catalogInfo);
        JsonResult result = new JsonResult();
        result.setObj(score);
        result.setMsg("得分（根据计算公式得出结果）");
        return result;
    }

    /**
     * @描述 得到百分比方案
     * @创建人 Mayu
     * @创建时间 2020/12/11
     */
    @GetMapping("/getScheme")
    public JsonResult getScheme(Model model, String catalogInfo) {
        catalogInfo = "报文";
        // 总分计算：  S1*90%+S2*5%+S3*5%=90  //返回每个监控指标所代表的百分比
        Map<String, Float> scheme = messageStateService.getBaseNormWeight(catalogInfo);
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
    @GetMapping("/getMessageFormula")
    public JsonResult getMessageFormula(String catalogInfo){
        catalogInfo = "报文";
        String messageFormula = messageStateService.getMessageFormula(catalogInfo);
        List<String> formulaScore = new ArrayList<>();
        int index = messageFormula.indexOf("=");
        String score = messageFormula.substring(index+1);
        formulaScore.add(messageFormula);
        formulaScore.add(score);
        JsonResult result = new JsonResult();
        result.setObj(formulaScore);
        result.setMsg("得分界面总分表达式");
        return result;
    }
}