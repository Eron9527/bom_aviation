package cn.com.taiji.service;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.MessageState;

import java.util.List;
import java.util.Map;

public interface MessageStateService {

    /**
     * @描述  添加
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    public void add();

    /**   获取最新状态
     * @描述
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    List<MessageState> getNewsState();

    /**
     * @描述   获取跳转页面后的监控指标、 参与打分指标
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    Map<String, List<DataType>> getScoreDetail(String catalogInfo);
}
