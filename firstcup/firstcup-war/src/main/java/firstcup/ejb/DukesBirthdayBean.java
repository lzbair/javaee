/**
 * Copyright (c) 2014 Oracle and/or its affiliates. All rights reserved.
 * <p>
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * https://github.com/javaee/firstcup-examples/LICENSE.txt
 */
package firstcup.ejb;

import firstcup.entity.FirstcupUser;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
public class DukesBirthdayBean {

    private static final Logger logger = Logger.getLogger("firstcup.ejb.DukesBirthdayBean");
    @PersistenceContext
    private EntityManager em;

    public Double getAverageAgeDifference() {
        Double avgAgeDiff =
                (Double) em.createNamedQuery("findAverageAgeDifferenceOfAllFirstcupUsers").getSingleResult();
        logger.log(Level.INFO, "Average age difference is: {0}", avgAgeDiff);
        return avgAgeDiff;

    }

    public int getAgeDifference(Date date) {

        LocalDate dukeBirthday = LocalDate.of(1995, Month.MAY, 23);
        LocalDate userBirthday = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period ageDifference = Period.between(dukeBirthday, userBirthday);

        FirstcupUser user = new FirstcupUser(date, ageDifference.getYears());
        em.persist(user);

        return user.getAgeDifference();
    }
}
