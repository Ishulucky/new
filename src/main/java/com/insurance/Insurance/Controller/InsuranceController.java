package com.insurance.Insurance.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.Insurance.Repository.InsuranceRepository;
import com.insurance.Insurance.contracts.InsuranceDAO;
import com.insurance.Insurance.model.InsurancePackage;
import com.insurance.Insurance.model.InsurancePolicy;
import com.insurance.Insurance.model.InsurancePolicySchedule;
import com.insurance.Insurance.model.InsuranceUser;


@RestController

public class InsuranceController {


    @Autowired
    private InsuranceRepository insuranceRepository;

    @GetMapping("/policy")
	public List<InsurancePolicy> getAllPolicy() {
		return insuranceRepository.ListAllPolicy();
	}
    
    @GetMapping("/policySchedule")
	public List<InsurancePolicySchedule> getAllPolicySchedule() {
		return insuranceRepository.ListAllPolicySchedules();
	}

	@PostMapping(value = "/createpolicy")
	public ResponseEntity<Object> createPolicy(@RequestBody InsurancePolicy u) {
		insuranceRepository.createNewPolicy(u);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/updatepolicy")
    public ResponseEntity<Object> updatePolicy(@RequestBody InsurancePolicy p) {
        int result = insuranceRepository.createNewPolicy(p);
        if (result > 0) {
            return new ResponseEntity<>("Package is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Package update failed", HttpStatus.NOT_FOUND);
        }
    }
    
    @PostMapping("/addpackage")
    public ResponseEntity<Object> addPackage(@RequestBody InsurancePackage p) {
        insuranceRepository.addPackage(p);
        return new ResponseEntity<>("Package is added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/updatepack/{id}")
    public ResponseEntity<Object> updatePackage(@RequestBody InsurancePackage p, @PathVariable Integer id) {
        int result = insuranceRepository.updatePackage(p);
        if (result > 0) {
            return new ResponseEntity<>("Package is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Package update failed", HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/getpolicyid")
	public String getCustomerDetails(@RequestParam("Id") String Id, Model model) {
		model.addAttribute("customer", insuranceRepository.getPolicyeById(Integer.parseInt(Id)));
		return "customerDetails";
	}

    @PostMapping("/adduser")
	public ResponseEntity<Object> createEmployee(@RequestBody InsuranceUser u) {
		insuranceRepository.addUser(u);
		return new ResponseEntity<>("Employee is created successfully", HttpStatus.CREATED);
	}
	
    @PutMapping("/updateuser")
    public ResponseEntity<Object> updateUser(@RequestBody InsuranceUser user) {
        int result = insuranceRepository.updateUser(user);
        if (result > 0) {
            return new ResponseEntity<>("User is updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User update failed", HttpStatus.NOT_FOUND);
        }
    }

}
