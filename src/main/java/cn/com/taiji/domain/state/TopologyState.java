package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="TOPOLOGY_STATE")
public class TopologyState {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private DevType type;     //设备类型   服务器/交换机
    @Column(name = "CONNECT_STATE")
    private boolean connectState;    //连接状态  正常/中断
    @Column(name = "TRANS_SPEED")
    private int transSpeed;   // 传输速率MB/s
    @Column(name = "DEV_ADDRESS")
    private String devAddress;    // 服务器所在地址/交换机为空


    public enum DevType {
        SERVER("服务器"), EXCHANGE("交换机") ;
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        private DevType(String info) {
            this.info = info;
        }
    }
}
