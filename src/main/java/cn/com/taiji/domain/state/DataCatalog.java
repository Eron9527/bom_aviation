package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *   新建分组的类别:   1.对监控的对象分为指标的大项。包括自观，雷达，卫星图，报文，拓扑图五类
 *                  2. 对监控项的创建，包括自观报警，自观告警，雷达告警
 *
 */

@Entity
@Table(name="DATA_CATALOG")  // 指标分组类别，含监控项/指标/
public class DataCatalog {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "INFO")
    private String info;   // 分组名
    @Enumerated(EnumType.STRING)
    @Column(name="TYPE")
    private NormGroupType type;   //分组类别，指标分组、数据项分组
    @Column(name = "RANK_NUM")
    private Integer rank=0;     //序号


    public enum NormGroupType {
        DATATYPE("数据项"),
        NORM("指标");

        private String info;
        private NormGroupType(String info){
            this.info=info;
        }
        public  String getInfo(){
            return info;
        }

    }

    public DataCatalog(){}

    public DataCatalog(String info, NormGroupType type, Integer rank) {
        this.info = info;
        this.type = type;
        this.rank = rank;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public NormGroupType getType() {
        return type;
    }

    public void setType(NormGroupType type) {
        this.type = type;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }
}
