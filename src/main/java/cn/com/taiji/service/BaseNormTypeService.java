package cn.com.taiji.service;

import cn.com.taiji.domain.state.BaseNormType;
import cn.com.taiji.domain.state.DataType;

import java.util.List;
import java.util.Map;

public interface BaseNormTypeService {

    /**
     * @描述  添加方法
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    void add();

    /**
     * @描述  根据分组名称，获取分组名称下面所有的参与打分的指标
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    Map<String, List<DataType>> getNormTypeAsKeyDataTypeAsValueByCatalog(String catalogInfo);

    /**
     * @描述   根据分组名称，返回该分组下所有监控指标实体，其中包括占比和计算公式
     *          key : 指标项名称       value :   监控项实体
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    Map<String, BaseNormType> getFormula(String catalogInfo);

    /**
     * @描述   根据分组名称，获取分组下所有指标表象的具体分数， key 值为指标项名称 ， value : 分数
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    Map<String, Integer> getBaseNormScore(String catalogInfo);

    /**
     * @描述   找到分组下所有的指标项
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    List<BaseNormType> findTypesByCatalog(String catalogInfo);

    /**
     * @描述   根据中文名称INFO 查找
     * @创建人 Mayu
     * @创建时间 2020/12/11
    */
    BaseNormType findByInfo(String info);

    /**
     * @描述   得到点击分数之后计算公式和计算公式所得到的总分数
     * @创建人 Mayu
     * @创建时间 2020/12/11
    */
    String getFormulaAndScoreString(String catalogInfo);
}
