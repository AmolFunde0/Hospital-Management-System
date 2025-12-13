import api from './baseService';

export const getAllAppointments = async () => {
  const res = await api.get('/appointment');
  return res.data;
};

export const createAppointment = async (appointment) => {
  const res = await api.post('/appointment/appointment', appointment);
  return res.data;
};

export const getAppointmentById = async (id) => {
  const res = await api.get(`/appointment/${id}`);
  return res.data;
};

export const updateAppointment = async (id, appointment) => {
  const res = await api.put(`/appointment/${id}`, appointment);
  return res.data;
};

export const deleteAppointment = async (id) => {
  const res = await api.delete(`/appointment/${id}`);
  return res.data;
};