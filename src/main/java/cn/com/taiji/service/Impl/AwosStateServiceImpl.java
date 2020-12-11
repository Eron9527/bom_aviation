package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.AwosState;
import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.repository.state.AwosStateRepo;
import cn.com.taiji.service.AwosStateService;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.DataTypeService;
import cn.com.taiji.service.SchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AwosStateServiceImpl implements AwosStateService {

    @Autowired
    private AwosStateRepo awosStateRepo;
    @Autowired
    private BaseNormTypeService baseNormTypeService;
    @Autowired
    private DataTypeService dataTypeService;
    @Autowired
    private SchemeService schemeService;

    public AwosStateServiceImpl() {
    }

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
    public String getAwosFormula(String catalogInfo) {
        String formula = baseNormTypeService.getFormulaAndScoreString(catalogInfo);
        return formula;
    }
}
