package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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
}
