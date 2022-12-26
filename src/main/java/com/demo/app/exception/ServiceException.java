package com.demo.app.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ServiceException extends RuntimeException {

    public ServiceException(final String message, final Exception ex) {
        super(message, ex);
    }
}
