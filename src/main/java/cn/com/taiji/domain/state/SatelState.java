package cn.com.taiji.domain.state;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="SATEL_STATE")
public class SatelState {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "SATEL_TYPE")
    private String satelType;
    @Column(name = "TIME")
    private LocalDateTime time;
    @Column(name = "AMOUNT")
    private int amount;

    public SatelState(){}

    public SatelState(String satelType, LocalDateTime time, int amount) {
        this.satelType = satelType;
        this.time = time;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSatelType() {
        return satelType;
    }

    public void setSatelType(String satelType) {
        this.satelType = satelType;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
