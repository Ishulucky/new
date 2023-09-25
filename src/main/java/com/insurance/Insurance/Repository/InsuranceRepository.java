package com.insurance.Insurance.Repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.insurance.Insurance.contracts.InsuranceDAO;
import com.insurance.Insurance.model.InsurancePackage;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsuranceUser;

@Repository
public class InsuranceRepository {
	@Autowired
    private InsuranceDAO insuranceDAO;

    public List<InsurancePolicy> ListAllPolicy() {
		List<InsurancePolicy> pack = insuranceDAO.getAllPolicies();
		return pack;
	}
    
    public List<InsurancePolicySchedule> ListAllPolicySchedules() {
		List<InsurancePolicySchedule> s = insuranceDAO.getAllSchedule();
		return s;
	}

	public int createNewPolicy(InsurancePolicy u) {
		return  insuranceDAO.addPolicy(u);
	}
	
	public int updateNewPolicy(InsurancePolicy u) {
        return insuranceDAO.updateStatus(u);
    }

	
	public InsurancePolicy getPolicyeById(int id) {
		return insuranceDAO.getPolicyById(id);
	}
	
    public void addPackage(InsurancePackage e) {
        insuranceDAO.addPackage(e);
    }

    public int updatePackage(InsurancePackage e) {
        return insuranceDAO.updatePackage(e);
    }

    public void addUser(InsuranceUser e) {
        insuranceDAO.addUser(e);
    }

    public int updateUser(InsuranceUser e) {
        return insuranceDAO.updateUser(e);
    }

	
}

