package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.SatelState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SatelStateRepo extends JpaRepository <SatelState, Long> {

    @Query(nativeQuery = true , value = "select a.* from satel_state a " +
            "left join " +
            "(select satel_type,max(time)as time from satel_state group by satel_type)b " +
            "on a.satel_type=b.satel_type and a.time=b.time")
    List<SatelState> findNewState();

}
