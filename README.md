# UI Automation - FileUpload 

This repo contains the UI Automation for the File Upload feature in the Rescale Platform page https://platform.rescale.com/. I have signed up in the Rescale application and used that credentials. The UI Automation covers most of the happy path testing. I have given below the list of other test cases that I woul consider for testing

The UI automation is written using Java, Selenium Webdriver and TestNG using Mavan. The framework is created using the Page Object Model framework along with the combination of Page Factory design pattern. The framework has below two source classes along with its two test classes.
## Source Class: 
1. LoginPage.java -- This class contains the element locators for the login functionality using my credentials.
2. FileUpload.java -- This class contains the element locators for uploading the file in the platform Files page. 
 
## Test class:
**LoginPageTest.java**
This is the test class for LoginPage class. This class contains the below methods:
  - @BeforeSuite - This method is executed at the beginning of the test suite which primarily initializes the WebDriver instance
  - @BeforeClass - This method creates the object of the LoginPage class which is used for accessing the webelements in the login page
  - loadUrl - This test method is used to load the Rescale Platform login page
  - login - This method passes the username and password credentials and login to the home page. The username and pasosword is passed through the TestNG dataProvider which can be changed for different users. 
  - The DataProvider method passes the username and password as a 2D Object array. The login method reads the value and logs into the application. If the user of this framework wants to change the login details used, it has to be changed in this method 
  - @AfterClass - This method deallocates the memory allocated for the LoginPage object and frees the object.
  - @AfterSuite - This method is executed after the test cases in the suite is tested and this quits the webdrive instance

**FileUploadTest.java**
This class tests the FileUpload in the Rescale Platform- Files page.  
  - @BeforeClass - This testNG method creates the Webdriver object along with the FileUpload object.
  - clickFileUpload - This method clicks on the "Upload File" button and uploads the file. If the user wants to update the file name to be uploaded, the path in the 'filePath' dataProvider has to be updated. 
  - testFileUploaded - Once the file is uploaded, this method asserts that the file name that is uploaded matches with the actual file that is in the Files tab. If the file name mismatches, this test fails throwing error. 
  
  
  ## To run the test framework:
  1. Clone the repository locally
  2. Import the code in your favorite IDE as a maven project
  3. Right click on testng.xml -> Run As -> TestNG Suite
   
  ## Other testcases
  **Functional Test cases**
  1. Upload different types of file (eg., pdf, zip etc)
  2. Upload file of various size ranging from small to very huge size (upto 1GB or even more than that)
  3. Try to upload a file which does not exist and check for exception
  4. Test the file name editing after it is uploaded successfully
  5. Test the type of file uploaded like output file, script file etc. 
  6. Test various fields like owner, created date and time fields
  7. Create folder and try to upload files directly in a folder
  8. Test various actions like renaming file, move file to a folder
  9. Test Basic and Enhanced method of Transfer and check the difference in speed of file transfer.
  10. Try to upload many files concurrently and see the success rate.
  11. Test the functionality of moving files between folders. 
  12. Upload same file multiple times and chech it is allowed or not
  13. Test searching the uploaded file based on name, owner and type of file
  14. Test advanced search functionality based on date
  15. Try to upload a folder instead of file 
  
  **Browser and OS Testing**
  1. Test the UI in various browsers like Safari, Chrome, IE, Firefox, Edge etc and different combinations of versions. 
  2. Test the UI in various OS like Mac, Windows, Linux etc
  3. Test the app friendly version of the product either in Android or in iOS
  4. Test the usability of the product for various dimentions of the screen size
  
  **Other non-functional test cases**
  1. Test the time taken for the file upload and download. 
  2. Test time taken when bulk upload is done
  3. Test the security of the product
  4. Test the availility of the application 24/7 by checking the load balancer is triggered if a node or cluster in db goes down
  5. Check the secure port in which data is transmitted (port 443) and not through 8080.
  
  
