package cn.com.taiji.domain.state;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="RADAR_STATE")
public class RadarState {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CCCC")
    private String cccc;
    @Column(name = "TIME")
    private LocalDateTime time;
    @Column(name = "AMOUNT")
    private int amount;

    public RadarState(){}

    public RadarState(String cccc, LocalDateTime time, int amount) {
        this.cccc = cccc;
        this.time = time;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCccc() {
        return cccc;
    }

    public void setCccc(String cccc) {
        this.cccc = cccc;
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
