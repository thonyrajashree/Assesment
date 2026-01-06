# Flipkart Product Search Automation – Selenium Java

## 📌 Project Overview
This project automates a basic e-commerce workflow on Flipkart using Selenium WebDriver with Java.  
The objective is to demonstrate handling of dynamic elements, browser navigation, waits, and screenshot capture as part of a skill assessment.

---

## 🎯 Automated Scenario
The automation performs the following steps:

1. Launch Flipkart homepage
2. Close login popup if it appears
3. Search for a product (Laptop)
4. Click on the first product from search results
5. Switch to the newly opened product tab
6. Validate Product Details Page by checking the presence of the **Add to Cart** button
7. Capture a screenshot of the Product Details Page

---

## 🛠 Tech Stack
- **Language:** Java
- **Automation Tool:** Selenium WebDriver
- **Browser:** Google Chrome
- **Wait Strategy:** Explicit Wait (WebDriverWait)
- **Build Tool:** Maven

---


## ▶️ How to Run the Test

### Prerequisites
- Java JDK installed
- Maven installed
- Google Chrome browser
- ChromeDriver compatible with Chrome version

### Steps
1. Open the project in Eclipse or IntelliJ
2. Ensure ChromeDriver is set in system PATH
3. Run the test by executing:
   ```java
   public static void main(String[] args)

