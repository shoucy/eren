package com.shoucy.eren.system.entity;

import com.mybatisflex.annotation.Table;
import com.shoucy.eren.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统角色表
 *
 * @author shoucy
 */
@EqualsAndHashCode(callSuper = true)
@Table(value = "sys_role")
@Data
public class Role extends BaseEntity {

	/**
	 * 角色名称
	 */
	private String roleName;

	/**
	 * 角色代码
	 */
	private String roleCode;

	/**
	 * 状态
	 */
	private Integer status;

	/**
	 * 备注
	 */
	private String remark;

}