package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.AwosState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AwosStateRepo extends JpaRepository <AwosState, Long> {

    @Query(nativeQuery = true , value = "select a.* from awos_state a " +
            "left join " +
            "(select cccc,max(time)as time from awos_state group by cccc)b " +
            "on a.cccc=b.cccc and a.time=b.time")
    List<AwosState> findNewState();
}
