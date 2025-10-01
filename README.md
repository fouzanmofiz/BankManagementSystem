# Bank Management System: Project Overview

This document provides a high-level overview of the Bank Management System project, its purpose, and the overall project structure. It is intended for engineers contributing to or maintaining the system.

## 1. Introduction

The Bank Management System is a Java-based application designed to simulate core banking operations. It provides a user-friendly interface for customers to perform essential banking tasks such as deposits, withdrawals, balance inquiries, and PIN changes. The system leverages a MySQL database for persistent storage of user and transaction data.

## 2. Purpose

The primary goal of this project is to develop a functional and intuitive banking application that demonstrates common ATM functionalities. It serves as a learning platform for understanding GUI development with Swing, database interaction using JDBC, and fundamental software engineering principles.


### 3.1. Core Components

*   *login.java*: Handles user authentication. It presents a login screen where users can enter their card number and PIN. Successful authentication redirects the user to the Transaction screen.
*   *signupOne.java, signupTwo.java, signupThree.java*: These classes manage the user registration process. They guide new users through multiple forms to collect personal, additional, and account details.
    *   signupOne: Collects basic personal information.
    *   signupTwo: Gathers additional details like religion, education, and occupation.
    *   signupThree: Allows users to select account types, generates card and PIN numbers, and specifies required services.
*   *Transaction.java*: Serves as the main menu after successful login. It displays a list of available banking operations (Deposit, Withdraw, Fast Cash, etc.) and navigates to the respective screens.
*   *Deposit.java*: Implements the deposit functionality, allowing users to enter an amount to be credited to their account.
*   *Withdraw.java*: Implements the withdrawal functionality, allowing users to enter an amount to be debited from their account.
*   *FastCash.java*: Provides pre-defined withdrawal amounts for quick transactions.
*   *BalanceEnquiry.java*: Displays the current account balance.
*   *PinChange.java*: Enables users to change their ATM PIN.
*   *MiniStatement.java*: Generates and displays a mini-statement of recent transactions.
*   *connectorDb.java*: Manages the database connection and provides a Statement object for executing SQL queries. This is a crucial integration point for all data persistence operations.

### 3.2. META-INF/MANIFEST.MF

This file specifies the application's entry point. The Main-Class attribute points to bank_Management_System.login, indicating that the application starts with the login screen.

### 3.3. bankmanagement system.iml

This IntelliJ IDEA module file defines the project's structure, including source directories and library dependencies. It highlights the use of jcalendar-tz-1.3.3-4 and mysql-connector-java-8.0.28.

## 4. Database Schema (Conceptual)

The system interacts with a MySQL database. While a full schema definition is not provided in the repository, the code implies the existence of the following tables:

*   *signup*: Stores personal details collected during the initial signup phase.
*   *signupTwo*: Stores additional details collected in the second signup phase.
*   *signupThree*: Stores account type, generated card number, PIN, and selected services.
*   *login*: Stores card number and PIN for authentication. This table is crucial for linking users to their accounts.
*   *bank*: Records all financial transactions (deposit, withdraw) with associated dates, transaction types, and amounts.

### 4.1. Database Interaction (connectorDb.java)

The connectorDb class establishes a connection to the MySQL database using the following credentials:

*Best Practice*: For production environments, sensitive credentials like database passwords should be managed securely (e.g., using environment variables or a secrets management system) rather than being hardcoded.

## 5. Workflow and Integration Points

The system follows a typical user flow:

1.  *Launch*: The application starts with the login.java screen.
2.  *Authentication*:
    *   Existing users enter their card number and PIN.
    *   New users can navigate to the signup process via the "SIGN UP" button.
3.  *Signup Process*:
    *   signupOne -> signupTwo -> signupThree.
    *   signupThree generates a card number and PIN, storing them in signupThree and login tables. It then typically redirects to a deposit screen or the main transaction menu.
4.  *Transaction Menu (Transaction.java)*: After successful login or signup completion, the user is presented with a menu of banking operations.
5.  *Operation Execution*: Selecting an option navigates to the corresponding class (e.g., Deposit.java, Withdraw.java).
6.  *Data Persistence*: All financial transactions (deposits, withdrawals) are recorded in the bank table via connectorDb.java. PIN changes are updated across bank, login, and signupThree tables.

### 5.1. Mermaid Diagram: Core User Flow

mermaid
flowchart LR
    A[Application Start] --> B{Login Screen};
    B -- Enter Credentials --> C{Authenticate User};
    C -- Valid Credentials --> D[Transaction Menu];
    C -- Invalid Credentials --> B;
    B -- Click Signup --> E[Signup Page 1];
    E --> F[Signup Page 2];
    F --> G[Signup Page 3];
    G -- Submit Details --> H{Generate Card & PIN};
    H --> I[Store Credentials];
    I --> D;
    D -- Select Transaction --> J{Perform Operation};
    J -- Deposit --> K[Deposit Screen];
    J -- Withdraw --> L[Withdraw Screen];
    J -- Balance Enquiry --> M[Balance Enquiry Screen];
    J -- Pin Change --> N[Pin Change Screen];
    J -- Fast Cash --> O[Fast Cash Screen];
    J -- Mini Statement --> P[Mini Statement Screen];
    J -- Exit --> Q[Exit Application];
    K --> D;
    L --> D;
    M --> D;
    N --> D;
    O --> D;
    P --> D;
    
    classDef screen fill:#2A4365,stroke:#4A5568,stroke-width:2px,color:#E2E8F0
    classDef process fill:#1A202C,stroke:#2D3748,stroke-width:2px,color:#E2E8F0
    classDef decision fill:#374151,stroke:#4A5568,stroke-width:2px,color:#E2E8F0
    
    class A,Q process
    class B,D,E,F,G,K,L,M,N,O,P screen
    class C,J decision
    class H,I process


## 6. Dependencies

*   *Java Development Kit (JDK)*: Version 8 or higher is recommended.
*   *MySQL Database*: A running MySQL server is required.
*   *MySQL Connector/J*: The JDBC driver for MySQL (mysql-connector-java-8.0.28).
*   *JCalendar*: Used for date selection in signup forms (jcalendar-tz-1.3.3-4).

## 7. Best Practices and Usage Patterns

*   *Modular Design*: Each class is responsible for a specific UI component or functionality, promoting maintainability.
*   *Event-Driven Programming*: Swing components utilize ActionListener to handle user interactions.
*   *Database Abstraction*: connectorDb.java centralizes database connection logic, making it easier to manage and modify database access.
*   *Error Handling*: Basic try-catch blocks are used for database operations and input validation.

## 8. Common Pitfalls and Gotchas

*   *Hardcoded Database Credentials*: As mentioned, passwords and usernames in connectorDb.java should be externalized for security.
*   *SQL Injection Vulnerabilities*: The current implementation directly concatenates user input into SQL queries. This is a significant security risk and should be addressed by using PreparedStatement with parameterized queries.
*   *Lack of Comprehensive Input Validation*: While some basic checks are present (e.g., for empty fields), more robust validation (e.g., for numeric formats, character limits) is recommended.
*   *Uncaught Exceptions*: Some exception handling is rudimentary (e.g., throw new RuntimeException(e)). More specific exception handling and logging would improve robustness.
*   *GUI Threading*: For more complex applications, long-running operations (like database queries) should be performed on background threads to avoid freezing the Event Dispatch Thread (EDT) and making the UI unresponsive.

This overview provides a foundational understanding of the Bank Management System. Further details on specific components can be found in their respective source files.

### Tech Stack used

* Java, JavaSwing, MySQL, OOPs, JDBC
