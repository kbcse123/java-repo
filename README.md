# Food ordering application using jte and htmx
SpringBoot project developed using htmx as a javascript library and JTE as a template engine.
htmx and jte is a powerful combination for creating dynamic web pages with blazing speeds for java fullstack. 
Take a look at these deadly combination.

- HTMX
    -  https://htmx.org/
    -  https://refine.dev/blog/what-is-htmx/#introduction

-  JTE
    -  https://jte.gg/
    -  https://www.youtube.com/watch?v=tfJaHhjWgTE


Make sure to do a maven build first (mvn clean install) before running the app.
-  Project can be run in multiple profiles local, dev and prod. 
-  To run the app with dev profile (refer application-dev.properties).
    -  set the VM argument -Dspring.profiles.active=dev.
-  To run the app with prod profile with SSL enabled (refer application-prod.properties).
    -  set the VM argument -Dspring.profiles.active=prod.
    -  you can update the pom file to use undertow server instead of tomcat too.

