package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *    监控项：     最小一级。 DataCatalog 类中选择的监控项  进行分组， 细化分出的一级
 *                具体到某个设备的监控， 某个设备的监控状态，以及具体项的分数。
 *                通过监控项数据类型和组成公式， 来计算所监控的某项指标的评分。
 */
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
    private Integer rank=0;
    @Column(name = "SCORE")    // 应加减分值
    private Integer score;


    //  如果定量就是给一百分初始值， 如果定性就是不加
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

    public DataType(DataCatalog catalog, String code, String info, ValueType type, Integer rank, Integer score) {
        this.catalog = catalog;
        this.code = code;
        this.info = info;
        this.type = type;
        this.rank = rank;
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DataCatalog getCatalog() {
        return catalog;
    }

    public void setCatalog(DataCatalog catalog) {
        this.catalog = catalog;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ValueType getType() {
        return type;
    }

    public void setType(ValueType type) {
        this.type = type;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
