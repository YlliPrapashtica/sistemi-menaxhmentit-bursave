package models;

import java.time.OffsetDateTime;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApplicantModel {
    private String id;
    private String firstName;
    private String lastName;
    private String personalNumber;
    private String studentCardNumber;
    private String email;
    private String phone;
    private String university;
    private String faculty;
    private String scholarship;
    private String cv;
    private String extraDocuments;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt; 
    private String fullname; 
 
    
    public String getID() { return id; }
    public void setID(String value) { this.id = value; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String value) { this.firstName = value; }

    public String getLastName() { return lastName; }
    public void setLastName(String value) { this.lastName = value; }

    public String getPersonalNumber() { return personalNumber; }
    public void setPersonalNumber(String value) { this.personalNumber = value; }

    public String getStudentCardNumber() { return studentCardNumber; }
    public void setStudentCardNumber(String value) { this.studentCardNumber = value; }

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

    public String getExtraDocuments() { return extraDocuments; }
    public void setExtraDocuments(String value) { this.extraDocuments = value; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime value) { this.updatedAt = value; } 

    public String getFullname() { return fullname; }
    public void setFullname(String value) { this.fullname = value; } 
}