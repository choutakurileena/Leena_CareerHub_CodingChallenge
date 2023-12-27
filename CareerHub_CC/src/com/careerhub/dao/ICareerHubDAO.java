package com.careerhub.dao;

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

public interface ICareerHubDAO {
	
	public void initializeDatabase() throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException;
	public int insertJobListing(JobListing jobid) throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public int insertCompany(Company company) throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public int insertApplicant(Applicant applicant) throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public int insertJobApplication(JobApplication application) throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public List<JobListing> getJobListings() throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public List<Company> getCompanies() throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public List<Applicant> getApplicants() throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	public List<JobApplication> getApplicationsForJob(int jobID) throws ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException;
	
}
