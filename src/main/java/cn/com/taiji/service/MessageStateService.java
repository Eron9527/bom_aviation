package cn.com.taiji.service;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.MessageState;

import java.util.List;
import java.util.Map;

public interface MessageStateService {

    /**
     * @描述  添加
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    public void add();

    /**   获取最新状态
     * @描述
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    List<MessageState> getNewsState();

    /**
     * @描述   获取跳转页面后的监控指标、 参与打分指标
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    Map<String, List<DataType>> getScoreDetail(String catalogInfo);

    /**
     * @描述   获取计算公式和监控指标实体
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    Map<String, BaseNormType> getFormula(String catalogInfo);

    /**
     * @描述   获取每个指标项的得分
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    Map<String, Integer> getBaseNormScore(String catalogInfo);

    /**
     * @描述   获取每个指标项的所占的百分比
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    Map<String, Float> getBaseNormWeight(String catalogInfo);

    /**
     * @描述   获取所有指标项所凑成的公式。及分数结果。
     * @创建人 Mayu
     * @创建时间 2020/12/11
    */
    String getMessageFormula(String catalogInfo);
}
