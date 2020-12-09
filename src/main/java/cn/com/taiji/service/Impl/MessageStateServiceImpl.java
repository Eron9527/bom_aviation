package cn.com.taiji.service.Impl;

import cn.com.taiji.repository.state.MessageStateRepo;
import cn.com.taiji.service.MessageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageStateServiceImpl implements MessageStateService {

    @Autowired
    private MessageStateRepo messageStateRepo;

    @Override
    public void add() {

    }
}
