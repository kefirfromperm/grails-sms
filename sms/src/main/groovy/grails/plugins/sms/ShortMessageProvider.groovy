package grails.plugins.sms

/**
 * Send short messages by the provider.
 * @author kefir
 */
interface ShortMessageProvider {
    /**
     * Send a short message to a recipient
     * @param to a recipient phone number
     * @param message a short message text
     * @param params additional parameters to send a message. For example it can be "from" parameter.
     *               It's provider specific data.
     * @throws Throwable if can't send a message
     */
    def send(String to, String message, Map params) throws Throwable;
}