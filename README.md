# Revature Project 1 - Employee Reimbursement System

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.

## Technologies Used
* Apache Tomcat Version 9.0
* J-Unit Version 4.12
* Log4J Version 1.2.17
* PostgreSQL Version 4.2.9
* Jackson 2.10.1
* Javax Servlet API Version 4.0.1
* DBeaver Version 7.2.1
* Spring Tool Suite 4 Version 4.8.1.RELEASE

## Features
### All Users:
* Can view the HomePage with the options to create a new user or login
* View User Registration Page where user can create an account by filling out the provided fields
* Can View the Login Page and attempt to login using a username and password

### Employees:
* Can login from the Login Page using their username and password and get redirected to the Employee Main Menu
* Can view a personalized Employee Main Menu displaying an interactive nav bar with the following options:
  * Apply for a New Reimbursement
    > - When clicked redirects employee to new reimbursement application where they can submit a reimbursement request, which creates a pending reimbursment that must be approved by an admin.
  * View My Reimbursments
    > - When clicked redirects employee to a "My Reimbursements" page that renders a list all of their submitted reimbursements in JSON format (regardless if they are PENDING, APPROVED, or DENIED)
  * View My Pending Reimbursements
    > - When clicked redirects employee to a "My Pending Reimbursements" page that renders a list all of their PENDING reimbursements in JSON format. 
  * View My Resolved Reimbursements
    > - When clicked redirects employee to a "My Resolved Reimbursements" page that renders a list all of their APPROVED and DENIED reimbursements in JSON format. If Employee doesn't have any approved or denied reimbursements a relative message will be displayed on the page.  
  * View My Profile Info
    > - When clicked an employee can view their personal information, such as username, password, first name and last name.
  * Logout
    > - When clicked an employee can logout and is redirected to the home page, thus terminating the current session.
    
### Admins:
* Can login from the Login Page using their username and password and get redirected to the Admin Main Menu
* Can view a personalized Admin Main Menu displaying an interactive nav bar with the following options:
  * View All Pending Reimbursments
    > - When clicked redirects admin to a "Viewing All Pending Reimbursements" page that renderes a list of all of the existing pending reimbursement in Json format
  * Approve a Reimbursement
    > - When clicked redirects admin to a "Reimbursement Approval Portal" where an admin can enter the ID of the designated reimbursement and approve it. An entry of an invalid Reimbursement ID will result in a redirect to an "Unsuccessful Approval" page specifying the reason why it was unsuccessful and give the admin the option to either try agin or return to main menu. Similarly, successful approvals are redirected to a "Successfully Approved" page with an option to return to main menu.
  * Deny a Reimbursement
    > - When clicked redirects admin to a "Reimbursement Denial Portal" where an admin can enter the ID of the designated reimbursement and deny it. An entry of an invalid Reimbursement ID will result in a redirect to an "Unsuccessful Denial" page specifying the reason why it was unsuccessful and give the admin the option to either try agin or return to main menu. Similarly, successful denials are redirected to a "Successfully Denied" page with an option to return to main menu.
   * View All Resolved Reimbursements
     > - When clicked redirects admin to a "Viewing All Resolved Reimbursements" page that renders a list all employees' APPROVED and DENIED reimbursements in JSON format. 
   * View All Employees
     > - When clicked redirects an admin to a "Viewing All Employees" page that renders a list of all employees with their personal information in JSON format.
   * View Specific Employee's Reimbursements
     > - When clicked redirects admin to a "Search for Employee's Reimbursements" page where the admin can enter the Employee ID and is redirected, on submit, to a page rendering a list of all PEDNING, APPROVED, and DENIED reimbursements. If the employee being searched does not have any reimbursements a message is rendered to the admin to notify them. Also if an invalid Employee ID is entered the admin is redirected to a "Cannot Find That Employee" page and given the option to "Try Again" or "Return to Main Menu".
   * Logout
     > - When clicked an admin can logout and is redirected to the home page, thus terminating the current session.


## Getting Started
Open a terminal at your designated file and clone project from github repository using command: 
git clone https://github.com/graysonmcclellan/project-1-ERS.git

## Usage
Once you have the file on your local computer, open a new workspace in Spring Tool Suite 4 and import the file.

Next, you will need to set up a server to run the application on. For this project you will need to download and use Apache Tomcat 9. 

Once you've downloaded Tomcat, go to File > New > Other > Server (Select the Server Type) > Apache > Tomcat V9.0 Server > Finish

Now, you can right click on the imported project and Run As > Run on Server (Select the Server you just initlialized) > Run.

    

