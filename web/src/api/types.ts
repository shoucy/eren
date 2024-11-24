/** 分页属性 */
export interface Page<T = any> {
  /** 当前页数据 */
  records: Array<T>;
  /** 当前页码 */
  pageNumber?: number;
  /** 每页数据数量  */
  pageSize?: number;
  /** 总页数 */
  totalPage?: number;
  /** 总数据数量 */
  totalRow?: number;
}
/** 实体类通用属性 */
export interface BaseEntity {
  id?: string;
  createBy?: string;
  createTime?: String;
  updateBy?: string;
  updateTime?: String;
}
