package grails.plugins.sms

/**
 * A service for sending shot messages (SMS)
 */
class ShortMessageService {
    /**
     * Send a short message to a recipient
     * @param to a recipient phone number
     * @param message a short message text
     * @param params additional parameters to send a message. For example it can be "from" parameter.
     *               It's provider specific data.
     */
    def send(String to, String message, Map params = [:]) {
        try {
            log.debug("Try to send message \"$message\" to recipient $to with additional parameters $params.")
            log.debug("Successful sent message \"$message\" to recipient $to with additional parameters $params.")
        }catch(e){
            log.error("Error when trying to send message \"$message\\\" to recipient $to with additional parameters $params.", e)
        }
    }
}
