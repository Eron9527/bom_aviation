package cn.com.taiji.service;

import java.util.Map;

public interface NormOfSchemeService {

    /**
     * @描述   添加
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    public void add();

    /**
     * @描述   根据现在使用方案id 找到正在采用的方案
     *          在采用的方案中找到所监控的指标分组下所有的监控项的百分比占分
     *          key: 监控项    value: 百分比
     * @创建人 Mayu
     * @创建时间 2020/12/10
    */
    Map<String, Float> getBaseNormWeight(Long id, String catalogInfo);
}
