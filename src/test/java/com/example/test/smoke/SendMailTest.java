package com.example.test.smoke;

import com.epam.reportportal.message.ReportPortalMessage;
import com.epam.reportportal.service.ReportPortal;
import com.epam.ta.reportportal.ws.model.log.SaveLogRQ;
import com.example.model.Mail;
import com.example.page.*;
import com.example.page.Basic.MainPage;
import com.example.service.DtoCreator;
import com.example.test.BaseTest;
import com.example.util.ScreenshotUtil;
import com.google.common.io.ByteSource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MarkerFactory;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Calendar;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SendMailTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(SendMailTest.class);

    @Test
    public void testScreenshotReporting() {
        assertTrue(false);
    }

    @Test
    public void testMailSaveToDraftAndSent() {
        Mail mail = DtoCreator.randomMail();
        boolean isDraftPresent = new MainPage(driver)
                .writeNewMail()
                .enterMailData(mail)
                .moveToDrafts()
                .isPresent(mail);
        assertTrue(isDraftPresent, "Draft is not present in drafts");
        Mail received = new DraftsPage(driver)
                .continueWriting(mail)
                .getMail();
        assertEquals(received, mail, "Mails are different");
        boolean isDraftAbsent = new NewEmailPage(driver)
                .send()
                .moveToDrafts()
                .isAbsent(mail);
        assertTrue(isDraftAbsent, "Draft is still present in drafts");
        assertTrue(new MainPage(driver)
                .moveToSent()
                .isPresent(mail), "Mail is not present in sent");
    }
}
