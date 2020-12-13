package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.TopologySpeed;
import cn.com.taiji.domain.state.TopologyState;
import cn.com.taiji.service.TopologyStateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopologyStateServiceImpl implements TopologyStateService {
    @Override
    public void add() {

    }

    @Override
    public List<TopologyState> getNewsState() {
        return null;
    }

    @Override
    public List<TopologySpeed> getNewsSpeed() {
        return null;
    }
}
