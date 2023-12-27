package com.careerhub.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JobListing {
	
	private int JobID;
	private int CompanyID;
	private String JobTitle;
	private String JobDescription;
	private String JobLocaton;
	private int Salary;
	private String JobType;
	private LocalDate PostedDate;
	
	public JobListing() {
		
	}
	
	public JobListing(int jobID, int companyID, String jobTitle, String jobDescription, String jobLocaton, int salary,
			String jobType, LocalDate postedDate) {
		
		this.JobID = jobID;
		this.CompanyID = companyID;
		this.JobTitle = jobTitle;
		this.JobDescription = jobDescription;
		this.JobLocaton = jobLocaton;
		this.Salary = salary;
		this.JobType = jobType;
		this.PostedDate = postedDate;
	}
	
	public void apply(int applicantId, String coverLetter) {
		
	}
	
	public List<Applicant> getApplicants() {
		return new ArrayList<Applicant>();
	}
	
	public int getJobID() {
		return JobID;
	}

	public void setJobID(int jobID) {
		JobID = jobID;
	}

	public int getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}

	public String getJobTitle() {
		return JobTitle;
	}

	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}

	public String getJobDescription() {
		return JobDescription;
	}

	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}

	public String getJobLocaton() {
		return JobLocaton;
	}

	public void setJobLocaton(String jobLocaton) {
		JobLocaton = jobLocaton;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public String getJobType() {
		return JobType;
	}

	public void setJobType(String jobType) {
		JobType = jobType;
	}

	public LocalDate getPostedDate() {
		return PostedDate;
	}

	public void setPostedDate(LocalDate postedDate) {
		PostedDate = postedDate;
	}

	@Override
	public String toString() {
		return "JobListing [JobID=" + JobID + ", CompanyID=" + CompanyID + ", JobTitle=" + JobTitle
				+ ", JobDescription=" + JobDescription + ", JobLocaton=" + JobLocaton + ", Salary=" + Salary
				+ ", JobType=" + JobType + ", PostedDate=" + PostedDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CompanyID, JobDescription, JobID, JobLocaton, JobTitle, JobType, PostedDate, Salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobListing other = (JobListing) obj;
		return CompanyID == other.CompanyID && Objects.equals(JobDescription, other.JobDescription)
				&& JobID == other.JobID && Objects.equals(JobLocaton, other.JobLocaton)
				&& Objects.equals(JobTitle, other.JobTitle) && Objects.equals(JobType, other.JobType)
				&& Objects.equals(PostedDate, other.PostedDate) && Salary == other.Salary;
	}
	
	

}
