import React from 'react'
import { Routes, Route, Link } from 'react-router-dom'
import Dashboard from './pages/Dashboard'
import PatientList from './components/PatientList'
import PatientForm from './components/PatientForm'
import DoctorList from './components/DoctorList'
import DoctorForm from './components/DoctorForm'
import AppointmentList from './components/AppointmentList'
import AppointmentForm from './components/AppointmentForm'
import BillList from './components/BillList'
import BillForm from './components/BillForm'

export default function App() {
  return (
    <div className="container my-4">
      <nav className="navbar navbar-expand-lg navbar-light bg-light mb-4 rounded">
        <div className="container-fluid">
          <Link className="navbar-brand" to="/">Hospital</Link>
          <div className="collapse navbar-collapse">
            <ul className="navbar-nav me-auto mb-2 mb-lg-0">
              <li className="nav-item"><Link className="nav-link" to="/patients">Patients</Link></li>
              <li className="nav-item"><Link className="nav-link" to="/doctors">Doctors</Link></li>
              <li className="nav-item"><Link className="nav-link" to="/appointments">Appointments</Link></li>
              <li className="nav-item"><Link className="nav-link" to="/bills">Bills</Link></li>
            </ul>
          </div>
        </div>
      </nav>

      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/patients" element={<PatientList />} />
        <Route path="/patients/new" element={<PatientForm />} />
        <Route path="/doctors" element={<DoctorList />} />
        <Route path="/doctors/new" element={<DoctorForm />} />
        <Route path="/appointments" element={<AppointmentList />} />
        <Route path="/appointments/new" element={<AppointmentForm />} />
        <Route path="/bills" element={<BillList />} />
        <Route path="/bills/new" element={<BillForm />} />
      </Routes>
    </div>
  )
}