package com.urise.webapp;

import com.urise.webapp.model.*;

import java.time.Month;

public class ResumeTestData {

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        /*resume.addContact(ContactType.MAIL, fullName + "@inbox.ru");
        resume.addContact(ContactType.PHONE, "+79001111111");
        resume.addContact(ContactType.SKYPE, fullName);
        resume.addContact(ContactType.GITHUB, "https://github.com/Denisblch/basejava");
        resume.addSection(SectionType.PERSONAL, new TextSection(fullName + ", " + uuid));
        resume.addSection(SectionType.OBJECTIVE, new TextSection("Objective"));
        resume.addSection(SectionType.ACHIEVEMENT, new ListSection("Achievement1", "Achievement2", "Achievement3"));
        resume.addSection(SectionType.QUALIFICATIONS, new ListSection("Java", "SQL", "Python"));
        resume.addSection(SectionType.EXPERIENCE,
                new OrganizationSection(
                        new Organization("Organization1", "http://Organization1.ru",
                                new Organization.Position(2017, Month.JANUARY, "position1", "content1"),
                                new Organization.Position(2018, Month.SEPTEMBER, 2022, Month.JULY, "position2", "content2"))));
        resume.addSection(SectionType.EDUCATION,
                new OrganizationSection(
                        new Organization("Institute", null,
                                new Organization.Position(2018, Month.SEPTEMBER, 2022, Month.JULY, "student", "IT faculty"))));


        System.out.println("Contacts:\n" + "Mail: " + resume.getContact(ContactType.MAIL)
                + "\n" + "Phone: " + resume.getContact(ContactType.PHONE) + "\n" + "Skype: " + resume.getContact(ContactType.SKYPE) + "\n"
                + resume.getContact(ContactType.GITHUB) + "\n");
        System.out.println("Sections:\n" + "Personal Data: " + resume.getSection(SectionType.PERSONAL) + "\n" + resume.getSection(SectionType.ACHIEVEMENT)
                + "\n" + resume.getSection(SectionType.QUALIFICATIONS) + "\n" + resume.getSection(SectionType.EXPERIENCE)
                + "\n" + resume.getSection(SectionType.EDUCATION));*/

        return resume;
    }
}
