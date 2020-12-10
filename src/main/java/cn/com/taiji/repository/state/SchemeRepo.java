package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.Scheme;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchemeRepo extends JpaRepository <Scheme, Long> {

    List<Scheme> findByName(String name);

    Scheme findByUseFlag(boolean bool);
}
