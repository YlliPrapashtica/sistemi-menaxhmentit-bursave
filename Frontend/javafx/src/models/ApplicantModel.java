package models;

import java.time.OffsetDateTime;
 

public class ApplicantModel {
    private String id;
    private String first_name;
    private String last_name;
    private String personal_number;
    private String student_card_number;
    private String email;
    private String phone;
    private String university;
    private String faculty;
    private String scholarship;
    private String cv;
    private String extra_documents;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt; 
    private String fullname; 
   
    
    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getFirstName() { return first_name; }
    public void setFirstName(String value) { this.first_name = value; }

    public String getLastName() { return last_name; }
    public void setLastName(String value) { this.last_name = value; }

    public String getPersonalNumber() { return personal_number; }
    public void setPersonalNumber(String value) { this.personal_number = value; }

    public String getStudentCardNumber() { return student_card_number; }
    public void setStudentCardNumber(String value) { this.student_card_number = value; }

    public String getEmail() { return email; }
    public void setEmail(String value) { this.email = value; }

    public String getPhone() { return phone; }
    public void setPhone(String value) { this.phone = value; }

    public String getUniversity() { return university; }
    public void setUniversity(String value) { this.university = value; }

    public String getFaculty() { return faculty; }
    public void setFaculty(String value) { this.faculty = value; }

    public String getScholarship() { return scholarship; }
    public void setScholarship(String value) { this.scholarship = value; }

    public String getCv() { return cv; }
    public void setCv(String value) { this.cv = value; }

    public String getExtraDocuments() { return extra_documents; }
    public void setExtraDocuments(String value) { this.extra_documents = value; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; } 

    public String getFullname() { return fullname; }
    public void setFullname(String value) { this.fullname = value; } 
}