package cn.com.taiji.repository.state;

import cn.com.taiji.domain.state.NormOfScheme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NormOfSchemeRepo extends JpaRepository <NormOfScheme, Long> {

    @Query(value = "from NormOfScheme where scheme.id =?1")
    List<NormOfScheme> findByScheme(Long id);
}
