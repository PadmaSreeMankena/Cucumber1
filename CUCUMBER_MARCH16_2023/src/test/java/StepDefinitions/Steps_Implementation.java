package StepDefinitions;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps_Implementation {
	
	WebDriver driver;
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		
		//System.out.println("User launch chrome browser");
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);// Implicit wait 
	
	}
	
	
	@When("User opens URL {string}")
	public void user_opens_url(String TestURL) {
		
		//System.out.println("User opens URL...."+TestURL);
		driver.get(TestURL);

	}
	
	
	@When("User enters username as {string} and password as {string}")
	public void user_enters_username_as_and_password_as(String UserName, String Password) throws Exception {
	
		//System.out.println("UserName...."+UserName);
		//System.out.println("Password...."+Password);
		findElement(By.name("username")).sendKeys(UserName);
		findElement(By.name("password")).sendKeys(Password);
		findElement(By.xpath("//*[@id='app']/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
		
		
	}
	  
	
	@Then("Go to Skill Page")
	public void go_to_skill_page() throws Exception {
		
		//System.out.println("Go to Skill Page....");
		findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[1]/a/span")).click();
		findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[4]/span")).click();
		findElement(By.xpath("//*[@id='app']/div[1]/div[1]/header/div[2]/nav/ul/li[4]/ul/li[1]")).click();
	 
	}
	
	
	
	@When("Add skills with skillname as {string} and skilldescription as {string}")
	public void add_skills_with_skillname_as_and_skilldescription_as(String SkillName, String SkillDescr) throws Exception {
		
		//System.out.println("SkillName...."+SkillName);
		//System.out.println("SkillDescr...."+SkillDescr);
		
		findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/div[1]/div/button")).click();
		findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div/div[2]/input")).sendKeys(SkillName);
		findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/textarea")).sendKeys(SkillDescr);
		Thread.sleep(5000);
		findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]")).click();
		

	    
	}
	
	
	
	@When("Click on logout button")
	public void click_on_logout_button() throws Exception {
		
		//System.out.println("Click on Welcome>logout button....");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		findElement(By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']")).click();
		findElement(By.linkText("Logout"));
	
	}
	
	
	@Then("Close Browser")
	public void close_browser() throws InterruptedException {
		
		//System.out.println("Clse Browser....");
		Thread.sleep(7000);
		driver.close();
	
	}
	
	
	 public  WebElement findElement(By by) throws Exception 
		{

			WebElement elem = driver.findElement(by);  
			
			if (driver instanceof JavascriptExecutor) 
			{
			 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		 
			}
			return elem;
		}

	
	 
	 @Then("Go to Nationality Page")
	 public void go_to_nationality_page() throws Exception {
	   
		 findElement(By.xpath("//span[text()='Admin']")).click(); //Admin
			findElement(By.xpath("//a[text()='Nationalities']")).click();//Nationalities
		 
	 }
	 
	 
	 @When("Add Nationality record as {string}")
	 public void add_nationality_record_as(String NationalityText) throws Exception {
		 
		 findElement(By.xpath("(//button[@type='button'])[2]")).click(); //Addbuttonn
			findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(NationalityText);
			
			Thread.sleep(5000);
			findElement(By.xpath("//button[@type='submit']")).click();
	  
	 }
	 
	 
	 @Then("Go to Jobs Page")
	 public void go_to_jobs_page() throws Exception {
		 
		 findElement(By.xpath("(//a[@class='oxd-main-menu-item'])[1]")).click();
			findElement(By.xpath("//span[text()='Job ']")).click();
			findElement(By.xpath("//a[text()='Job Titles']")).click();
	   
	 }
	 
	 
	 @When("Create Job record as JobTitle {string} JobDescr {string} JobNote {string}")
	 public void create_job_record_as_job_title_job_descr_job_note(String JobTitle, String JobDescr, String JobNote) throws InterruptedException {
	
		 
		 driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
			driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(JobTitle);
			driver.findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(JobDescr);
			driver.findElement(By.xpath("//textarea[@placeholder='Add note']")).sendKeys(JobNote);
			
			Thread.sleep(8000);
			
			driver.findElement(By.xpath("//button[text()=' Save ']")).click();
			
	 }
	 
	 
	 @Then("Create Skills Record")
		public void create_skills_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
			
			List<List<String>> SkillsData=dataTable.cells();
			
			
			System.out.println("Number of rows :"+SkillsData.size());
			
			for(int i=0;i<SkillsData.size();i++) {
				
				//System.out.println(SkillsData.get(i).get(0));
				
				String SkillName=SkillsData.get(i).get(0);
				String SkillDescr=SkillsData.get(i).get(1);
				
				System.out.println("____________________________");
				
				  findElement(By.xpath("//span[text()='Admin']")).click();
				  findElement(By.xpath("//span[text()='Qualifications ']")).click();
				  findElement(By.xpath("//a[text()='Skills']")).click();
				  findElement(By.xpath("//button[text()=' Add ']")).click();
				  
				 findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(SkillName);
				  findElement(By.xpath("//textarea[@placeholder='Type description here']")).sendKeys(SkillDescr);
				  
				  Thread.sleep(5000);
				  findElement(By.xpath("//button[text()=' Save ']")).click();
				

		}
	 }	
			
			
	 @Then("Create Nationality Record")
	 public void create_nationality_record(io.cucumber.datatable.DataTable dataTable) throws Exception {
		 
		 
		 List<List<String>> NationalityData=dataTable.cells();
			
			
			System.out.println("Number of rows :"+NationalityData.size());
			
			for(int i=0;i<NationalityData.size();i++) {
				
				//System.out.println(SkillsData.get(i).get(0));
				
				String NationalityText=NationalityData.get(i).get(0);
				
				
				System.out.println("____________________________");
				
				  findElement(By.xpath("//span[text()='Admin']")).click();
				  findElement(By.linkText("Nationalities")).click();
				  findElement(By.xpath("//button[text()=' Add ']")).click();
				  findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]")).sendKeys(NationalityText);
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("//button[text()=' Save ']")).click();
				
				}
	 }
	
			
			
			
			
			
			
			
			
			
			
			
	

	 
}
