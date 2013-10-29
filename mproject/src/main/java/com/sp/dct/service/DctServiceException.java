package com.sp.dct.service;

/**
 * @author imustafin
 */

/**
 * Base exception class that can be thrown from "sourcing" services
 */
public class DctServiceException extends RuntimeException {

    public DctServiceException(String message) {
        super (message);
    }

    public DctServiceException(Throwable cause) {
        super (cause);
    }

    public DctServiceException(String message, Throwable cause) {
        super (message, cause);
    }
}
