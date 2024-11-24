// 配合后端统一接口返回格式，对Axios请求进行扩展
import type AxiosRequestConfig from "axios";

// 后台统一接口返回格式
interface ApiResponse<T = any> {
  code: number;
  data: T extends any ? T : T & any;
  msg: string;
  success: boolean;
}

declare module "axios" {
  export interface AxiosInstance {
    <T = any>(config: AxiosRequestConfig): Promise<ApiResponse<T>>;
    request<T = any>(config: AxiosRequestConfig): Promise<ApiResponse<T>>;
    get<T = any>(
      url: string,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
    delete<T = any>(
      url: string,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
    head<T = any>(
      url: string,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
    post<T = any>(
      url: string,
      data?: any,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
    put<T = any>(
      url: string,
      data?: any,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
    patch<T = any>(
      url: string,
      data?: any,
      config?: AxiosRequestConfig
    ): Promise<ApiResponse<T>>;
  }
}
