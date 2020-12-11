package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.repository.state.BaseNormTypeRepo;
import cn.com.taiji.service.BaseNormTypeService;
import cn.com.taiji.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BaseNormTypeServiceImpl implements BaseNormTypeService {

    @Autowired
    private BaseNormTypeRepo baseNormTypeRepo;
    @Autowired
    private DataTypeService dataTypeService;

    @Override
    public void add() {

    }

    @Override
    public Map<String, List<DataType>> getNormTypeAsKeyDataTypeAsValueByCatalog(String catalogInfo) {
        Map<String, List<DataType>> dataTypeMap = new HashMap<>();
        // 根据分组名称中的，找到分组下所有的指标项
        List<BaseNormType> types = baseNormTypeRepo.findByCatalogInfo(catalogInfo);

        for (BaseNormType type : types){
            List<String> dataTypeCodes = null;
            List<DataType> dataTypes = new ArrayList<>();
            // 将计算公式中本指标涉及到的编码统计出来
            dataTypeCodes = Arrays.asList(type.getFormula().replace("=","").split("\\+|-").clone());
            if (dataTypeCodes != null && dataTypeCodes.size() > 0){
                for (String code : dataTypeCodes){
                    // 通过统计的编码找到所有的监控项
                    DataType dataType = dataTypeService.getTypeByCode(code);
                    dataTypes.add(dataType);
                }
            }
            dataTypeMap.put(type.getInfo(), dataTypes);
        }
        return dataTypeMap;
    }

    @Override
    public Map<String, BaseNormType> getFormula(String catalogInfo) {
        Map<String, BaseNormType> baseNormTypeMap = new HashMap<>();
        // 根据分组名称中的，找到分组下所有的指标项
        List<BaseNormType> types = baseNormTypeRepo.findByCatalogInfo(catalogInfo);
        if (types != null && types.size() > 0){
            for (BaseNormType type : types){
                // 中文名称当作 key
                baseNormTypeMap.put(type.getInfo(), type);
            }
        }
        return baseNormTypeMap;
    }

    @Override
    public Map<String, Integer> getBaseNormScore(String catalogInfo) {
        // key  为指标项名称     value   为该指标项所得评分
        Map<String, Integer> scoreMap = new HashMap<String, Integer>();
        Map<String, BaseNormType> formulas = this.getFormula(catalogInfo);
        for (Map.Entry<String, BaseNormType> entry : formulas.entrySet()) {
            // key ： 中文名称        value ：实体
            System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue());
            String famula = entry.getValue().getFormula();
            List<String> codes = Arrays.asList(famula.replace("=","").split("\\+|-"));
            BaseNormType type = entry.getValue();

            // 如果指标项大于一个监控项则进行加减运算
            if (codes != null && codes.size() > 1){
                List<String> calculates = new ArrayList<>();
                calculates.add("+");   // 第一项作为加号
                for(int i = 0 ; i<famula.length() ; i++){
                    if (famula.charAt(i) == '+'){
                        calculates.add("+");
                    }
                    if (famula.charAt(i) == '-'){
                        calculates.add("-");
                    }
                }

                // 初始分数为用户设定的100 或者0 分， 将枚举类型转换为Int 用于计算
                int score1 = Integer.valueOf(type.getScoreType().getInfo());
                //对同一指标项下的监控项进行分数累加
                for (String code : codes){
                    for(String cal : calculates){
                        DataType dataType = dataTypeService.getTypeByCode(code);
                        score1 = cal.equals("+")? +dataType.getRank() : -dataType.getRank();
                    }
                }

                scoreMap.put(entry.getKey(), score1);

            }else{   // 只有一个监控项的得分计算
                String code = codes.get(0);
                DataType dataType = dataTypeService.getTypeByCode(code);
                int score2 = Integer.valueOf(type.getScoreType().getInfo());
                scoreMap.put(entry.getKey(), score2);
            }
        }
        return scoreMap;
    }

    @Override
    public List<BaseNormType> findTypesByCatalog(String catalogInfo) {
        List<BaseNormType> types = baseNormTypeRepo.findByCatalogInfo(catalogInfo);
        return types;
    }
}
