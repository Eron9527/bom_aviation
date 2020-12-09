package cn.com.taiji.service.Impl;

import cn.com.taiji.domain.state.DataType;
import cn.com.taiji.repository.state.DataTypeRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTypeServiceImplTest {
    public DataTypeServiceImplTest(){}
    @Autowired
    private DataTypeRepo dataTypeRepo;

    @Test
    public void test(){
        DataType type = dataTypeRepo.findByCode("AWOS_FS11_WARN");
        System.out.println(type.getInfo());

    }

}