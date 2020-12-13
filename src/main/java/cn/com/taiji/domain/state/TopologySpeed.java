package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *   各个拓扑图中的数据连接的速率
 *
 */

@Entity
@Table(name="TOPOLOGY_SPEED")
public class TopologySpeed {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TRANS_SPEED")
    private int transSpeed;   // 传输速率MB/s
    @Column(name = "CATALOG_START")
    private String from;  //起始段

    @Column(name = "CATALOG_END")
    private String to;    //结束段

    public TopologySpeed() {
    }

    public TopologySpeed(int transSpeed, String from, String to) {
        this.transSpeed = transSpeed;
        this.from = from;
        this.to = to;
    }
}
