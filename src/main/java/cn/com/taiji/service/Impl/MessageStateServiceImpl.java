package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.MessageState;
import cn.com.taiji.repository.state.MessageStateRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.MessageStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MessageStateServiceImpl implements MessageStateService {

    @Autowired
    private MessageStateRepo messageStateRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeServicer;

    @Override
    public void add() {

    }

    @Override
    public List<MessageState> getNewsState() {
        List<MessageState> newStates = messageStateRepo.findNewState();
        return newStates;
    }

    @Override
    public Map<String, List<DataType>> getScoreDetail(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap  = baseNormTypeServicer.getNormTypeAsKeyDataTypeAsValueByCatalog(catalogInfo);
        return dataTypeMap;
    }
}
