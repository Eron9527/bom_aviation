package cn.com.taiji.service;

import cn.com.taiji.domain.state.DataType;

public interface DataTypeService {

    /**
     * @描述  添加
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    public void add();

    /**
     * @描述    通过Code 查找监控项
     * @创建人 Mayu
     * @创建时间 2020/12/9
    */
    DataType getTypeByCode(String code);
}
