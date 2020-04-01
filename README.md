# Spring Boot - Micrometer  
- Micrometer is the metrics collection facility included in Spring Boot
2's Actuator
- Micrometer is a dimensional-first metrics collection facade whose
aim is to allow us to time, count and gauge your code with a vendor
neutral API.
- Through classpath and configuration, we can select one or several
monitoring systems to export our metrics data
- It has also been back ported to spring boot 1.5, 1.4, 1.3 with the
addition of another dependency.
  
## Spring Boot - Micrometer
- A single Micrometer Timer is capable of producing time series
related to throughput, total time, maximum latency of recent 
samples, pre-computed percentiles, percentile histograms, and SLA
boundary counts.
- The change to Micrometer arose out of a desire to better serve a 
Wave of dimensional monitoring systems ( Think prometheus,
  Datadog, Wavefront, SignalFx, influx).
- Spring Boot is enabling us to choose one or more monitoring systems
to use today, and change our mind later as our needs change without
requiring a rewrite of our custom metrics instrumentation.
- https://micrometer.io/docs
  
## Micrometer Details Implementation Steps
- Step-00: Introduction
- Step-01: New GIT branch
    - git branch name:  Udemy-Springboot14-ActuatorMicrometer 
    - create new git branch
- Step-02: Add micrometer dependency for Metrics.
   ```
  <dependency>
  			<groupId>io.micrometer</groupId>
  			<artifactId>micrometer-core</artifactId>
  			<version>1.2.0</version> 
  		</dependency>
    ```   
  - Simple (In-Memory backend - `~Fail back option) - by default enabled
    - To disable: management.metrics.export.simple.enabled=false
    - http://localhost:8080/actuator.metrics/http.server.requests
    - http://localhost:8080/actuator.metrics/process.files.open
-Step-03: Integrate with JMX and view metrics in Jconsole using JMX (Export Metrics)
    - Add JMX dependency  
    
    ```
    <dependency>
          <groupId>io.micrometer</groupId>
          <artifactId>micrometer-registry-jmx</artifactId>
          <version>1.2.0</version> 
     </dependency>
    ``` 
     - Add JMX property
        - management.metrics.export.jmx.enabled: true
     - Test 
        - JVM Threads live
 - Step-04: Integrate with AppOptics to export metrics and view metrics in AppOptics(Solarwinds product)
    -AppOptics
        - Create a trial user in APpOptics(https://www.appoptics.com/)              
        - Create API taken by navigating to Settings -> API Tokens
    - Our Springboot Application
        - Add this token in our project application.properties
            - management.metrics.export.appoptics.api-token=TOKEN
        - Add dependency for AppOptics in pom.xml & restart embedded tomcat
            ```
               <dependency>
                    <groupId>io.micrometer</groupId>
                    <artifactId>micrometer-registry-appoptics</artifactId>
                    <version>1.2.0</version> 
               </dependency>
            ```   
        - Create "MonitoringConfig" file by referring documentation for AppOpticsConfig
            - https://micrometer.io/docs/registry/appoptics
        - Restart JVM
- Step-05: Perform Tests using POSTMAN
    - Perform "Collection Runner" test via POSTMAN with 1000 requests.
                                 