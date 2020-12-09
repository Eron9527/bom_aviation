package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.RadarState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RadarStateRepo extends JpaRepository <RadarState, Long> {
}
