package grails.plugins.sms

import groovy.util.logging.Slf4j

/**
 * A service for sending short messages (SMS)
 */
@Slf4j
class ShortMessageService {
    ShortMessageProvider shortMessageProvider;

    /**
     * Send a short message to a recipient
     * @param to a recipient phone number
     * @param message a short message text
     * @param params additional parameters to send a message. For example it can be "from" parameter.
     *               It's provider specific data.
     * @throws ShortMessageException if can't send a message
     */
    def send(String to, String message, Map params = [:]) throws ShortMessageException {
        if (shortMessageProvider == null) {
            throw new IllegalStateException(
                    "Thw short message service is not initialized. Field shortMessageProvider is not set."
            )
        }

        if (to == null || to.isEmpty()) {
            throw new IllegalArgumentException("Argument \"to\" can't be null.")
        }

        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Argument \"message\" can't be null.")
        }

        try {
            log.debug("Try to send message \"$message\" to recipient $to with additional parameters $params.")
            shortMessageProvider.send(to, message, params)
            log.debug("Successful sent message \"$message\" to recipient $to with additional parameters $params.")
        } catch (e) {
            log.error("Error when trying to send message \"$message\" to recipient $to with additional parameters $params.", e)
            throw new ShortMessageException(e.getMessage(), e)
        }
    }
}
