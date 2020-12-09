package cn.com.taiji.domain.state;

import javax.persistence.*;


/**
 *   方案指标配置。
 */


@Entity
@Table(name="MANAGE_SCHEME_NORM")
public class NormOfScheme {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "SCHEME")
    private Scheme scheme;    // 指标分组
    @ManyToOne
    @JoinColumn(name = "NORM")
    private BaseNormType norm;      // 方案指标名称
    @Column(name = "WEIGHT")
    private Integer weight;     // 评分占比百分比
    @Column(name = "USED_FLAG")
    private boolean usedFlag;     //  是否使用

    public NormOfScheme() {

    }

    public NormOfScheme(Scheme scheme, BaseNormType norm, Integer weight, boolean usedFlag) {
        this.scheme = scheme;
        this.norm = norm;
        this.weight = weight;
        this.usedFlag = usedFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public void setScheme(Scheme scheme) {
        this.scheme = scheme;
    }

    public BaseNormType getNorm() {
        return norm;
    }

    public void setNorm(BaseNormType norm) {
        this.norm = norm;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public boolean isUsedFlag() {
        return usedFlag;
    }

    public void setUsedFlag(boolean usedFlag) {
        this.usedFlag = usedFlag;
    }
}
