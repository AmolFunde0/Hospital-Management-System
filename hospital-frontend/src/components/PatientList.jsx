import React, { useEffect, useState } from 'react';
import { getAllPatients, deletePatient } from '../services/patientService';
import { Link } from 'react-router-dom';

export default function PatientList() {
  const [patients, setPatients] = useState([]);
  const [loading, setLoading] = useState(true);

  const fetch = async () => {
    setLoading(true);
    try {
      const data = await getAllPatients();
      setPatients(data || []);
    } catch (e) {
      console.error(e);
    }
    setLoading(false);
  };

  useEffect(() => { fetch(); }, []);

  const handleDelete = async (id) => {
    if (!window.confirm('Delete patient id ' + id + '?')) return;
    await deletePatient(id);
    fetch();
  };

  if (loading) return <div>Loading...</div>;

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h3>Patients</h3>
        <Link to="/patients/new" className="btn btn-primary">Add Patient</Link>
      </div>
      <table className="table table-striped">
        <thead>
          <tr><th>ID</th><th>Name</th><th>Gender</th><th>Age</th><th>Actions</th></tr>
        </thead>
        <tbody>
          {patients.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.name}</td>
              <td>{p.gender}</td>
              <td>{p.age}</td>
              <td className="table-actions">
                <Link to="/patients/new" className="btn btn-sm btn-outline-secondary">Edit</Link>
                <button onClick={() => handleDelete(p.id)} className="btn btn-sm btn-danger">Delete</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}