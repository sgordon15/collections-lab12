package edu.ti.caih313.collections.dataobj;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Person {
    private Name name;
    private Gender gender;

    private EmailAddress emailAddress;

    private LocalDate birthDate;

    public enum Gender {MALE, FEMALE}

    public Person(Name name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public Integer getAge() {
        Period ageNow = Period.between(birthDate, LocalDate.now());
        return ageNow.getYears();
    }

    public void setEmailAddress(String email, EmailAddress.Type type) {
        if (emailAddress == null) {
            emailAddress = new EmailAddress(email, type);
        } else {
            emailAddress.emailMap.put(type, email);
        }
    }

    @Override
    public String toString() {
        String primaryEmailAddress;
        if (emailAddress == null) {
            primaryEmailAddress = "No available email address";
        } else {
            primaryEmailAddress = emailAddress.getEmailAddress();
        }

        DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d, yyyy 'C.E.'");
        String bday = birthDate.format(format);

        return String.format("Person { Name = %s, Gender = %s, Birth Date = %s, Primary Email Address = %s }",
                name, gender, bday, primaryEmailAddress);
    }
}



