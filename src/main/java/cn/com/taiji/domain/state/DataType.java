package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *    监控项：     最小一级。 DataCatalog 类中选择的监控项  进行分组， 细化分出的一级
 *                具体到某个设备的监控， 某个设备的监控状态，以及具体项的分数。
 *                通过监控项数据类型和组成公式， 来计算所监控的某项指标的评分。
 */
@Getter
@Setter
@Entity
@Table(name="DATA_TYPE")
public class DataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CATALOG")
    private DataCatalog catalog;    // 指标分组
    @Column(name = "CODE")
    private String code;    // 数据项编码
    @Column(name = "INFO")
    private String info;     // 数据项名称
    @Column(name = "TYPE")
    private ValueType type;    // 数据类型  包括定量，定性
    @Column(name = "RANK_NUM")
    private Integer rank=0;    // 排序

    public enum ValueType {
        NUM("定量"), BOOL("定性") ;
        private String info;

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        private ValueType(String info) {
            this.info = info;
        }
    }

    public DataType() {

    }

    public DataType(DataCatalog catalog, String code, String info, ValueType type, Integer rank) {
        this.catalog = catalog;
        this.code = code;
        this.info = info;
        this.type = type;
        this.rank = rank;
    }
}
