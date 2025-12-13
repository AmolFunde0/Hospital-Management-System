import React, { useState } from 'react';
import { createDoctor } from '../services/doctorService';
import { useNavigate } from 'react-router-dom';

export default function DoctorForm() {
  const [form, setForm] = useState({ name: '', speciality: '', age: '' });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createDoctor({ ...form, age: Number(form.age) });
    navigate('/doctors');
  };

  return (
    <div>
      <h3>Add Doctor</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Name</label>
          <input className="form-control" value={form.name} onChange={e => setForm({...form, name: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Speciality</label>
          <input className="form-control" value={form.speciality} onChange={e => setForm({...form, speciality: e.target.value})} required />
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