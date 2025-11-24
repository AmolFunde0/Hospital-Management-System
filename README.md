🏥 Hospital-Management-System

A complete RESTful backend API for managing hospital operations such as patients, doctors, and appointments.

📌 Table of Contents

🚀 Project Overview

⭐ Features

🛠️ Getting Started

🔗 API Endpoints

📤 Request / Response Examples

🗂️ Database Schema

🤝 Contributing

📄 License

🚀 Project Overview

The Hospital-Management-System is a PHP + MySQL-based backend service designed to streamline hospital operations like managing patients, doctors, and appointments.
This API supports full CRUD operations and follows clean RESTful design principles.

⭐ Features

👨‍⚕️ Doctor Management

🧍 Patient Management

📅 Appointment Scheduling

💊 Medical History & Billing (if implemented)

🔐 Authentication (if enabled)

⚡ Fast & lightweight backend

🛠️ Getting Started
✔ Prerequisites

PHP

MySQL

Apache / Nginx

Postman / Thunder Client

📥 Installation
git clone https://github.com/AmolFunde0/Hospital-Management-System
cd hospital-management-system

⚙ Configuration

Update database credentials in config.php.

▶ Run the Backend

Start Apache/XAMPP or any local server and use Postman to test your API.

🔗 API Endpoints
🔐 Authentication Endpoints

| Method   | Endpoint             | Description       |
| -------- | -------------------- | ----------------- |
| **POST** | `/api/auth/register` | Register new user |
| **POST** | `/api/auth/login`    | Login user        |



🧍 Patient API

| Method     | Endpoint             | Description          |
| ---------- | -------------------- | -------------------- |
| **POST**   | `/api/patients`      | ➕ Add Patient        |
| **GET**    | `/api/patients`      | 📄 Get All Patients  |
| **GET**    | `/api/patients/{id}` | 🔍 Get Patient By ID |
| **PUT**    | `/api/patients/{id}` | ✏ Update Patient     |
| **DELETE** | `/api/patients/{id}` | ❌ Delete Patient     |



👨‍⚕️ Doctor API
| Method     | Endpoint            | Description         |
| ---------- | ------------------- | ------------------- |
| **POST**   | `/api/doctors`      | ➕ Add Doctor        |
| **GET**    | `/api/doctors`      | 📄 Get All Doctors  |
| **GET**    | `/api/doctors/{id}` | 🔍 Get Doctor By ID |
| **PUT**    | `/api/doctors/{id}` | ✏ Update Doctor     |
| **DELETE** | `/api/doctors/{id}` | ❌ Delete Doctor     |



📅 Appointments API
| Method     | Endpoint                 | Description              |
| ---------- | ------------------------ | ------------------------ |
| **POST**   | `/api/appointments`      | 🗓️ Create Appointment   |
| **GET**    | `/api/appointments`      | 📄 Get All Appointments  |
| **GET**    | `/api/appointments/{id}` | 🔍 Get Appointment By ID |
| **PUT**    | `/api/appointments/{id}` | ✏ Modify Appointment     |
| **DELETE** | `/api/appointments/{id}` | ❌ Cancel Appointment     |


📤 Sample Request / Response
➕ Create Patient

Request

{
  "name": "John Doe",
  "age": 30,
  "gender": "Male",
  "contactNumber": "9876543210",
  "address": "Pune, India"
}


Response

{
  "id": 1,
  "name": "John Doe",
  "status": "Patient added successfully"
}

🗓️ Create Appointment

Request

{
  "patientId": 1,
  "doctorId": 2,
  "appointmentDate": "2025-12-01 14:00:00",
  "reason": "Routine Checkup"
}


Response

{
  "appointmentId": 10,
  "status": "Appointment Scheduled"
}

🗂 Database Schema Overview
🧍 Patients Table
id  
name  
age  
gender  
contactNumber  
address  
createdAt


👨‍⚕️ Doctors Table
id  
name  
age  
qualifications  
department  
contactNumber  
createdAt


📅 Appointments Table
id  
patientId  
doctorId  
appointmentDate  
reason  
status  
createdAt


(Optional) Billing Table
id  
patientId  
totalAmount  
createdAt


(Optional) Medical History Table
id  
patientId  
allergies  
illnesses  
medications

