package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.repository.state.DataTypeRepo;
import cn.com.taiji.service.DataTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTypeServiceImpl implements DataTypeService {

    @Autowired
    private DataTypeRepo dataTypeRepo;

    @Override
    public void add() {

    }

    @Override
    public DataType getTypeByCode(String code) {
       DataType type =  dataTypeRepo.findByCode(code);
        return type;
    }
}
