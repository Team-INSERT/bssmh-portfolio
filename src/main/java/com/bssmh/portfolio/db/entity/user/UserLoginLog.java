package com.bssmh.portfolio.db.entity.user;

import com.bssmh.portfolio.db.entity.common.BaseCreateTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginLog extends BaseCreateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_login_log_id")
    private Long id;

    private String email;

    private String name;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Builder(access = AccessLevel.PRIVATE)
    private UserLoginLog(String email, String name, User user) {
        this.email = email;
        this.name = name;
        this.user = user;
    }

    public static UserLoginLog of(String email, String name, User user) {
        return UserLoginLog.builder()
                .email(email)
                .name(name)
                .user(user)
                .build();
    }
}
