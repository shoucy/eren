import request from "@/utils/request";
import type { BaseEntity, Page } from "../types";

export interface Role extends BaseEntity {
  name?: string;
  code?: string;
  status?: number;
  remark?: string;
}
// 角色管理
const basePath = "/sys/role";

export default {
  getList(params: Role = {}) {
    return request.get<Page<Role>>(basePath, { params });
  },
  save(data: Role) {
    return request.post(basePath, data);
  },
  delete(id: string) {
    return request.delete(`${basePath}/${id}`);
  }
};
