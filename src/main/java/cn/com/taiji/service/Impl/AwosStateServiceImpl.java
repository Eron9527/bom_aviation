package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.repository.state.AwosStateRepo;
import cn.com.taiji.service.AwosStateService;
import cn.com.taiji.service.BaseNormTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AwosStateServiceImpl implements AwosStateService {

    @Autowired
    private AwosStateRepo awosStateRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeServicer;

    @Override
    public void add() {

    }

    @Override
    public List<AwosState> getNewsState() {
        List<AwosState> newStates = awosStateRepo.findNewState();
        return newStates;
    }

    @Override
    public Map<String, List<DataType>> getScoreDetail(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap  = baseNormTypeServicer.getNormTypeAsKeyDataTypeAsValueByCatalog(catalogInfo);
        return dataTypeMap;
    }
}
