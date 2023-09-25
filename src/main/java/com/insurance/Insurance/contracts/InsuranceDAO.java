package com.insurance.Insurance.contracts;

import java.util.List;

import com.insurance.Insurance.model.InsurancePackage;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsuranceUser;

public interface InsuranceDAO {
	List<InsurancePolicySchedule> getAllSchedule();

	void addPackage(InsurancePackage e);

    int updatePackage(InsurancePackage e);

	void addUser(InsuranceUser e);

	int updateUser(InsuranceUser e);
	
	List<InsurancePolicy> getAllPolicies();


	int addPolicy(InsurancePolicy e);
	
	int updateStatus(InsurancePolicy e);
	
	InsurancePolicy getPolicyById(int id);

}
