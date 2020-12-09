package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.RadarState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RadarStateRepo extends JpaRepository <RadarState, Long> {

    @Query(nativeQuery = true , value = "select a.* from radar_state a " +
            "left join " +
            "(select cccc,max(time)as time from radar_state group by cccc)b " +
            "on a.cccc=b.cccc and a.time=b.time")
    List<RadarState> findNewState();

}
