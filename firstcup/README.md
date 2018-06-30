# Architecture

- Web tier component: JavaServer Faces application packaged into firstcup-war.  
- Three business tier components: DukesAgeResource web service, FirstcupUser JPA entity, DukesBirthdayBean ejb.  
- Enterprise information system (EIS) tier: data in the Apache Derby database table. 
- The user’s web browser is the client tier component, as it accesses the rest of the application through the web tier.

# Packaging / Deployment
- JSF application + DukesBirthdayBean ejb + FirstcupUser JPA entity: will be packaged in one war.
- JAX-RS DukesAgeResource: will be packaged (and can be deployed) separately.
Notice that the war application is actually a javaee client for DukesAgeResource.

# Run on glassfish
/bin/asadmin  
> start-domain <your_domain>
> start-database
> deploy --port 4848 --host localhost <your_war path>  
curl -i http://localhost:8080/dukes-age/webapi/dukesAge  