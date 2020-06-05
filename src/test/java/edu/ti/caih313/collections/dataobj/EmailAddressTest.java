package edu.ti.caih313.collections.dataobj;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmailAddressTest {

    EmailAddress Sara, drAllen, Selwyn, johnDoe;

    @Before
    public void makeTester()
    {
        Sara = new EmailAddress("kapster05@gmail.com", EmailAddress.Type.HOME);
        Sara.emailMap.put(EmailAddress.Type.SCHOOL, "sgordon@ti.htc.edu");
        Sara.emailMap.put(EmailAddress.Type.WORK, "gordon.sara@hp.com");

        drAllen = new EmailAddress("mallen@htc.edu", EmailAddress.Type.SCHOOL);
        drAllen.emailMap.put(EmailAddress.Type.WORK, "mallen@ccis.com");

        Selwyn = new EmailAddress("selkie45@gmail.com", EmailAddress.Type.HOME);

        johnDoe = new EmailAddress("johndoe@gmail.com", EmailAddress.Type.HOME);
        johnDoe.emailMap.remove(EmailAddress.Type.HOME);
    }

    @Test
    public void testGetPrimaryEmailAddress()
    {
        String primaryEmailAddress = Sara.getEmailAddress();
        assertEquals("kapster05@gmail.com", primaryEmailAddress);

        String primaryEmailAddress1 = drAllen.getEmailAddress();
        assertEquals("mallen@ccis.com", primaryEmailAddress1);

        String primaryEmailAddress2 = Selwyn.getEmailAddress();
        assertEquals("selkie45@gmail.com", primaryEmailAddress2);

        String primaryEmailAddress3 = johnDoe.getEmailAddress();
        assertNull(primaryEmailAddress3);
    }

    @Test
    public void testGetEmailAddress()
    {
        String emailAddress = Sara.getEmailAddress(EmailAddress.Type.HOME);
        assertEquals("kapster05@gmail.com", emailAddress);

        String emailAddress1 = Sara.getEmailAddress(EmailAddress.Type.WORK);
        assertEquals("gordon.sara@hp.com", emailAddress1);

        String emailAddress2 = Sara.getEmailAddress(EmailAddress.Type.SCHOOL);
        assertEquals("sgordon@ti.htc.edu", emailAddress2);

        String emailAddress3 = johnDoe.getEmailAddress(EmailAddress.Type.HOME);
        assertNull(emailAddress3);
    }

    @Test
    public void testEmailToString()
    {
        String toString = Sara.toString();
        assertEquals("<HOME: kapster05@gmail.com, WORK: gordon.sara@hp.com, SCHOOL: sgordon@ti.htc.edu>", toString);

        String toString1 = drAllen.toString();
        assertEquals("<WORK: mallen@ccis.com, SCHOOL: mallen@htc.edu>", toString1);

        String toString2 = Selwyn.toString();
        assertEquals("<HOME: selkie45@gmail.com>", toString2);

        String toString3 = johnDoe.toString();
        assertEquals("<No email address available.>", toString3);
    }
}