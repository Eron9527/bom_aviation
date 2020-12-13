package cn.com.taiji.service;

import cn.com.taiji.domain.state.TopologySpeed;
import cn.com.taiji.domain.state.TopologyState;

import java.util.List;

public interface TopologyStateService {

    /**
     * @描述   添加
     * @创建人 Mayu
     * @创建时间 2020/12/13
    */
    public void add();

    /**
     * @描述   获取最新的设备信息
     * @创建人 Mayu
     * @创建时间 2020/12/13
    */
    List<TopologyState> getNewsState();

    /**
     * @描述   获取最新的网络速率信息
     * @创建人 Mayu
     * @创建时间 2020/12/13
    */
    List<TopologySpeed> getNewsSpeed();
}
