package com.example.demo;
import java.time.LocalDate;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.Layer2.Address;
import com.example.demo.Layer2.Admin;
import com.example.demo.Layer2.Application;
import com.example.demo.Layer2.Collateral;
import com.example.demo.Layer2.Customer;
import com.example.demo.Layer2.Document;
import com.example.demo.Layer2.Employment;
import com.example.demo.Layer2.Loan;
import com.example.demo.Layer2.Property;
import com.example.demo.Layer3.AddressRepositoryImpl;
import com.example.demo.Layer3.AdminValidationRepositoryImpl;
import com.example.demo.Layer3.ApplicationRepositoryImpl;
import com.example.demo.Layer3.CollateralRepositoryImpl;
import com.example.demo.Layer3.CustomerRepositoryImpl;
import com.example.demo.Layer3.DocumentRepositoryImpl;
import com.example.demo.Layer3.InsertEmploymentImpl;
import com.example.demo.Layer3.LoanAccountNoRepositoryImpl;
import com.example.demo.Layer3.LoanInsertRepositoryImpl;
import com.example.demo.Layer3.LoanRepository;
import com.example.demo.Layer3.LoanTrackerRepositoryImpl;
import com.example.demo.Layer3.PropertyRepositoryImpl;
import com.example.demo.Layer3.Exceptions.AddressNotFoundException;
import com.example.demo.Layer3.Exceptions.ApplicationNotFoundException;
import com.example.demo.Layer3.Exceptions.CustomerNotFoundException;
import com.example.demo.Layer3.Exceptions.EmploymentNotFoundException;
import com.example.demo.Layer3.Exceptions.PropertyNotFoundException;

@SpringBootTest
 class Testing {
	@Autowired		// Customer
	CustomerRepositoryImpl cust = new CustomerRepositoryImpl();
	@Test		// Customer Test1 
	 void selectCustomer() {
		 Customer c = cust.selectCustomer(1l);
		 System.out.println("Customer Name "+ c.getFirstName());
		 System.out.println("Customer Phone No "+ c.getPhoneNumber());
		 System.out.println("Customer Phone No "+ c.getEmailId());
		
	}
	@Test		// Customer Test2
	void insertCustomer() {
		Customer c = new Customer();
		LocalDate sDate1 = LocalDate.now();
		c.setAadharNumber("1233456789");
		c.setDateOfBirth(sDate1);
		c.setEmailId("abcd@gmail.com");
		c.setFirstName("Janet");
		c.setGender("F");
		c.setLastName("Jones");
		c.setMiddleName("Mary12");
		c.setPanNumber("bp1232345");
		c.setPassword("Mary");
		c.setPhoneNumber("987654321");
		c.setTitle("mrs");
		cust.insertCustomer(c);
		//assertEquals(cust.selectCustomer(44l), c);
		
	}
	@Test		// Customer Test3
	void selectAllCustomer() {
		List<Customer> custList =  cust.selectAllCustomer();
		System.out.println("Customer List");
		for(Customer c : custList) {
			System.out.println("Customer  :" + c.getCustId());
			System.out.println("Customer  :" + c.getFirstName());
			System.out.println("Customer Name "+ c.getFirstName());
			System.out.println("Customer Phone No "+ c.getPhoneNumber());
			System.out.println("Customer Phone No "+ c.getEmailId());
		}
		
	}
	@Test
	void deleteCustomer() {
		try {
			cust.deleteCustomer(21l);
			System.out.println("Customer Deleted");
		} catch (CustomerNotFoundException e) {
			// TODO Auto-generated catch block
			
		}
	}
	
	@Autowired		//Property
	PropertyRepositoryImpl prop = new PropertyRepositoryImpl();
	@Test		//Property Test1
	void selectProperty(){
		System.out.println("Property");
		Property p = prop.selectProperty(1l);
		System.out.println("Property Name : "+p.getPropertyName());
		System.out.println("Property Location : "+p.getPropertyLocation());
		System.out.println("Property Cost : "+p.getCost());
	}
	@Test		//Property Test2
	void insertProperty(){
		Customer c = cust.selectCustomer(21l);
		Property p = new Property();
		p.setCost(4000000d);
		p.setCustomer(c);
		p.setPropertyLocation("Andheri , Mumbai");
		p.setPropertyName("Spring Cottage");
		prop.insertProperty(p);
	}
	@Test
	void deleteProperty() {
		try {
			prop.deleteProperty(44l);
			System.out.println("Property Details Deleted");
		} catch (PropertyNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void selectAllProperty() {
		List <Property> AllProp = prop.selectAllProperty();
		System.out.println("Property List");
		for(Property p : AllProp) {
			System.out.println("Property Name : "+p.getPropertyName());
			System.out.println("Property Location : "+p.getPropertyLocation());
			System.out.println("Property Cost : "+p.getCost());
		}
	}
    @Autowired		//Admin Login Validation
	AdminValidationRepositoryImpl adVal = new AdminValidationRepositoryImpl();
	@Test			//Admin Login Validation Test1 
	void getValidation(){
		System.out.println("ADMIN");
		Admin a = adVal.getValidation("ADMIN","Admin123");
		if (a != null) {
			System.out.println("Correct Credentials");
		}
		else {
			System.out.println("Incorrect Credentials");
		}
	}
	@Autowired		//Loan Account no 
	LoanAccountNoRepositoryImpl loanNo = new LoanAccountNoRepositoryImpl();	
	@Test		//Loan Account no Test1
	void loanAccountNo(){
		System.out.println("Loan Account No");
		List<Loan> l = loanNo.getNo(1l);
		if( l!=null)
			System.out.println("Loan Id : "+l);  
		else
			System.out.println("No Loan Details Found");
			
	}
	@Autowired		//Loan Tracker
	LoanTrackerRepositoryImpl loanTrack = new LoanTrackerRepositoryImpl();
	@Test		//Loan Tracker Test1
	void loanTracker(){
		System.out.println("Loan Status");
		Application a = loanTrack.getStatus(1l,"8839091067");
		if(a!=null)
			System.out.println("Status : "+a.getStatus());
		else
			System.out.println("No Loan Status Found");
			
	}
	@Autowired		//Document
	DocumentRepositoryImpl document = new DocumentRepositoryImpl();
	@Test 		//Document test 1
	void insertDocument(){
		Document d = new Document();
		Customer c = cust.selectCustomer(44l);
		d.setAadharCard("PQY");
		d.setAgreementToSale("PQY");
		d.setCustomer(c);
		d.setItrc("PQY");
		d.setLoa("PQY");
		d.setNoc("PQY");
		d.setPanCard("PQY");
		d.setPhotograph("PQY");
		d.setSalarySlip("PQY");
		d.setSignature("PQY");
		d.setVoterId("PQY");
		document.insertDocument(d);
	}
	@Test		//Document test 2
	void selectDocument(){
		Document d = document.selectDocument(1l);
		System.out.println("Document :"+d.getAadharCard());
		System.out.println("Document :"+d.getAgreementToSale());
		System.out.println("Document :"+d.getItrc());
		System.out.println("Document :"+d.getLoa());
		System.out.println("Document :"+d.getNoc());
		System.out.println("Document :"+d.getPanCard());
		System.out.println("Document :"+d.getPhotograph());
		System.out.println("Document :"+d.getSalarySlip());
		System.out.println("Document :"+d.getSignature());
		System.out.println("Document :"+d.getVoterId());
		
	}
	@Autowired		// Loan Balance
	LoanRepository loan;
	@Test		//Loan Balance Test 1
	void getBalance(){
		Long l =loan.getBalance(1l);
		System.out.println("Balance : "+l);
	}
	@Autowired
	ApplicationRepositoryImpl application = new ApplicationRepositoryImpl();	//Application
	@Test		//Application Test 1
	void insertApplication(){
		Application a = new Application();
		Customer c = cust.selectCustomer(44l);
		a.setCustomer(c);
		a.setStatus("APPROVED");
		a.setTenure(10);
		a.setExpectedAmount(10000d);
		application.insertApplication(a);
		System.out.println("Application Inserted");
	}
	@Test  //Application Test 2
	void selectAllApplication(){
		List <Application> a = application.selectAllApplication();
		System.out.println("Application List");
		for(Application app : a) {
			System.out.println("Application No :" + app.getApplicationNo());
			System.out.println("Application No :" + app.getStatus());
			System.out.println("Application No :" + app.getTenure());
			
		}
	}
	@Test
	void getApplicationByCustID() {
		Application a = application.getApplicationByCustID(1l);
		System.out.println("Status "+a.getStatus());
		System.out.println("Application No "+a.getApplicationNo());
		System.out.println("Expected Amount "+a.getExpectedAmount());
		System.out.println("Tenure "+a.getTenure());
	}
	@Test
	void deleteApplication() {
		try {
			application.deleteApplication(44l);
			System.out.println("Application Deleted...");
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void updateStatus() {
		
		try {
			application.updateStatus(44l);
			System.out.println("Status Updated");
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	void updateApplication() {
		try {
			application.updateApplication(44l);
			System.out.println("Application Updated");
		} catch (ApplicationNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Autowired
	CollateralRepositoryImpl colateral = new CollateralRepositoryImpl();		//Collateral
	
	@Test		//Collateral Test 1
	void insertCollateral(){
		Collateral col= new Collateral();
		Customer c = cust.selectCustomer(44l);
		col.setCollateralType("Gold");
		col.setCustomer(c);
		colateral.insertCollateral(col);
	}
	@Test		//Collateral Test 1
	void getCollateralByCustID(){
		Collateral c = colateral.getCollateralByCustID(44l);
		System.out.println("Collateral Type "+c.getCollateralType());
		System.out.println("Collateral NetWorth "+c.getNetworth());
	}
	@Test		//Collateral Test 1
	void getAllCollateral(){
		
		List <Collateral> c = colateral.getAllCollateral();
		System.out.println("Collateral List");
		for(Collateral colateral : c) {
			System.out.println("Collateral Type "+colateral.getCollateralType());
			System.out.println("Collateral Net Worth "+colateral.getNetworth());
			
			}
		}
	@Autowired
	InsertEmploymentImpl emp = new InsertEmploymentImpl();		//Employment
	@Test
	void insertEmployment(){
		Employment e = new Employment();
		Customer c = cust.selectCustomer(44l);
		e.setCustomer(c);
		e.setEmployerName("Abc Company");
		e.setIncomeFromOtherSources(10000d);
		e.setNetMonthlyIncome(25000d);
		e.setOrganizationType("Private");
		e.setRetirementAge("60");
		e.setTypeOfEmployement("IT");
		e.setWorkExperience(10);
	    emp.insertEmployment(e);
	
	}
	
	@Test
	void getAllEmployment(){
		List<Employment> e = emp.getAllEmployment();
		System.out.println("Employment List");
		for(Employment emp : e) {
			System.out.println("Employer Name "+emp.getEmployerName());
			System.out.println("Type of Employment "+emp.getTypeOfEmployement());
			System.out.println("Work Experience "+emp.getWorkExperience());
			System.out.println("Net Monthly Income "+emp.getNetMonthlyIncome());
		}
	}
	@Test
	void deleteEmployment() {
		try {
			emp.deleteEmployment(44l);
			System.out.println("Employment Details Deleted");
		} catch (EmploymentNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Autowired		//Address
	AddressRepositoryImpl add = new AddressRepositoryImpl();
	@Test
	void insertAddress() {
		Customer c = cust.selectCustomer(44l);
		Address a = new Address();
		a.setAddress("29, Walnut Street");
		a.setCity("Chennai");
		a.setCustomer(c);
		a.setPinCode(641006);
		a.setState("Tamil nadu");
		add.insertAddress(a);
		System.out.println("Address Inserted ...");
	}
	
	@Test
	void selectAllAddress() {
		List<Address> a = add.selectAllAddress();
		System.out.println("Address List");
		for(Address add : a) {
			System.out.println("Address Id "+add.getAddressId());
			System.out.println("Address "+add.getAddress());
			System.out.println("City "+add.getCity());
			System.out.println("State "+add.getState());
			System.out.println("Pincode "+add.getPinCode());
			
		}
	}
	@Test
	void selectAddressByCustID() {
		
			try {
				Address a = add.selectAddressByCustID(3l);
				System.out.println("Address Id"+a.getAddressId());
				System.out.println("Address "+a.getAddress());
				System.out.println("City "+a.getCity());
				System.out.println("State "+a.getState());
				System.out.println("Pincode "+a.getPinCode());
			} catch (AddressNotFoundException e) {
				
				e.printStackTrace();
			}
		
	}
	
	@Test
	void deleteAddress() {
		try {
			add.deleteAddress(21l);
			System.out.println("Address Deleted ...");
		} catch (AddressNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Autowired
	LoanInsertRepositoryImpl l = new LoanInsertRepositoryImpl(); // Loan 
	@Test
	void insertLoan() {
		Loan loan = new Loan();
		Application a = application.getApplicationByCustID(44l);
		loan.setAmountPaid(1000d);
		loan.setAmountWithInterest(12000d);
		loan.setApplication(a);
		loan.setApprovedAmount(120000d);
		loan.setBalance(1000d);
		loan.setEmiAmount(200d);
		l.insertLoan(6l);
	}
	
		
}