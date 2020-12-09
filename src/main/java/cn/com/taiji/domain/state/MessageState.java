package cn.com.taiji.domain.state;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="MESSAGE_STATE")
public class MessageState {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CCCC")
    private String cccc;
    @Column(name = "SA_MESSAGE_SATE")
    private boolean sa_message_sate;
    @Column(name = "FC_MESSAGE_SATE")
    private boolean fc_message_sate;
    @Column(name = "FT_MESSAGE_SATE")
    private boolean ft_message_sate;
    @Column(name = "OTHER_MESSAGE_SATE")
    private boolean other_message_sate;
    @Column(name = "TIME")
    private LocalDateTime time;

    public MessageState(){}

    public MessageState(String cccc, boolean sa_message_sate, boolean fc_message_sate, boolean ft_message_sate, boolean other_message_sate, LocalDateTime time) {
        this.cccc = cccc;
        this.sa_message_sate = sa_message_sate;
        this.fc_message_sate = fc_message_sate;
        this.ft_message_sate = ft_message_sate;
        this.other_message_sate = other_message_sate;
        this.time = time;
    }
}
