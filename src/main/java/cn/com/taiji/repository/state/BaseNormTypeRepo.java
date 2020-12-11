package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.BaseNormType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BaseNormTypeRepo extends JpaRepository <BaseNormType ,Long>{

    @Query(value = "from BaseNormType where catalog.info=?1")
    List<BaseNormType> findByCatalogInfo(String catalogInfo);

    BaseNormType findByInfo(String info);
}
