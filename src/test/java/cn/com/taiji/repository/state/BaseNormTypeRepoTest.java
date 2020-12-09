package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.BaseNormType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseNormTypeRepoTest {

    @Autowired
    private BaseNormTypeRepo baseNormTypeRepo;

    public BaseNormTypeRepoTest(){}

    @Test
    public void test(){

        //根据监控项查找下的指标项
        List<BaseNormType> a = baseNormTypeRepo.findByCatalogInfo("自观");
        System.out.println(a.size());
    }

    @Test
    public void testSplit(){
        String s = "=MESSAGE_FC_AMOUNT&&MESSAGE_FT_AMOUNT+MESSAGE_SA_AMOUNT+MESSAGE_SP_AMOUNT";
        String[] array = s.split("\\+|-|=");
        for(String a : array){
            System.out.println(a);
        }
    }

}