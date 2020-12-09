package cn.com.taiji.service.Impl;

import cn.com.taiji.repository.state.AwosStateRepo;
import cn.com.taiji.service.AwosStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AwosStateServiceImpl implements AwosStateService {

    @Autowired
    private AwosStateRepo awosStateRepo;

    @Override
    public void add() {

    }
}
