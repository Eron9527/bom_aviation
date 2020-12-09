package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.MessageState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageStateRepo extends JpaRepository <MessageState, Long> {
}
