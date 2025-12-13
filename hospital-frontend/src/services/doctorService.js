import api from './baseService';

export const getAllDoctors = async () => {
  const res = await api.get('/doctor');
  return res.data;
};

export const createDoctor = async (doctor) => {
  const res = await api.post('/doctor/doctor', doctor);
  return res.data;
};

export const getDoctorById = async (id) => {
  const res = await api.get(`/doctor/${id}`);
  return res.data;
};

export const updateDoctor = async (id, doctor) => {
  const res = await api.put(`/doctor/${id}`, doctor);
  return res.data;
};

export const deleteDoctor = async (id) => {
  const res = await api.delete(`/doctor/${id}`);
  return res.data;
};