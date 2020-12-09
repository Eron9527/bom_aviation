package cn.com.taiji.controller.state;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.MessageState;
import cn.com.taiji.service.MessageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/message")
public class MessageStateController {

    @Autowired
    private MessageStateService messageStateServicer;

    @GetMapping("/getNewMessage")
    public String getNewState(Model model){
        List<MessageState> messageStateList = messageStateServicer.getNewsState();
        model.addAttribute("messageStates", messageStateList);
        return "index";
    }

    @GetMapping("/getDetail")
    public String getScoreDetail(Model model,String catalogInfo){
        // 获取分组下面的监控指标
        catalogInfo = "报文";
        Map<String, List<DataType>> types = messageStateServicer.getScoreDetail(catalogInfo);
        model.addAttribute("types", types);
        return "wel";
    }
}
