import React from "react";
import { Link } from "react-router-dom";

export default function Dashboard() {
  return (
    <div className="container py-4">
      <h1 className="text-center mb-4 text-primary fw-bold">
        Hospital Management System
      </h1>
      <p className="text-center text-secondary mb-5">
        Manage your hospital operations efficiently — access Patients, Doctors,
        Appointments, and Bills below.
      </p>

      <div className="row g-4">
        {/* Patients */}
        <div className="col-12 col-sm-6 col-lg-3">
          <div className="card shadow-sm border-0 h-100">
            <div className="card-body text-center">
              <i className="bi bi-person-lines-fill fs-1 text-primary"></i>
              <h5 className="card-title mt-3">Patients</h5>
              <p className="card-text text-muted">
                View, add, and manage all patient records.
              </p>
              <Link to="/patients" className="btn btn-outline-primary">
                Manage
              </Link>
            </div>
          </div>
        </div>

        {/* Doctors */}
        <div className="col-12 col-sm-6 col-lg-3">
          <div className="card shadow-sm border-0 h-100">
            <div className="card-body text-center">
              <i className="bi bi-heart-pulse fs-1 text-danger"></i>
              <h5 className="card-title mt-3">Doctors</h5>
              <p className="card-text text-muted">
                Add or update doctor profiles and specialities.
              </p>
              <Link to="/doctors" className="btn btn-outline-danger">
                Manage
              </Link>
            </div>
          </div>
        </div>

        {/* Appointments */}
        <div className="col-12 col-sm-6 col-lg-3">
          <div className="card shadow-sm border-0 h-100">
            <div className="card-body text-center">
              <i className="bi bi-calendar-check fs-1 text-success"></i>
              <h5 className="card-title mt-3">Appointments</h5>
              <p className="card-text text-muted">
                Schedule and manage patient appointments.
              </p>
              <Link to="/appointments" className="btn btn-outline-success">
                Manage
              </Link>
            </div>
          </div>
        </div>

        {/* Bills */}
        <div className="col-12 col-sm-6 col-lg-3">
          <div className="card shadow-sm border-0 h-100">
            <div className="card-body text-center">
              <i className="bi bi-cash-stack fs-1 text-warning"></i>
              <h5 className="card-title mt-3">Bills</h5>
              <p className="card-text text-muted">
                Generate and track billing information.
              </p>
              <Link to="/bills" className="btn btn-outline-warning">
                Manage
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}
