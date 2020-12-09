package cn.com.taiji.domain.state;

import javax.persistence.*;

/**
 *     方案， 用户选择各个方案进行对分数来汇总， 各个方案可以配置各个指标的得分的百分比
 *
 */

@Entity
@Table(name="SCHEME")
public class Scheme {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "CONTENT")
    private String content;

    public Scheme() {

    }

    public Scheme(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
