package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.TopologyState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopologyStateRepo extends JpaRepository <TopologyState, Long> {
}
