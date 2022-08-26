# Capstone
Automation Bootcamp 2022

Capstone Project for the Automation Testing Bootcamp 2022.   Front-end part was developed with Selenium using Java, and the Back-end part was worked in Postman using JavaScript.

# 1. Introduction

The main objective of the project is to set an automation framework that includes testing for Front End and their APIs. This was achieved by setting up the next tech stack: 
Front-End: Selenium Framework using Java. 
API: Postman, Newman.
CI/CD: Github Actions.

The objects being tested are:

- For Front-End, the Sauce Labs website: www.saucedemo.com
- For Back-End, the Pokemon API: https://pokeapi.co/

# 2. Project Structure

```{r tidy=FALSE}
|-- CAPSTONE   
|   |-- .github 
|   |   |-- workflows 
|   |   |   |-- maven.yml 
|   |   |   |-- pokemonPostman.yml 
|   |-- .idea 
|   |-- Postman 
|   |   |-- Pokemon_Challenge.postman_collection.json 
|   |   |-- Env.postman_environment.json 
|   |-- Resources 
|   |   |-- chromedriver 
|   |   |-- geckodriver 
|   |   |-- safaridriver 
|   |-- src 
|   |   |-- main 
|   |   |   |-- java 
|   |   |   |   |-- pages 
|   |   |   |   |   |-- CartPage 
|   |   |   |   |   |-- LoginPage 
|   |   |   |   |   |-- ProductsDetailsPage 
|   |   |   |   |   |-- ProductsPage 
|   |   |   |   |-- utils 
|   |   |   |   |   |-- Data 
|   |   |   |   |   |-- WindowManager 
|   |   |   |   |-- resources 
|   |   |-- test 
|   |   |   |-- java 
|   |   |   |   |-- base 
|   |   |   |   |   |-- BaseTests 
|   |   |   |   |-- login 
|   |   |   |   |   |-- LoginTests 
|   |   |   |   |-- navigation 
|   |   |   |   |   |-- NavigationTests 
|   |   |   |   |-- products 
|   |   |   |   |   |-- AddToCartTests 
|   |   |   |   |   |-- ProductDetailsTests 
|   |   |   |   |   |-- ProductsPageTests 
|   |   |   |-- testng.xml 
|   |-- target 
|   |-- .gitignore 
|   |-- pom.xml 
|-- External Libraries 
|-- Scratches and Consoles 
```

# 3. Dependencies and Plugins

Dependencies:

1. selenium-java. v.4.4.0
2. testng.  v.7.6.1
3. maven-surefire-report-plugin. v.3.0.0-M7

Plug-ins:

1. maven-surefire-plugin   v. 2.22.2
2. maven-site-plugin.  v. 3.7.1
3. maven-project-info-reports-plugin  v.3.0.0

# 4. Front-End

# 4.1 Installation

In order to perform a local installation, these are the required steps.

Pre-requisites:
1. Have Java JDK 11 installed https://www.oracle.com/java/technologies/downloads/
2. Have an IDE installed.  For instance IntelliJ: https://www.jetbrains.com/idea/download/#section=mac
3. Have a web browser installed (Chrome, Firefox, Safari).  For instance Chrome: https://www.google.com/chrome/
4. Downlad the respective webdriver for the browser used. For instance ChromeDriver: https://chromedriver.chromium.org/downloads

Setup
1. Create a folder in your local machine to download the project
2. Clone the Capstone repository in your local machine: https://github.com/LuisMontoy/Capstone.   
3. Open a terminal and navigate to the root of the project from step 1.

# 4.2 Test Execution

1. To run all of the Test Cases type the following command in the terminal: 

```{r tidy=FALSE}
mvn clean test
```

2. To run only the Test Cases for the smoke Test run the following command:

```{r tidy=FALSE}
mvn test -Dgroups=smoke
```

# 4.3 Run Reports

1. For all Test cases:  

```{r tidy=FALSE}
mvn clean test site
```

2. For the Smoke Test cases: 

```{r tidy=FALSE}
mvn clean test -Dgroups=smoke site
```

The reports can be viewed by accessing the following path in the project:  target/site/surefire-report.html

# 5. Back-End

# 5.1 Installation

In order to perform a local installation, these are the required steps.

Pre-requisites:
1. Have Postman installed.  https://www.postman.com/downloads/
2. Have node.js installed.  https://nodejs.org/en/download/
3. Have npm installed.  From the Terminal type: npm install
4. Have newman installed:  From the Terminal type: npm install -g newman

Setup
1. Create a folder in your local machine to download the project
2. Import the collection and environment files from Github in your local machine: https://github.com/LuisMontoy/Capstone/tree/master/Postman  
3. Open a terminal and navigate to the root of the project from step 1.

# 5.2 Test Case Execution

Execute the following command from the Command line:

```{r tidy=FALSE}
newman run Postman/Pokemon_Challenge.postman_collection.json -e Postman/Pokemon\ Env.postman_environment.json
```

# 5.3 Run Reports

Execute the following commands: 

```{r tidy=FALSE}
npm install -g newman-reporter-htmlextra
mkdir -p testResults
newman run Postman/Pokemon_Challenge.postman_collection.json -e Postman/Pokemon\ Env.postman_environment.json -r htmlextra --reporter-htmlextra-export testResults/htmlreport.html --reporter-htmlextra-darkTheme  > testResults/runreport1.html
```

Go to the "testResults" folder and open the Report in HTML

# 6. Tests

# 6.1 Front-End

The tests are performed in Selenium using TestNG for the assertions to determine whether or not a Test Case has passed.

# Login Tests

There are 4 Test Cases for Loging in.  One for a successfull login and 3 for unsuccesfull logins:
-public void testSuccessfulLogin()
-public void incorrectPasswordLogin()
-public void incorrectUsernameLogin()
-public void incorrectCredentials()

# Navigation Test
      
There is only one Test Case that navigates through the login, inventory and cart pages. 
- public void testNavigator()

# Product Details Test

There is only one Test Case that clicks on a product image and validates that the info on the product details page is correct.
-public void testProductInformation()

# Product Page Tests

The following Test Cases were created for the Product Page:
-public void testAddToCart()
-public void validateProductsPageInfo()
-public void sortProductsByPriceAscending()

# Cart Page Test

The following test was created to validate that the info in the cart is correct:
-public void TestGoToCart()

# 6.2 API

The following Tests are performed in the Pokemon API:

- Choose your favorite pokemon (store it in the environment file) and look out at their moves
- Pick the first move (save that info in the environment file: name, and url)
- Search all information for that move using the move’s name and validate that under “learned_by_pokemon” it shows up you favorite pokemon name
- In another request, perform the same validation as described in the previous step but this time using the move url as endpoint.
- Evaluate the HTTP Status Code accordingly.
- Add test function to validate that response time is under 700 ms
- Create a function to validate a schema (this applies to moves - move in request #1)

# 7. CI/CD

Whenever a change is made in the Github repository the following test Cases are Run automatically:
- All of the API Tests
- The Smoke Test for the Front end, which only includes the following 3 tests:
  1. public void testSuccessfulLogin()
  2. public void TestGoToCart()
  3. public void testProductInformation()

This was configured using Github Actions.

# 8. Contact

Developed by: Luis Cuauhtemoc Montoya
Email: luis.cuauhtemoc@wizeline.com





