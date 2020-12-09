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
    private DataTypeService dataTypeServicer;

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
                    DataType dataType = dataTypeServicer.getTypeByCode(code);
                    dataTypes.add(dataType);
                }
            }
            dataTypeMap.put(type.getInfo(), dataTypes);
        }
        return dataTypeMap;
    }
}
