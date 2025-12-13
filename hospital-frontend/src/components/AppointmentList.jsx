import React, { useEffect, useState } from 'react';
import { getAllAppointments, deleteAppointment } from '../services/appointmentService';
import { Link } from 'react-router-dom';

export default function AppointmentList() {
  const [items, setItems] = useState([]);

  const fetch = async () => {
    try {
      const data = await getAllAppointments();
      setItems(data || []);
    } catch (e) { console.error(e); }
  };

  useEffect(() => { fetch(); }, []);

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h3>Appointments</h3>
        <Link to="/appointments/new" className="btn btn-primary">Schedule</Link>
      </div>
      <table className="table table-striped">
        <thead><tr><th>ID</th><th>Patient ID</th><th>Doctor ID</th><th>Date</th><th>Actions</th></tr></thead>
        <tbody>
          {items.map(a => (
            <tr key={a.id}><td>{a.id}</td><td>{a.patientId}</td><td>{a.doctorId}</td><td>{a.date}</td>
              <td><button className="btn btn-sm btn-danger" onClick={async ()=>{ if(window.confirm('Delete?')){ await deleteAppointment(a.id); fetch(); }}}>Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}