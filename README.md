# Ziraat Bank ATM Simulation Project

## Overview

This project is a simulation of an ATM application designed to replicate the functionalities of a Ziraat Bank ATM. The application provides a user-friendly interface that allows users to perform various banking operations such as account registration, logging in, balance inquiries, deposits, withdrawals, payments, and money transfers. The application is structured into three main sections: registration, login, and main operations. Additionally, it includes transition pages that enable seamless navigation between different functionalities.

## Features

### Registration Page

- **Sign-Up Functionality:** Users can create an account by providing their personal information. This information is validated before a new account is created in the system.
- **Account Validation:** Ensures that account details are correct and meet the required criteria before registration is completed.

![signup_1](https://github.com/user-attachments/assets/d96f33ba-2bac-4da8-99cf-808bd398179d)
![signup2](https://github.com/user-attachments/assets/6276c646-5615-4799-8de0-a82a17e17243)
![signup3](https://github.com/user-attachments/assets/cb0ab856-b792-4e05-b0c4-6961c6b2e0ca)


### Login Page

- **User Authentication:** Allows users to log into their accounts by entering their credentials. The system verifies the username and password against the stored data.
- **Security Measures:** Implements security features to prevent unauthorized access, such as account lockout after several failed login attempts.


  ![1](https://github.com/user-attachments/assets/4477884e-c513-439b-9e99-342864614f63)

### Main Page (Dashboard)
![2](https://github.com/user-attachments/assets/49240027-cf21-4575-b397-aa05621ae3f5)

- **Password Management:** Users can securely change their passwords within the application, ensuring their accounts remain protected.
  ![pass1](https://github.com/user-attachments/assets/fc9e9d0b-d1f2-48d5-86fa-b704af8161f4)
  ![pass2](https://github.com/user-attachments/assets/b4fac31c-3205-4cc8-8714-35ffbf5c26c0)
- **Balance Inquiry:** Displays the current account balance, allowing users to track their funds.
  ![bakiye_bilgi](https://github.com/user-attachments/assets/aec0ebfe-4430-4d1d-89df-730fa344eee7)

- **Deposit Functionality:** Users can deposit money into their accounts. The application updates the balance accordingly and confirms the transaction.
  ![para_yatirma](https://github.com/user-attachments/assets/d3abec40-e105-434a-9cb6-19218991ad91)

- **Withdrawal Functionality:** Allows users to withdraw funds from their account, with checks to ensure they do not exceed their available balance.
  ![para çekme](https://github.com/user-attachments/assets/0e5be14b-3b69-4953-af8e-0d259c8ee18e)

- **Payment Services:** Enables users to make payments directly from their accounts, including utility bills, credit card payments, and other common transactions.
  ![payment](https://github.com/user-attachments/assets/9816b1e9-7b43-4ced-b56b-b1d0355bb014)
- **Money Transfer:** Provides the ability to transfer money to other accounts, either within the same bank or to external banks, with necessary validation checks.

- **Transaction History:** Users can view a history of all transactions conducted through their accounts, providing transparency and easy record-keeping.
- Transfer page out of service:
  ![hizmet_disi](https://github.com/user-attachments/assets/54a81945-6a94-4006-82a0-16f2cfa7bd83)

### Transition Pages

These pages facilitate smooth navigation between the primary functions of the application. They include prompts, confirmations, and error messages to guide users effectively through the ATM's functionalities.

## Database Structure

The following database structure is used for the application to run:

### Tablo Yapısı

- **Bank Tables (`bank`)**:
    - `cardpas` (VARCHAR(10)): Kart şifresi.
    - `date` (VARCHAR(50)): İşlem tarihi.
    - `type` (VARCHAR(20)): İşlem türü (örneğin: Para Yatırma, Para Çekme).
    - `amount` (VARCHAR(20)): İşlem miktarı.

- **Input Tables (`login`)**:
    - `form_no` (VARCHAR(30)): Kullanıcının form numarası.
    - `card_no` (VARCHAR(16)): Kullanıcının kart numarası.
    - `card_password` (VARCHAR(4)): Kullanıcının kart şifresi.

- **Record Tables (`signup`)**:
    - `form_no` (VARCHAR(30)): Form numarası.
    - `tc_no` (VARCHAR(11)): Kullanıcının TC kimlik numarası.
    - `name` (VARCHAR(30)): Kullanıcının adı.
    - `surname` (VARCHAR(30)): Kullanıcının soyadı.
    - `DOB` (VARCHAR(20)): Kullanıcının doğum tarihi.
    - `card_no` (VARCHAR(16)): Kart numarası.
    - `card_password` (VARCHAR(4)): Kart şifresi.

- **Account Type Tables (`signupthree`)**:
    - `form_no` (VARCHAR(30)): Form numarası.
    - `account_type` (VARCHAR(30)): Hesap türü.
    - `account_no` (VARCHAR(30)): Hesap numarası.
    - `iban` (VARCHAR(30)): IBAN numarası.

- **Address Tables (`signuptwo`)**:
    - `form_no` (VARCHAR(30)): Form numarası.
    - `city` (VARCHAR(30)): Şehir.
    - `district` (VARCHAR(30)): İlçe.
    - `street` (VARCHAR(30)): Sokak.
    - `address` (VARCHAR(100)): Adres.

### Veri Tabanı Kurulumu

Before running the application, you need to create the database using the following SQL queries:

```sql
CREATE DATABASE atm_simulasyon;

USE atm_simulasyon;

CREATE TABLE bank (
    cardpas VARCHAR(10),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);

CREATE TABLE login (
    form_no VARCHAR(30),
    card_no VARCHAR(16),
    card_password VARCHAR(4)
);

CREATE TABLE signup (
    form_no VARCHAR(30),
    tc_no VARCHAR(11),
    name VARCHAR(30),
    surname VARCHAR(30),
    DOB VARCHAR(20),
    card_no VARCHAR(16),
    card_password VARCHAR(4)
);

CREATE TABLE signupthree (
    form_no VARCHAR(30),
    account_type VARCHAR(30),
    account_no VARCHAR(30),
    iban VARCHAR(30)
);

CREATE TABLE signuptwo (
    form_no VARCHAR(30),
    city VARCHAR(30),
    district VARCHAR(30),
    street VARCHAR(30),
    address VARCHAR(100)
);
```

## Database Connection

- **JDBC:** Java Database Connectivity (JDBC) is used to establish a connection between Java and the database. This allows for storing and accessing user data and transaction details within the database.

- **Connection Configuration:** Ensure that the JDBC connection details (`url`, `username`, `password`) are correctly configured in the application code.

## Technologies Used

- **Java:** The core programming language used for developing the application.
- **Swing:** Java's GUI toolkit used for building the graphical user interface.
- **JDBC:** For connecting to and interacting with the database storing user information and transaction details.