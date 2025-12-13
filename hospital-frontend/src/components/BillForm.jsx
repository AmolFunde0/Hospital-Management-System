import React, { useState } from 'react';
import { createBill } from '../services/billService';
import { useNavigate } from 'react-router-dom';

export default function BillForm() {
  const [form, setForm] = useState({ patientId: '', amount: '', status: '' });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    await createBill({ ...form, patientId: Number(form.patientId), amount: Number(form.amount) });
    navigate('/bills');
  };

  return (
    <div>
      <h3>Create Bill</h3>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Patient ID</label>
          <input className="form-control" value={form.patientId} onChange={e=>setForm({...form, patientId: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Amount</label>
          <input type="number" step="0.01" className="form-control" value={form.amount} onChange={e=>setForm({...form, amount: e.target.value})} required />
        </div>
        <div className="mb-3">
          <label className="form-label">Status</label>
          <input className="form-control" value={form.status} onChange={e=>setForm({...form, status: e.target.value})} required />
        </div>
        <button className="btn btn-primary" type="submit">Save</button>
      </form>
    </div>
  );
}