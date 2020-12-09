package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.RadarState;
import cn.com.taiji.domain.state.SatelState;
import cn.com.taiji.repository.state.SatelStateRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.SatelStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SatelStateServiceImpl implements SatelStateService {

    @Autowired
    private SatelStateRepo satelStateRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeServicer;

    @Override
    public void add() {

    }

    @Override
    public List<SatelState> getNewsState() {
        List<SatelState> newStates = satelStateRepo.findNewState();
        return newStates;
    }

    @Override
    public Map<String, List<DataType>> getScoreDetail(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap  = baseNormTypeServicer.getNormTypeAsKeyDataTypeAsValueByCatalog(catalogInfo);
        return dataTypeMap;
    }
}
