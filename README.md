# Spring Boot - Internationalization
## Internationalization - Implementation Steps
- Step 00: Create Git branch for Spring Boot Internationalization
- Step 01: Create required beans and message property files per language
    - LocaleResolver
    - ResourceBundleMessageSource
    - message.properties
    - messages_fr.properties
    
## STEP 02 : Create REST service with Support i18n
- Create a helloi18n Method in HelloWorldController
- Test it via POSTMAN with "Accept-Language" headers
    - GET /hello-int
    - Accept-Language: fr
    - Accept-Language: us
    - Accept-Language: en
    
     