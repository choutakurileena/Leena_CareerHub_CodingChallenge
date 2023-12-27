package com.careerhub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.careerhub.entity.Applicant;
import com.careerhub.entity.Company;
import com.careerhub.entity.JobApplication;
import com.careerhub.entity.JobListing;
import com.careerhub.exception.ApplicationDeadlineException;
import com.careerhub.exception.DatabaseConnectionException;
import com.careerhub.exception.InvalidEmailFormatException;
import com.careerhub.exception.SalaryCalculationException;
import com.careerhub.util.DBUtil;

public class CareerHubDAOImpl implements ICareerHubDAO {
	private static Connection connection;
	@Override
	public void initializeDatabase() throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		try {
			connection = DBUtil.createConnection();
		} catch (DatabaseConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int insertJobListing(JobListing jobListing) throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		connection = DBUtil.createConnection();
		String query = "INSERT INTO JobListing(jobID, CompanyID, JobTitle, JobDescription, JobLocation, Salary, JobType, PostedDate) " + "VALUES(?,?,?,?,?,?,?,?)";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1,jobListing.getJobID());
		ps.setInt(2, jobListing.getCompanyID());
		ps.setString(3, jobListing.getJobTitle());
		ps.setString(4, jobListing.getJobDescription());
		ps.setString(5, jobListing.getJobLocaton());
		ps.setInt(6, jobListing.getSalary());
		ps.setString(7, jobListing.getJobType());
		ps.setDate(8, java.sql.Date.valueOf(jobListing.getPostedDate()));
		int result = ps.executeUpdate(); 
		DBUtil.closeConnection();
		return result;
	}

	@Override
	public int insertCompany(Company company) throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		connection = DBUtil.createConnection();
		String query = "INSERT INTO Company(CompanyName, Location) " + "VALUES(?,?)";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, company.getCompanyName());
		ps.setString(2, company.getLocation());
		int result = ps.executeUpdate(); 
		DBUtil.closeConnection();
		return result;
	}

	@Override
	public int insertApplicant(Applicant applicant) throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		connection = DBUtil.createConnection();
		String query = "INSERT INTO Applicant(FirstName, LastName, Email, Phone, Resume) " + "VALUES(?,?,?,?,?)";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setString(1, applicant.getFirstName());
		ps.setString(2, applicant.getLastName());
		ps.setString(3, applicant.getEmail());
		ps.setString(4, applicant.getPhone());
		ps.setString(5, applicant.getResume());
		int result = ps.executeUpdate(); 
		DBUtil.closeConnection();
		return result;
	}

	@Override
	public int insertJobApplication(JobApplication application) throws 
			ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		connection = DBUtil.createConnection();
		String query = "INSERT INTO JobApplication(ApplicationID, JobID, ApplicantID, ApplicationDate, CoverLetter)" + "VALUES(?,?,?,?,?)";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, application.getApplicationID());
		ps.setInt(2, application.getJobID());
		ps.setInt(3, application.getApplicantID());
		ps.setDate(4, java.sql.Date.valueOf(application.getApplicationDate()));
		ps.setString(5, application.getCoverLetter());
		int result = ps.executeUpdate(); 
		DBUtil.closeConnection();
		return result;
	}

	@Override
	public List<JobListing> getJobListings() throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		List<JobListing> jobListings = new ArrayList<>();
		JobListing jobListing = null;

		connection = DBUtil.createConnection();

		String query = "SELECT * FROM JobListing";

		PreparedStatement prepareStCustomer = connection.prepareStatement(query);

		ResultSet rsListing = prepareStCustomer.executeQuery();

		while (rsListing.next()) {// Till there are further records.
			jobListing = new JobListing(
					rsListing.getInt("jobID"),
					rsListing.getInt("companyID"),
					rsListing.getString("jobTitle"),
					rsListing.getString("jobDescription"),
					rsListing.getString("jobLocaton"),
					rsListing.getInt("salary"),
					rsListing.getString("jobType"),
					rsListing.getDate("postedDate").toLocalDate()
			);
			jobListings.add(jobListing);
		}
		DBUtil.closeConnection();

		return jobListings;
	}

	@Override
	public List<Company> getCompanies() throws  ApplicationDeadlineException,
			SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		List<Company> companies = new ArrayList<>();
		Company company = null;

		connection = DBUtil.createConnection();

		String query = "SELECT * FROM Company";

		PreparedStatement prepareStCustomer = connection.prepareStatement(query);

		ResultSet rsCompanies = prepareStCustomer.executeQuery();

		while (rsCompanies.next()) {// Till there are further records.
			company = new Company(
					rsCompanies.getInt("companyID"),
					rsCompanies.getString("companyName"),
					rsCompanies.getString("location")
			);
			companies.add(company);
		}
		DBUtil.closeConnection();

		return companies;
	}

	@Override
	public List<Applicant> getApplicants() throws  ApplicationDeadlineException,
			 SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		// TODO Auto-generated method stub
		List<Applicant> applicants = new ArrayList<>();
		Applicant applicant = null;

		connection = DBUtil.createConnection();

		String query = "SELECT * FROM Applicant";

		PreparedStatement prepareStCustomer = connection.prepareStatement(query);

		ResultSet rs = prepareStCustomer.executeQuery();

		while (rs.next()) {// Till there are further records.
			applicant = new Applicant(
					rs.getInt("applicantID"),
					rs.getString("firstName"),
					rs.getString("lastName"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("resume")
			);
			applicants.add(applicant);
		}
		DBUtil.closeConnection();

		return applicants;
	}

	@Override
	public List<JobApplication> getApplicationsForJob(int jobID) throws 
			ApplicationDeadlineException, SalaryCalculationException, InvalidEmailFormatException, ClassNotFoundException, SQLException, DatabaseConnectionException {
		List<JobApplication> jobApplications = new ArrayList<>();
		JobApplication jobApplication = null;

		connection = DBUtil.createConnection();

		String query = "SELECT * FROM JobApplication where jobID = ?";

		PreparedStatement ps = connection.prepareStatement(query);
		ps.setInt(1, jobID);
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {// Till there are further records.
			jobApplication = new JobApplication(
					rs.getInt("applicationID"),
					rs.getInt("jobID"),
					rs.getInt("applicantID"),
					rs.getDate("applicationDate").toLocalDate(),
					rs.getString("coverLetter")
			);
			jobApplications.add(jobApplication);
		}
		DBUtil.closeConnection();

		return jobApplications;
	}
	
}
