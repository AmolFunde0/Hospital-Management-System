import api from './baseService';

export const getAllBills = async () => {
  const res = await api.get('/bill');
  return res.data;
};

export const createBill = async (bill) => {
  const res = await api.post('/bill/bill', bill);
  return res.data;
};

export const getBillById = async (id) => {
  const res = await api.get(`/bill/${id}`);
  return res.data;
};

export const updateBill = async (id, bill) => {
  const res = await api.put(`/bill/${id}`, bill);
  return res.data;
};

export const deleteBill = async (id) => {
  const res = await api.delete(`/bill/${id}`);
  return res.data;
};