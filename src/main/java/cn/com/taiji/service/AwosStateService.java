package cn.com.taiji.service;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;

import java.util.List;
import java.util.Map;

public interface AwosStateService {


    /**
     * @描述  为自观添加状态
     * @创建人 Mayul
     * @创建时间 2020/12/8
    */
    public void add();

    /**
     * @描述  获取自观最新状态
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    List<AwosState> getNewsState();

    /**
     * @描述   获取跳转页面后的监控指标、 参与打分指标
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    Map<String, List<DataType>> getScoreDetail(String catalogInfo);
}
