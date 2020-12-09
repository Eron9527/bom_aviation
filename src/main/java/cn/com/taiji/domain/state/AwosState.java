package cn.com.taiji.domain.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
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
}
