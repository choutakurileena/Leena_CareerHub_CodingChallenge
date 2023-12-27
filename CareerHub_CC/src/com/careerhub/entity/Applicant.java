package com.careerhub.entity;

import java.util.Objects;

import com.careerhub.exception.InvalidEmailFormatException;

public class Applicant {

	private int ApplicantID;
	private String FirstName;
	private String LastName;
	private String Email;
	private String Phone;
	private String Resume;
	
	public Applicant() {
		
	}

	public Applicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
		
		this.ApplicantID = applicantID;
		this.FirstName = firstName;
		this.LastName = lastName;
		this.Email = email;
		this.Phone = phone;
		this.Resume = resume;
	}
	
	public void createProfile(String email, String firstName, String lastName, String phone, String resume) throws InvalidEmailFormatException {
		if(!isValidEmail(email)) {
			throw new InvalidEmailFormatException("Invalid Email Address provided. Please check...");
		}
	}
	
	public void applyForJob(int jobId, String coverLetter) {
		
	}
	
	public boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".");
	}
	
	public boolean isFileSuccesfullyUploaded(String resume) {
		return resume.endsWith(".pdf");// for now just validating the resume with pdf extension to handle custom exceptions
	}

	public int getApplicantID() {
		return ApplicantID;
	}

	public void setApplicantID(int applicantID) {
		ApplicantID = applicantID;
	}

	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getResume() {
		return Resume;
	}

	public void setResume(String resume) {
		Resume = resume;
	}

	@Override
	public String toString() {
		return "Applicant [ApplicantID=" + ApplicantID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Email=" + Email + ", Phone=" + Phone + ", Resume=" + Resume + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ApplicantID, Email, FirstName, LastName, Phone, Resume);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		return ApplicantID == other.ApplicantID && Objects.equals(Email, other.Email)
				&& Objects.equals(FirstName, other.FirstName) && Objects.equals(LastName, other.LastName)
				&& Objects.equals(Phone, other.Phone) && Objects.equals(Resume, other.Resume);
	}
	
	
}
