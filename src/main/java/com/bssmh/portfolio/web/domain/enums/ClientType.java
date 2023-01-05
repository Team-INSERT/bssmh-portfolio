package com.bssmh.portfolio.web.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ClientType {

    NAVER("naver"),
    GOOGLE("google"),
    KAKAO("kakao"),
    ;

    private final String clientId;

    public boolean isEqualToClientId(String clientId) {
        return this.clientId.equals(clientId);
    }
}
