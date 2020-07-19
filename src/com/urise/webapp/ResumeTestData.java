package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.Month;

public class ResumeTestData {
    private static final String UUID_1 = "uuid1";

    public static void main(String[] args) {
        Resume r1 = new Resume(UUID_1, "Name1");

        r1.addContact(ContactType.MAIL, "address@inbox.ru");
        r1.addContact(ContactType.PHONE, "89001111111");
        r1.addSection(SectionType.OBJECTIVE, new TextSection("Objective"));
        r1.addSection(SectionType.PERSONAL, new TextSection("Personal data"));
        r1.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        r1.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "Python"));
        r1.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization1", "http://Organization1.ru",
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "position2", "content2"))));
        r1.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(2001, Month.MARCH, 2005, Month.JANUARY, "student", "IT faculty")),
                        new Organization("Organization2", "http://Organization2.ru")));
        r1.addContact(ContactType.SKYPE, "UserName1");

        System.out.println("Contacts:\n" + r1.getContact(ContactType.MAIL)
                + "\n" + r1.getContact(ContactType.PHONE) + "\n" + r1.getContact(ContactType.SKYPE) + "\n" + r1.getContact(ContactType.GITHUB) + "\n");
        System.out.println("Sections:\n" + r1.getSection(SectionType.PERSONAL) + "\n" + r1.getSection(SectionType.ACHIEVEMENT)
                + "\n" + r1.getSection(SectionType.QUALIFICATIONS) + "\n" + r1.getSection(SectionType.EXPERIENCE)
                + "\n" + r1.getSection(SectionType.EDUCATION));
    }
}
