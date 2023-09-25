package com.insurance.Insurance.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsurancePolicyRowMapper implements RowMapper<InsurancePolicy> {
    @Override
    public InsurancePolicy mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setId(resultSet.getInt("iplc_id"));
        policy.setCustomerId(resultSet.getInt("iplc_cust_id"));
        policy.setCreationDate(resultSet.getDate("iplc_cdate"));
        policy.setSumAssured(resultSet.getDouble("iplc_sum_assured"));
        policy.setApplicableDate(resultSet.getDate("iplc_applicable_date"));
        policy.setInsurancePackageId(resultSet.getInt("iplc_insp_id"));
        policy.setYearlyPremiumAmount(resultSet.getDouble("iplc_yrly_prem_amount"));
        policy.setExpiryDate(resultSet.getDate("iplc_expdate"));
        policy.setAgentId(resultSet.getInt("iplc_agnt_id"));
        policy.setStatus(resultSet.getString("iplc_status"));
        policy.setCount(resultSet.getInt("iplc_count"));
        return policy;
    }
}
