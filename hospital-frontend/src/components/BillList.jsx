import React, { useEffect, useState } from 'react';
import { getAllBills, deleteBill } from '../services/billService';
import { Link } from 'react-router-dom';

export default function BillList() {
  const [bills, setBills] = useState([]);

  const fetch = async () => {
    try {
      const data = await getAllBills();
      setBills(data || []);
    } catch (e) { console.error(e); }
  };

  useEffect(() => { fetch(); }, []);

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h3>Bills</h3>
        <Link to="/bills/new" className="btn btn-primary">Add Bill</Link>
      </div>
      <table className="table table-striped">
        <thead><tr><th>ID</th><th>Patient ID</th><th>Amount</th><th>Status</th><th>Actions</th></tr></thead>
        <tbody>
          {bills.map(b => (
            <tr key={b.id}>
              <td>{b.id}</td><td>{b.patientId}</td><td>{b.amount}</td><td>{b.status}</td>
              <td><button className="btn btn-sm btn-danger" onClick={async ()=>{ if(window.confirm('Delete?')){ await deleteBill(b.id); fetch(); }}}>Delete</button></td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}