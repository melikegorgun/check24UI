# About

These task includes UI Tests on "https://finanzen.check24.de/accounts/d/kreditkarte/result.html" webpage

These tests :

-Verifies that if you are in the right page
-Verifies that if "ppset=kreditkarte" cookie is set in response
-Verifies that if the error messages are expected messages, against to related fields on "Personal Info" tab.(Persönliche Angaben)
-Verifies that page has navigated to "Other Personal Info" tab if all field filled with the correct values.(Weitere persönliche Angaben)


# Installation
To run this project, Java 10 and Maven must be installed.
No need to download driver's exes because they are inside the project.
But you need to download Chrome Version 101.0 and Firefox 97.0 browsers on your computer.

# How to use
To run tests, `mvn clean install` command should be run.
This command will run TestNG with Testng.xml config.
Or directly right click on Testng.xml file and Run via TestNG.
No need to configure anything with TestNG.xml file.
But if you want to change test data you can do it into Testng.xml via below data parameters:
```
     <parameter name="email" value="m@gmail.com"/>
        <parameter name="name" value="Mel"/>
        <parameter name="surName" value="Gor"/>
        <parameter name="birthDate" value="01.01.1990"/>
        <parameter name="number" value="+49 171 1234567"/>
```

browser and driverPath are for to use different browsers when running test.
Now 2 browser is supported: Chrome and Firefox.
However, New browser support can be easily implemented by changing this config file and adding small code into `DriverInitializer.java` class

# Known Issues
PersonalInfoPage.goAsGuest method is not working on Chrome browser.It explained under the method.