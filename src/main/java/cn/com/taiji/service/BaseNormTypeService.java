package cn.com.taiji.service;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;

import java.util.List;
import java.util.Map;

public interface BaseNormTypeService {

    /**
     * @描述  添加方法
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    void add();

    /**
     * @描述  根据分组名称，获取分组名称下面所有的参与打分的指标
     * @创建人 Mayul
     * @创建时间 2020/12/9
    */
    Map<String, List<DataType>> getNormTypeAsKeyDataTypeAsValueByCatalog(String catalogInfo);
}
