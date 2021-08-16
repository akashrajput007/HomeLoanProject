package com.example.demo.Layer5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.AllDetails;
import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Collateral;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Document;
import com.example.demo.Layer2.Emi;
import com.example.demo.Layer2.Employment;
import com.example.demo.Layer2.Loan;
import com.example.demo.Layer2.Property;
import com.example.demo.Layer2.getEMI;
import com.example.demo.Layer4.AddressServiceImpl;
import com.example.demo.Layer4.ApplicationServiceImpl;
import com.example.demo.Layer4.CollateralService;
import com.example.demo.Layer4.CustomerServiceImpl;
import com.example.demo.Layer4.DocumentService;
import com.example.demo.Layer4.EmiServiceImp;
import com.example.demo.Layer4.EmploymentService;
import com.example.demo.Layer4.LoanServiceImpl;
import com.example.demo.Layer4.PropertyServiceImpl;


@CrossOrigin("*")
@RestController
@RequestMapping("/comp")
public class CompleteDetailsJPAController {
    
	@Autowired
	CustomerServiceImpl customerService;
	
	@Autowired
	PropertyServiceImpl propertyService;
	
	@Autowired
	EmploymentService employmentService;
	
	@Autowired
	ApplicationServiceImpl appService;
	
	@Autowired
	AddressServiceImpl addService;
	
	@Autowired
	CollateralService colService;
	
	@Autowired
	LoanServiceImpl loanService;
	
	@Autowired
	EmiServiceImp emiService;
	
	@Autowired
	DocumentService docService;
	
	@PostMapping("/upload")
	public Long insertAllDetails(@RequestBody AllDetails allDetails) {
		System.out.println("insert All details ...received from angular..");
	
		Customer customerToRegister = allDetails.getCustomer();
		Customer customer = customerService.insertCustomerService(customerToRegister);
		
		System.out.println(allDetails);
		System.out.println(customer.getAadharNumber());
		Property property = allDetails.getProperty();
        System.out.println(property.getPropertyName());
		propertyService.insertPropertyService(property , customer);
		
		Application application = allDetails.getApplication();
		System.out.println(application.getExpectedAmount());
		appService.insertApplicationService(application , customer);
		
		Employment employment = allDetails.getEmployment();
		employmentService.insertEmploymentService(employment, customer);
		
		Address address = allDetails.getAddress();
		System.out.println("address from completeDetials JPA Controller" + address + "address city" + address.getCity());
		addService.insertAddressService(address, customer);
		
		Collateral collateral = allDetails.getCollateral();
		colService.insertCollateralService(collateral, customer);
		System.out.println("collateral networth ======" + collateral.getNetworth());
		
		Document doc = allDetails.getDocument();
		docService.insertDocumentService(doc, customer);
		
		System.out.println("Insert All Details are done");
		Long applicationNo = appService.getApplicationNoService(customer);
		return applicationNo;
	}
  
	

	@GetMapping("/getAllDetails")
	public List<AllDetails> selectAllDetails(){
		
		List<Customer> customerList = customerService.selectAllCustomerService();
		List<Property> propertyList = propertyService.selectAllPropertyService();
		List<Employment> employmentList = employmentService.getAllEmploymentService();
		List<Application> applicationList = appService.selectAllApplicationService();
		List<Address> addressList = addService.selectAllAddressService();
		List<Document> docList = docService.selectAllDocumentService();
		List<AllDetails> allDetailsList = new ArrayList<>();
		for (int i = 0; i < customerList.size(); i++) {
			AllDetails allDetails = new AllDetails();
			allDetails.setCustomer(customerList.get(i));
			allDetails.setAddress(addressList.get(i));
			allDetails.setProperty(propertyList.get(i));
			allDetails.setEmployment(employmentList.get(i));
			allDetails.setApplication(applicationList.get(i));
			allDetails.setDocument(docList.get(i));
			allDetailsList.add(allDetails);
		}
		return allDetailsList;
    }
	
	
	@GetMapping(value="/approveLoan/{custId}")
	public void loanApproved(@PathVariable Long custId) {
		System.out.println("LoanApproved Controlled");
		appService.updateApplicationService(custId);
		System.out.println("update Application is working ");
		loanService.insertLoanService(custId);
		System.out.println("insert loan is working ");
		emiService.insertEMIService(custId);
		System.out.println("Insert Emi is Working ");
	}
	
	@GetMapping(value="/getEmi/{emailId}")
	public getEMI getEmi(@PathVariable String emailId) {
		Customer customer = customerService.selectCustomerByEmailService(emailId);
		Long custId = customer.getCustId();
		Loan loan = loanService.selectLoanService(custId);
		Application application = loan.getApplication();
		List<Emi> emiList = emiService.selectEMIService(custId);
	    getEMI emiDetails = new getEMI();
	    emiDetails.setCustomer(customer);
	    emiDetails.setLoan(loan);
	    emiDetails.setEmiList(emiList);
	    emiDetails.setApplication(application);
	    return emiDetails;
	}
	
	@GetMapping(value="/insertEmiDetails/{custId}")
	   public void insertEmi(@PathVariable Long custId) {
			System.out.println("Insert Emi Service called ");
			emiService.insertEMIService(custId);
	   }


}
