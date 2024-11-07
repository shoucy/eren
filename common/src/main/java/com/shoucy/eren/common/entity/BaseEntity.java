package com.shoucy.eren.common.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;

import java.util.Date;

/**
 * 基础实体类
 *
 * @author shoucy
 */
@Data
public class BaseEntity {

	@Id(keyType = KeyType.Auto)
	private String id;

	/**
	 * 创建者
	 */
	private String createBy;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新者
	 */
	private String updateBy;

	/**
	 * 更新时间
	 */
	private Date updateTime;

}
