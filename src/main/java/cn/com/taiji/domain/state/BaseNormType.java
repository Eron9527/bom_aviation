package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *  指标项：    根据指标分组，各个指标分组延伸出来的具体指标，自观分组下面可以细化出来对环境的观测
 *              对设备细节的观测。 每个指标项可以选择使用各个监控项来进行组合打分得出所在值进行
 *              打分，带得到指标项的分数，再由各个指标项所占的比例组合出最后的得分。
 */

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
    @Column(name = "SCORE_TYPE")
    private ScoreType scoreType;      // 是否有底分

    public enum ScoreType {
        HUNDRED("100"),
        ZERO("0");

        private String info;
        private ScoreType(String info){
            this.info=info;
        }
        public  String getInfo(){
            return info;
        }

    }

    public BaseNormType() {

    }

    public BaseNormType(DataCatalog catalog, String info, String formula, Integer rank, String formulaDesc, ScoreType scoreType) {
        this.catalog = catalog;
        this.info = info;
        this.formula = formula;
        this.rank = rank;
        this.formulaDesc = formulaDesc;
        this.scoreType = scoreType;
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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getFormulaDesc() {
        return formulaDesc;
    }

    public void setFormulaDesc(String formulaDesc) {
        this.formulaDesc = formulaDesc;
    }

    public ScoreType getScoreType() {
        return scoreType;
    }

    public void setScoreType(ScoreType scoreType) {
        this.scoreType = scoreType;
    }
}
