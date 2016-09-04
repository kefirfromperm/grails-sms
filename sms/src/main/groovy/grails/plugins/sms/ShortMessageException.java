package grails.plugins.sms;

/**
 * The base class for all exceptions of short message service.
 *
 * @author kefir
 */
public class ShortMessageException extends Exception {
    public ShortMessageException(String message, Throwable cause) {
        super(message, cause);
    }
}
