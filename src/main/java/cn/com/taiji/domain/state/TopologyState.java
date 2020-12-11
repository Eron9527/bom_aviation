package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *    拓扑图中的实体， 包括交换机，服务器，及硬件信息
 */
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

        DevType(String info) {
            this.info = info;
        }
    }

    public TopologyState() {
    }

    public TopologyState(DevType type, boolean connectState, String devAddress) {
        this.type = type;
        this.connectState = connectState;
        this.devAddress = devAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DevType getType() {
        return type;
    }

    public void setType(DevType type) {
        this.type = type;
    }

    public boolean isConnectState() {
        return connectState;
    }

    public void setConnectState(boolean connectState) {
        this.connectState = connectState;
    }

    public String getDevAddress() {
        return devAddress;
    }

    public void setDevAddress(String devAddress) {
        this.devAddress = devAddress;
    }
}
