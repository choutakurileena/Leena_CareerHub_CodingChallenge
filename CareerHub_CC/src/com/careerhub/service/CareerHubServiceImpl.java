package com.careerhub.service;

import java.sql.SQLException;
import java.util.List;

import com.careerhub.dao.CareerHubDAOImpl;
import com.careerhub.dao.ICareerHubDAO;
import com.careerhub.entity.Applicant;
import com.careerhub.entity.Company;
import com.careerhub.entity.JobApplication;
import com.careerhub.entity.JobListing;
import com.careerhub.exception.ApplicationDeadlineException;
import com.careerhub.exception.DatabaseConnectionException;
import com.careerhub.exception.InvalidEmailFormatException;
import com.careerhub.exception.SalaryCalculationException;


public class CareerHubServiceImpl implements ICareerHubService {
	
	private ICareerHubDAO iCareerHubDAO;
	
	public CareerHubServiceImpl() {
		super();
		iCareerHubDAO = new CareerHubDAOImpl();
	}

	@Override
	public void initializeDatabase() throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException {
		// TODO Auto-generated method stub
		iCareerHubDAO.initializeDatabase();
	}

	@Override
	public int insertJobListing(JobListing jl) throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException {
		// TODO Auto-generated method stub
		
		return iCareerHubDAO.insertJobListing(jl);
	}

	@Override
	public int insertCompany(Company company) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.insertCompany(company);
	}

	@Override
	public int insertApplicant(Applicant applicant) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.insertApplicant(applicant);
	}

	@Override
	public int insertJobApplication(JobApplication application) throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.insertJobApplication(application);
	}

	@Override
	public List<JobListing> getJobListings() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.getJobListings();
	}
	
	public List<JobListing> getJobListingsWithinSalaryRange() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.getJobListings();
	}

	@Override
	public List<Company> getCompanies() throws DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.getCompanies();
	}

	@Override
	public List<Applicant> getApplicants() throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException {
		// TODO Auto-generated method stub
		return iCareerHubDAO.getApplicants();
	}

	@Override
	public List<JobApplication> getApplicationsForJob(int jobID) throws ClassNotFoundException, DatabaseConnectionException, ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, SQLException {
		// TODO Auto-generated method stub
		List<JobApplication> jobApplications = iCareerHubDAO.getApplicationsForJob(jobID);
		if(jobApplications.size()==0) {
			System.out.println("No Applications found for the entered jobId");
		}
		return jobApplications;
	}


	
	
}
