package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.MessageState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageStateRepo extends JpaRepository <MessageState, Long> {

    @Query(nativeQuery = true , value = "select a.* from message_state a " +
            "left join " +
            "(select cccc,max(time)as time from message_state group by cccc)b " +
            "on a.cccc=b.cccc and a.time=b.time")
    List<MessageState> findNewState();
}
