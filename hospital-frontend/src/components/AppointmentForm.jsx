import React, { useState } from 'react';
import { createAppointment } from '../services/appointmentService';
import { useNavigate } from 'react-router-dom';

export default function AppointmentForm() {
  const [form, setForm] = useState({ patientId: '', doctorId: '', date: '' });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createAppointment({ ...form, patientId: Number(form.patientId), doctorId: Number(form.doctorId) });
    navigate('/appointments');
  };

  return (
    <div>
      <h3>Schedule Appointment</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Patient ID</label>
          <input className="form-control" value={form.patientId} onChange={e=>setForm({...form, patientId: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Doctor ID</label>
          <input className="form-control" value={form.doctorId} onChange={e=>setForm({...form, doctorId: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Date</label>
          <input type="date" className="form-control" value={form.date} onChange={e=>setForm({...form, date: e.target.value})} required />
        </div>
        <button className="btn btn-primary" type="submit">Save</button>
      </form>
    </div>
  );
}