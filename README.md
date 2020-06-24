## Intelligence Bank test automation project
This project is a testing practice project using Selenium, Java, TestNG and Maven
#####Project name: intelligenceBankTesting
#####Test target: 'Contact Us' page


###Notes
* Define the pages using Page Object Module
* Mainly tested 'Contact Us' form filling as required (no submitting)
* Include both positive and negative testing scenarios
* Using Data Driven Test for different scenarios -- test data: ```/src/test/java/testData/ContactUsFormTestData.java```
* Screenshot is taken for each test (target area) -- location:
```/screenshot```

### Steps to run tests
```
git clone git@github.com:yukifeng35/intelligenceBankTesting.git
```
execute the following file test file from IDE 
```
intelligenceBankTesting/src/test/java/testCase/ContactUsFormTest.java
```
or run by maven command.
```
~/intelligenceBankTesting(master)$ mvn test
```