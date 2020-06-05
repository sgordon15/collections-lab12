package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static edu.ti.caih313.collections.dataobj.Person.Gender.FEMALE;
import static edu.ti.caih313.collections.dataobj.Person.Gender.MALE;
import edu.ti.caih313.collections.dataobj.EmailAddress.Type;
import static org.junit.Assert.*;

public class PersonTest {

    Person bob, jane, ironMan, boPeep;

    @Before
    public void createTesterPeople() {
        bob = new Person(new Name("Bob", "Smith"), MALE, LocalDate.of(1960, Month.MARCH, 15));
        bob.setEmailAddress("bobsmith@gmail.com", Type.HOME);
        bob.setEmailAddress("smith.bob@careonerx.com", Type.WORK);
        bob.setEmailAddress("bob.smith@ti.htc.edu", Type.SCHOOL);
        jane = new Person(new Name("Jane", "Doe"), FEMALE, LocalDate.of(2007, Month.JANUARY, 3));
        jane.setEmailAddress("doe.jane@careonerx.com", Type.WORK);
        jane.setEmailAddress("jane.doe@ti.htc.edu", Type.SCHOOL);
        ironMan = new Person(new Name("Tony", "Stark"), MALE, LocalDate.of(1968, Month.MAY, 13));
        ironMan.setEmailAddress("tonystark@gmail.com", Type.HOME);
        boPeep = new Person(new Name("Bo", "Peep"), FEMALE, LocalDate.of(1624, Month.FEBRUARY, 23));
    }

    @Test
    public void testToString() {
        String tester = bob.toString();
        assertEquals("Person { Name = Smith, Bob, Gender = MALE, Birth Date = Mar 15, 1960 C.E., " +
                "Primary Email Address = bobsmith@gmail.com }", tester);

        String tester1 = jane.toString();
        assertEquals("Person { Name = Doe, Jane, Gender = FEMALE, Birth Date = Jan 3, 2007 C.E., " +
                "Primary Email Address = doe.jane@careonerx.com }", tester1);

        String tester2 = ironMan.toString();
        assertEquals("Person { Name = Stark, Tony, Gender = MALE, Birth Date = May 13, 1968 C.E., " +
                "Primary Email Address = tonystark@gmail.com }", tester2);

        String tester3 = boPeep.toString();
        assertEquals("Person { Name = Peep, Bo, Gender = FEMALE, Birth Date = Feb 23, 1624 C.E., " +
                "Primary Email Address = No available email address }", tester3);
    }
}