package com.bssmh.portfolio.web.exception;

import org.springframework.http.HttpStatus;

public class AccessDeniedException extends GeneralHttpException {
    public AccessDeniedException() {
        super(HttpStatus.FORBIDDEN, "권한이 없습니다.", null);
    }
}
