package cn.com.taiji.domain.state;

import javax.persistence.*;
import java.time.LocalDateTime;

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

    public boolean isSa_message_sate() {
        return sa_message_sate;
    }

    public void setSa_message_sate(boolean sa_message_sate) {
        this.sa_message_sate = sa_message_sate;
    }

    public boolean isFc_message_sate() {
        return fc_message_sate;
    }

    public void setFc_message_sate(boolean fc_message_sate) {
        this.fc_message_sate = fc_message_sate;
    }

    public boolean isFt_message_sate() {
        return ft_message_sate;
    }

    public void setFt_message_sate(boolean ft_message_sate) {
        this.ft_message_sate = ft_message_sate;
    }

    public boolean isOther_message_sate() {
        return other_message_sate;
    }

    public void setOther_message_sate(boolean other_message_sate) {
        this.other_message_sate = other_message_sate;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
