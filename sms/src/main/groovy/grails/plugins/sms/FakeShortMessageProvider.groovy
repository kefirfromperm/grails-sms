package grails.plugins.sms

import groovy.util.logging.Slf4j

/**
 * The fake short message provider. Does nothing. Just writes a message to log.
 * @author kefir
 */
@Slf4j
class FakeShortMessageProvider implements ShortMessageProvider {
    @Override
    def send(String to, String message, Map params) {
        log.info("$to, $message")
    }
}
