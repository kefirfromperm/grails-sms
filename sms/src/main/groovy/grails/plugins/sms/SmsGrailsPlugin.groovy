package grails.plugins.sms

import grails.plugins.*

class SmsGrailsPlugin extends Plugin {
    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.1.11 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
            "grails-app/views/error.gsp"
    ]

    def title = "Grails SMS plugin" // Headline display name of the plugin
    def author = "Vitalii Samolovskikh"
    def authorEmail = "kefirfromperm@gmail.com"
    def description = '''\
This plugins provides only an interface to send SMS. To really send SMS you need a SMS provider plugin.
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/sms"

    // Extra (optional) plugin metadata

    // License: one of 'APACHE', 'GPL2', 'GPL3'
    def license = "APACHE"

    // Details of company behind the plugin (if there is one)
    def organization = [name: "Kefir Software Foundation", url: "http://kefirsf.org/"]

    // Any additional developers beyond the author specified above.
    def developers = [[name: "Vitalii Samolovskikh", email: "kefirfromperm@gmail.com"]]

    // Location of the plugin's issue tracker.
    def issueManagement = [system: "GitHub", url: "https://github.com/kefirfromperm/grails-sms/issues"]

    // Online location of the plugin's browseable source code.
    def scm = [url: "git@github.com:kefirfromperm/grails-sms.git"]

    Closure doWithSpring() {
        { ->
            if(grailsApplication.config.sms.fake){
                shortMessageProvider(FakeShortMessageProvider)
            }
        }
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
