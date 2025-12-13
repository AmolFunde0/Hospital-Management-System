import axios from 'axios';

const API_BASE = 'http://localhost:8080/api/v1';

const axiosInstance = axios.create({
  baseURL: API_BASE,
  headers: { 'Content-Type': 'application/json' }
});

export default axiosInstance;