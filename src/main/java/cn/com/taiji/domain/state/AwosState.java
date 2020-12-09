package cn.com.taiji.domain.state;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="AWOS_STATE")
public class AwosState {
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

    public AwosState() {
    }

    public AwosState(String cccc, LocalDateTime time, int amount) {
        this.cccc = cccc;
        this.time = time;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String getCccc() {
        return cccc;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public int getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCccc(String cccc) {
        this.cccc = cccc;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
