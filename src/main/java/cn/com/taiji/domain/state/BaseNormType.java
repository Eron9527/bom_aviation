package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *  指标项：    根据指标分组，各个指标分组延伸出来的具体指标，自观分组下面可以细化出来对环境的观测
 *              对设备细节的观测。 每个指标项可以选择使用各个监控项来进行组合打分得出所在值进行
 *              打分，带得到指标项的分数，再由各个指标项所占的比例组合出最后的得分。
 */

@Getter
@Setter
@Entity
@Table(name="BASE_NORM_TYPE")
public class BaseNormType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CATALOG")      // 所在分组
    private DataCatalog catalog;
    @Column(name = "INFO")       // 指标中文名称
    private String info;
    @Column(name = "FORMULA")     // 指标计算公式
    private String formula;
    @Column(name = "RANK_NUM")        // 序号
    private Integer rank;
    @Column(name = "FORMULA_DESC")       // 计算公式说明
    private String formulaDesc;

    public BaseNormType() {

    }

    public BaseNormType(DataCatalog catalog, String info, String formula, Integer rank, String formulaDesc) {
        this.catalog = catalog;
        this.info = info;
        this.formula = formula;
        this.rank = rank;
        this.formulaDesc = formulaDesc;
    }
}
