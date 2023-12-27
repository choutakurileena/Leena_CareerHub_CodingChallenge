package com.careerhub.service;

import java.sql.SQLException;
import java.util.List;

import com.careerhub.entity.Applicant;
import com.careerhub.entity.Company;
import com.careerhub.entity.JobApplication;
import com.careerhub.entity.JobListing;
import com.careerhub.exception.ApplicationDeadlineException;
import com.careerhub.exception.DatabaseConnectionException;
import com.careerhub.exception.InvalidEmailFormatException;
import com.careerhub.exception.SalaryCalculationException;


public interface ICareerHubService {

	public void initializeDatabase() throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException;
	public int insertJobListing(JobListing jobid) throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException;
	public int insertCompany(Company company) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public int insertApplicant(Applicant applicant) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public int insertJobApplication(JobApplication application) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public List<JobListing> getJobListings() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public List<Company> getCompanies() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public List<Applicant> getApplicants() throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException;
	public List<JobApplication> getApplicationsForJob(int jobID) throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException;
	public List<JobListing> getJobListingsWithinSalaryRange() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
}

