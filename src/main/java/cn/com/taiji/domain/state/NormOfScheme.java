package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


/**
 *   方案指标配置。
 */


@Getter
@Setter
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
}
