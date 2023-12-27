package com.careerhub.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Company {
	
	private int CompanyID;
	private String CompanyName;
	private String Location;
	
	public Company() {
		
	}
	
	public Company(int companyID, String companyName, String location) {
		
		this.CompanyID = companyID;
		this.CompanyName = companyName;
		this.Location = location;
	}

	public List<JobListing> getJobs() {
		return new ArrayList<JobListing>();
	}
	
	public void postJob(String jobTitle, String jobDescription, String jobLocation, int salary, String jobType) {
		
	}
	
	public int getCompanyID() {
		return CompanyID;
	}

	public void setCompanyID(int companyID) {
		CompanyID = companyID;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	@Override
	public String toString() {
		return "Company [CompanyID=" + CompanyID + ", CompanyName=" + CompanyName + ", Location=" + Location + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CompanyID, CompanyName, Location);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Company other = (Company) obj;
		return CompanyID == other.CompanyID && Objects.equals(CompanyName, other.CompanyName)
				&& Objects.equals(Location, other.Location);
	}
	
	
}
