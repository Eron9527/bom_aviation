package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.DataCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataCatalogRepo extends JpaRepository <DataCatalog, Long> {

    List<DataCatalog> findByInfo(String info);

}
