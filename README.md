# Reminder
Java EE platform is designed to create large-scale, multitiered, scalable, reliable, and secure network applications. A shorthand name for such applications is enterprise applications.  
The javaee application is separated into isolated functional areas, called tiers:
### Client tier
web browser, a standalone application, or other servers.
### Web tier
Dynamically generate content in various formats for the client
Control the flow of screens or pages on the client
Maintain the state of data for a user’s session
### Business tier
Core functionality & business logic
Technologies: EJBs, JPA, JAX-RS ..  

A Java EE server is a server application that implements the Java EE platform APIs and provides standard Java EE services. It is composed of:
### Client container
This the interface between Java EE application clients (running on the client machine) and the Java EE server/platform.
### Web container
This is the interface between web components (servlets, jsf ...) and the Javee server/platform
### EJB container
This is the interface between enterprise beans and the Java EE server/platform.  


In javaee application, modules are packaged as EAR, JAR and WAR:  
- JAR: EJB modules + EJB deployment descriptor (META-INF/ejb-jar.xml) are packed as JAR files with .jar extenstion. It's loaded into EJB container.  
- WAR: Web modules (Servlets, JSPs ..) + WEB  deployment descriptor (WEB-INF/web.xml) are packaged as JAR file with .war extension. loaded into WEB container.   
- EAR: All above files (.jar and .war) are packaged as JAR file with .ear extension. It packs also WEB-INF/application.xml

