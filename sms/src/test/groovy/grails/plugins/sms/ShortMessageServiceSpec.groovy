package grails.plugins.sms

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ShortMessageService)
class ShortMessageServiceSpec extends Specification {
    void "test send without provider"() {
        when: "Call send"
        service.send("+79125554433", "Hello World")
        then: "throws IllegalStateException"
        thrown IllegalStateException
    }

    void "test with correct provider"() {
        setup: "Correct SMS provider"
        ShortMessageProvider provider = Mock(ShortMessageProvider)
        service.shortMessageProvider = provider
        when: "send with null recipient"
        service.send(null, "Hello World")
        then: "throws IllegalArgumentException"
        thrown IllegalArgumentException
        when: "send with empty recipient"
        service.send('', "Hello World")
        then: "throws IllegalArgumentException"
        thrown IllegalArgumentException
        when: "send with null message"
        service.send("+79125554433", null)
        then: "throws IllegalArgumentException"
        thrown IllegalArgumentException
        when: "send with empty message"
        service.send("+79125554433", '')
        then: "throws IllegalArgumentException"
        thrown IllegalArgumentException
        when: "send with correct data"
        service.send("+79125554433", "Hello World")
        then: "method send of provider was called 1 time"
        1 * provider.send("+79125554433", "Hello World", [:])
    }

    void "test with corrupt provider"() {
        setup: "corrupt provider"
        ShortMessageProvider provider = Mock(ShortMessageProvider) {
            send(_ as String, _ as String, _ as Map) >> {
                throw new Exception("Test.")
            }
        }
        service.shortMessageProvider = provider
        when: "Call send"
        service.send("+79125554433", "Hello World")
        then:
        def e = thrown ShortMessageException
        e.message == "Test."
    }
}
