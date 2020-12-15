package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.domain.state.TopologySpeed;
import cn.com.taiji.domain.state.TopologyState;
import cn.com.taiji.repository.state.TopologySpeedRepo;
import cn.com.taiji.repository.state.TopologyStateRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.DataTypeService;
import cn.com.taiji.service.SchemeService;
import cn.com.taiji.service.TopologyStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TopologyStateServiceImpl implements TopologyStateService {

    @Autowired
    private TopologyStateRepo topologyStateRepo;
    @Autowired
    private TopologySpeedRepo topologySpeedRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeService;
    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private SchemeService schemeService;

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

    @Override
    public Map<String, List<DataType>> getScoreDetail(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap = baseNormTypeService.getNormTypeAsKeyDataTypeAsValueByCatalog(catalogInfo);
        return dataTypeMap;
    }

    @Override
    public Map<String, BaseNormType> getFormula(String catalogInfo) {
        Map<String, BaseNormType> formulas = baseNormTypeService.getFormula(catalogInfo);
        return formulas;
    }

    @Override
    public Map<String, Integer> getBaseNormScore(String catalogInfo) {
        // key  为指标项名称     value   为该指标项所得评分
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        scoreMap = baseNormTypeService.getBaseNormScore(catalogInfo);
        return scoreMap;
    }

    @Override
    public Map<String, Float> getBaseNormWeight(String catalogInfo) {
        Map<String, Float> weight = schemeService.getBaseNormWeight(catalogInfo);
        return weight;
    }

    @Override
    public String getTopologyFormula(String catalogInfo) {
        String formula = baseNormTypeService.getFormulaAndScoreString(catalogInfo);
        return formula;
    }
}
