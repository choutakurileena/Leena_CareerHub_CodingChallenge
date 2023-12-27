package com.careerhub.entity;

import java.time.LocalDate;
import java.util.Objects;

public class JobApplication {
	
	private int ApplicationID;
	private int JobID;
	private int ApplicantID;
	private LocalDate ApplicationDate;
	private String CoverLetter;

	public JobApplication() {
		
	}

	public JobApplication(int applicationID, int jobID, int applicantID, LocalDate applicationDate, String coverLetter) {
		
		this.ApplicationID = applicationID;
		this.JobID = jobID;
		this.ApplicantID = applicantID;
		this.ApplicationDate = applicationDate;
		this.CoverLetter = coverLetter;
	}

	public int getApplicationID() {
		return ApplicationID;
	}

	public void setApplicationID(int applicationID) {
		ApplicationID = applicationID;
	}

	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public int getApplicantID() {
		return ApplicantID;
	}

	public void setApplicantID(int applicantID) {
		ApplicantID = applicantID;
	}

	public LocalDate getApplicationDate() {
		return ApplicationDate;
	}

	public void setApplicationDate(LocalDate applicationDate) {
		ApplicationDate = applicationDate;
	}

	public String getCoverLetter() {
		return CoverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		CoverLetter = coverLetter;
	}

	@Override
	public String toString() {
		return "JobApplication [ApplicationID=" + ApplicationID + ", JobID=" + JobID + ", ApplicantID=" + ApplicantID
				+ ", ApplicationDate=" + ApplicationDate + ", CoverLetter=" + CoverLetter + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(ApplicantID, ApplicationDate, ApplicationID, CoverLetter, JobID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobApplication other = (JobApplication) obj;
		return ApplicantID == other.ApplicantID && Objects.equals(ApplicationDate, other.ApplicationDate)
				&& ApplicationID == other.ApplicationID && Objects.equals(CoverLetter, other.CoverLetter)
				&& JobID == other.JobID;
	}
	

}
