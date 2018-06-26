/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * <p>
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/firstcup-examples/LICENSE.txt
 */
package firstcup.dukesage.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


@Path("dukesAge")
public class DukesAgeResource {

    @GET
    @Produces("text/plain")
    public String dukeAge() {

        LocalDate dukesBirthday = LocalDate.of(1995, Month.MAY, 23);
        Period dukeAge = Period.between(dukesBirthday, LocalDate.now());

        return "Dukes age is: " + dukeAge.getYears();
    }
}
