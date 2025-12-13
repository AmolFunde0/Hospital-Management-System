import api from './baseService';

export const getAllPatients = async () => {
  const res = await api.get('/patients');
  return res.data;
};

export const createPatient = async (patient) => {
  const res = await api.post('/patients/patient', patient);
  return res.data;
};

export const getPatientById = async (id) => {
  const res = await api.get(`/patients/${id}`);
  return res.data;
};

export const updatePatient = async (id, patient) => {
  const res = await api.put(`/patients/${id}`, patient);
  return res.data;
};

export const deletePatient = async (id) => {
  const res = await api.delete(`/patients/${id}`);
  return res.data;
};