import Axios from "axios";

import NProgress from "../progress";

export const PATH_URL = import.meta.env.VITE_API_BASE_PATH;

// 创建Axios实例对象 (https://axios-http.com/zh/docs/instance)
const request = Axios.create({
  baseURL: PATH_URL,
  timeout: 10000,
  // 跨域请求时是否需要使用凭证,不写无法在发送请求时携带Cookie，就无法完成登录。
  withCredentials: true,
  headers: {
    Accept: "application/json, text/plain, */*",
    "Content-Type": "application/json",
    "X-Requested-With": "XMLHttpRequest"
  }
});
// 请求拦截器
request.interceptors.request.use(
  config => {
    // 在发送请求之前做些什么
    // 开启进度条动画
    NProgress.start();
    // todo token处理相关逻辑
    return config;
  },
  error => {
    // 对请求错误做些什么
    return Promise.reject(error);
  }
);
// 添加响应拦截器
request.interceptors.response.use(
  response => {
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    NProgress.done();
    // 后端封装的统一响应体
    return response.data;
  },
  error => {
    // 超出 2xx 范围的状态码都会触发该函数。
    // 对响应错误做点什么
    NProgress.done();
    return Promise.reject(error);
  }
);

export default request;
