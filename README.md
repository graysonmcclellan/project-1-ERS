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
* Can login from the Login Page using their username and password and get redirected to Employee Main Menu
* Can view a personalized Employee Main Menu displaying an interactive nav bar with the following options:
  * Apply for a New Reimbursement
    > - When clicked redirects employee to new reimbursement application where they can submit a reimbursement request, which creates a pending reimbursment that must be approved by an admin.
  * View My Reimbursments
  * View My Pending Reimbursements
  * View My Resolved Reimbursements
  * View My Profile Info
  * Logout
* Can
