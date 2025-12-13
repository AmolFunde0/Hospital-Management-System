import React, { useState } from 'react';
import { createPatient } from '../services/patientService';
import { useNavigate } from 'react-router-dom';

export default function PatientForm() {
  const [form, setForm] = useState({ name: '', gender: '', age: '' });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createPatient({ ...form, age: Number(form.age) });
    navigate('/patients');
  };

  return (
    <div>
      <h3>Add Patient</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input className="form-control" value={form.name} onChange={e => setForm({...form, name: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Gender</label>
          <input className="form-control" value={form.gender} onChange={e => setForm({...form, gender: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Age</label>
          <input type="number" className="form-control" value={form.age} onChange={e => setForm({...form, age: e.target.value})} required />
        </div>
        <button className="btn btn-primary" type="submit">Save</button>
      </form>
    </div>
  );
}