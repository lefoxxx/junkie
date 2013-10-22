package tld.dmt.service;

/**
 * @author imustafin
 */

/**
 * Base exception class that can be thrown from "sourcing" services
 */
public class DmtException extends RuntimeException {

    public DmtException(String message) {
        super (message);
    }

    public DmtException(Throwable cause) {
        super (cause);
    }

    public DmtException(String message, Throwable cause) {
        super (message, cause);
    }
}
