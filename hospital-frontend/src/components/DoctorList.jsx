import React, { useEffect, useState } from 'react';
import { getAllDoctors, deleteDoctor } from '../services/doctorService';
import { Link } from 'react-router-dom';

export default function DoctorList() {
  const [doctors, setDoctors] = useState([]);

  const fetch = async () => {
    try {
      const data = await getAllDoctors();
      setDoctors(data || []);
    } catch (e) { console.error(e); }
  };

  useEffect(() => { fetch(); }, []);

  return (
    <div>
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h3>Doctors</h3>
        <Link to="/doctors/new" className="btn btn-primary">Add Doctor</Link>
      </div>
      <table className="table table-striped">
        <thead><tr><th>ID</th><th>Name</th><th>Speciality</th><th>Age</th></tr></thead>
        <tbody>
          {doctors.map(d => (
            <tr key={d.id}><td>{d.id}</td><td>{d.name}</td><td>{d.speciality}</td><td>{d.age}</td></tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}