package com.insurance.Insurance.contracts;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.insurance.Insurance.model.InsurancePackage;
import com.insurance.Insurance.model.InsurancePackageMapper;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicyRowMapper;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsurancePolicyScheduleRowMapper;
import com.insurance.Insurance.model.InsuranceUser;
@Repository
public class InsuranceDAoImplement implements InsuranceDAO {
	private final JdbcTemplate j;

	@Autowired
	public InsuranceDAoImplement(JdbcTemplate j) {
		this.j = j;
	}


	@Override
	public List<InsurancePolicy> getAllPolicies() {
		String sql = "SELECT * FROM ish_InsurancePolicies";
		return j.query(sql, new InsurancePolicyRowMapper());
	}
	
	@Override
	public List<InsurancePolicySchedule> getAllSchedule() {
		String sql = "SELECT * FROM ish_InsurancePolicySchedule";
		return j.query(sql, new InsurancePolicyScheduleRowMapper());
	}

	@Override
	public int addPolicy(InsurancePolicy e) {
		return j.update(
				"INSERT INTO ish_InsurancePolicies (iplc_id, iplc_cust_id, iplc_cdate, iplc_sum_assured, iplc_applicable_date, iplc_insp_id, iplc_yrly_prem_amount, iplc_expdate, iplc_agnt_id, iplc_count) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				e.getId(), e.getCustomerId(), e.getCreationDate(), e.getSumAssured(), e.getApplicableDate(),
				e.getInsurancePackageId(), e.getYearlyPremiumAmount(), e.getExpiryDate(), e.getAgentId(), e.getCount());
	}

	public int updateStatus(InsurancePolicy e) {
		return j.update("UPDATE ish_InsurancePolicies SET iplc_status = ? WHERE iplc_id = ?", e.getStatus(), e.getId());

	}

	@Override
	public InsurancePolicy getPolicyById(int id) {
		String stmt = "SELECT * FROM ish_InsurancePolicies WHERE iplc_id = ?";
		return j.queryForObject(stmt, new InsurancePolicyRowMapper(), new Object[]{id});
	}
	
	@Override
	public void addPackage(InsurancePackage e) {
		j.update(
				"INSERT INTO ish_InsurancePackages (insp_title, insp_desc, insp_status, insp_range_start, insp_range_end, insp_agelimit_start, insp_agelimit_end) VALUES (?, ?, ?, ?, ?, ?, ?)",
				e.getTitle(), e.getDescription(), e.getStatus(), e.getRangeStart(), e.getRangeEnd(),
				e.getAgeLimitStart(), e.getAgeLimitEnd());
	}

	@Override
	public int updatePackage(InsurancePackage e) {
		return j.update(
				"UPDATE ish_InsurancePackages SET insp_title=?, insp_desc=?, insp_status=?, insp_range_start=?, insp_range_end=?, insp_agelimit_start=?, insp_agelimit_end=? WHERE insp_id=?",
				e.getTitle(), e.getDescription(), e.getStatus(), e.getRangeStart(), e.getRangeEnd(),
				e.getAgeLimitStart(), e.getAgeLimitEnd(), e.getId());
	}

	public void addUser(InsuranceUser e) {
		j.update(
				"INSERT INTO ish_insurance_Users (user_id, user_name, user_cdate, user_pwd, user_type, user_status) VALUES (?, ?, ?, ?, ?, ?)",
				e.getUserId(), e.getUserName(), e.getUserCDate(), e.getUserPwd(), e.getUserType(), e.getUserStatus());
	}

	public int updateUser(InsuranceUser e) {
		return j.update("update ish_insurance_Users set user_pwd = ? where user_name = ?", e.getUserPwd(),
				e.getUserName());
	}

}
