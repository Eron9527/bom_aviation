package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.TopologySpeed;
import cn.com.taiji.domain.state.TopologyState;
import cn.com.taiji.repository.state.TopologySpeedRepo;
import cn.com.taiji.repository.state.TopologyStateRepo;
import cn.com.taiji.service.TopologyStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopologyStateServiceImpl implements TopologyStateService {

    @Autowired
    private TopologyStateRepo topologyStateRepo;
    @Autowired
    private TopologySpeedRepo topologySpeedRepo;

    @Override
    public void add() {

    }

    @Override
    public List<TopologyState> getNewsState() {
        return topologyStateRepo.findAll();
    }

    @Override
    public List<TopologySpeed> getNewsSpeed() {
        return topologySpeedRepo.findAll();
    }
}
