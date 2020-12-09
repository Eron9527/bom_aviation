package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.DataType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataTypeRepo extends JpaRepository <DataType, Long> {

    DataType findByCode(String code);
}
