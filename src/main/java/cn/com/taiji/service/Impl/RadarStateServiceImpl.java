package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.RadarState;
import cn.com.taiji.repository.state.RadarStateRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.RadarStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RadarStateServiceImpl implements RadarStateService {

    @Autowired
    private RadarStateRepo radarStateRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeServicer;

    @Override
    public void add() {

    }

    @Override
    public List<RadarState> getNewsState() {
        List<RadarState> newStates = radarStateRepo.findNewState();
        return newStates;
    }

    @Override
    public Map<String, List<DataType>> getScoreDetail(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap  = baseNormTypeServicer.getNormTypeAsKeyDataTypeAsValueByCatalog(catalogInfo);
        return dataTypeMap;
    }
}
