# University Management System

> A Java Swing-based desktop application designed to manage university operations efficiently — including students, faculty, courses, and departments — with a MySQL database for persistent storage.

---

## 🏫 Overview

The **University Management System (UMS)** is a standalone desktop application that simplifies the administration of university data. It allows administrators and staff to perform CRUD operations (Create, Read, Update, Delete) on various entities like students, faculty, and courses through a user-friendly Swing-based graphical interface.

Developed using **Java (Swing)** and **MySQL**, this system ensures data consistency, easy retrieval, and scalability for institutional use.

---

## 📋 Table of Contents

1. [Key Features](#key-features)
2. [Tech Stack](#tech-stack)
3. [System Architecture](#system-architecture)
4. [Modules Overview](#modules-overview)
5. [Database Design](#database-design)
6. [Installation & Setup](#installation--setup)
7. [Project Structure](#project-structure)
8. [Usage Guide](#usage-guide)
9. [Screenshots](#screenshots)
10. [Future Enhancements](#future-enhancements)
11. [Author](#author)

---

## ✨ Key Features

* 🧑‍🎓 **Student Management** — Add, view, update, and delete student records.
* 👩‍🏫 **Faculty Management** — Manage faculty profiles and teaching assignments.
* 📚 **Course Management** — Create and assign courses to departments and faculty.
* 🏢 **Department Management** — Maintain department-wise data and staff.
* 🔍 **Search & Filter** — Find records quickly using ID, name, or department filters.
* 💾 **Database Integration** — Real-time data storage using MySQL.
* 🪶 **User-Friendly UI** — Intuitive Java Swing interface with menu-driven navigation.
* 🔐 **Authentication (Optional)** — Simple login window for system admin access.

---

## 🛠️ Tech Stack

| Layer             | Technology            |
| ----------------- | --------------------- |
| **Frontend (UI)** | Java Swing            |
| **Backend Logic** | Core Java (OOP, JDBC) |
| **Database**      | MySQL                 |
| **IDE**           | IntelliJ IDEA         |
| **Build Tool**    | Maven (optional)      |

---

## 🧩 System Architecture

```
┌───────────────────────────────┐
│        User Interface         │  ← (Java Swing Forms)
└──────────────┬────────────────┘
               │
┌──────────────┴────────────────┐
│         Business Logic         │  ← (Java classes handling operations)
└──────────────┬────────────────┘
               │
┌──────────────┴────────────────┐
│         Database Layer         │  ← (MySQL with JDBC connectivity)
└───────────────────────────────┘
```

---

## 🧮 Modules Overview

| Module                | Description                                           |
| --------------------- | ----------------------------------------------------- |
| **Login Module**      | Authenticates admin before access (optional feature). |
| **Student Module**    | Add, update, view, delete student details.            |
| **Faculty Module**    | Manage faculty info, subjects taught, contact, etc.   |
| **Course Module**     | Manage courses and assign to departments/faculty.     |
| **Department Module** | Store department details and their heads.             |

---

## 🗃️ Database Design

**Database:** `university_db`

Example tables and fields:

### `student`

| Field           | Type         | Description               |
| --------------- | ------------ | ------------------------- |
| `student_id`    | INT (PK)     | Unique student identifier |
| `name`          | VARCHAR(100) | Full name                 |
| `dob`           | DATE         | Date of birth             |
| `gender`        | VARCHAR(10)  | Gender                    |
| `department_id` | INT (FK)     | Department reference      |

### `faculty`

| Field           | Type         | Description               |
| --------------- | ------------ | ------------------------- |
| `faculty_id`    | INT (PK)     | Unique faculty identifier |
| `name`          | VARCHAR(100) | Faculty name              |
| `subject`       | VARCHAR(100) | Subject taught            |
| `department_id` | INT (FK)     | Department reference      |

### `course`

| Field           | Type         | Description              |
| --------------- | ------------ | ------------------------ |
| `course_id`     | INT (PK)     | Unique course identifier |
| `course_name`   | VARCHAR(100) | Course title             |
| `credits`       | INT          | Credit value             |
| `department_id` | INT (FK)     | Department reference     |

---

## ⚙️ Installation & Setup

### Prerequisites

* Java JDK 11 or above
* MySQL Server installed and running
* IntelliJ IDEA (or any Java IDE)

### Steps

1. **Clone the Repository**

   ```bash
   git clone https://github.com/your-username/university-management-system.git
   ```

2. **Open in IntelliJ IDEA**

   * Go to *File → Open* and select the cloned folder.

3. **Create MySQL Database**

   ```sql
   CREATE DATABASE university_db;
   USE university_db;
   ```

4. **Import SQL Schema (if provided)**

   ```bash
   source database/university_schema.sql;
   ```

5. **Configure Database Connection in Code**
   Update your JDBC URL, username, and password in the Java class where connection is made (usually `DBConnection.java`):

   ```java
   String url = "jdbc:mysql://localhost:3306/university_db";
   String user = "root";
   String password = "your_password";
   ```

6. **Run the Project**

   * Run `Main.java` file to start the application.

---

## 🗂️ Project Structure

```
UniversityManagementSystem/
├── src/
│   ├── university/
│   │   ├── db/DBConnection.java
│   │   ├── model/Student.java, Faculty.java, Course.java, Department.java
│   │   ├── dao/StudentDAO.java, FacultyDAO.java, CourseDAO.java
│   │   ├── ui/ (Swing Forms)
│   │   └── Main.java
├── database/university_schema.sql
├── README.md
└── pom.xml (if using Maven)
```

---

## 🧭 Usage Guide

1. Launch the application.
2. Login as admin (if login module is enabled).
3. Use the menu options or tabs to manage Students, Faculty, Courses, and Departments.
4. Use search fields to quickly find records.
5. All operations are reflected in the MySQL database instantly.

---

## 🖼️ Screenshots
<img width="433" height="182" alt="image" src="https://github.com/user-attachments/assets/9c4a9b74-a680-4344-8286-5406c1be0538" />
<img width="951" height="476" alt="image" src="https://github.com/user-attachments/assets/34e27578-3a2d-4d6c-bbc8-39e981dbc9b5" />

---

## 🚀 Future Enhancements

* Add **Role-Based Authentication (Admin/Faculty/Student)**
* Generate **Reports and Analytics** (attendance, grades, etc.)
* Integrate with **Spring Boot REST API** for web version
* Include **Email Notification** system
* Add **Export to Excel/PDF** for student data

---

## 📝 License & Author

This project is released under the MIT License. See [LICENSE](LICENSE) for details.

**Author:** 
Abhay
B.Tech CSE, CGC Landran
📧 [abheykumar7860@gmail.com](mailto:your-email@example.com) | 🔗 [[LinkedIn](https://www.linkedin.com/in/abheykumar07/)]

---

