package cn.com.taiji.service;

import java.util.Map;

public interface SchemeService {

    /**
     * @描述  添加
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    public void add();

    /**
     * @描述   根据分组名称得到该指标分组下个指标项所占的百分比
     *          key: 指标项名称      value:  百分比
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    Map<String, Float> getBaseNormWeight(String catalogInfo);
}
