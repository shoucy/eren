package com.shoucy.eren.common.entity;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * 表格分页数据对象
 *
 * @author shoucy
 */
@Data
public class PageResult implements Serializable {

	/**
	 * 返回状态码，200为成功
	 */
	private int code;

	/**
	 * 响应数据
	 */
	private List<?> rows;

	/**
	 * 总页数，一般由框架自动注入。
	 */
	private Long total;

	/**
	 * 响应信息，比异常的提示，警告，提示语等
	 */
	private String msg;

	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * 响应请求分页数据
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static PageResult ok(List<?> list) {
		PageResult result = new PageResult();
		result.setCode(ResultCode.SUCCESS.getCode());
		result.setRows(list);
		result.setTotal(new PageInfo(list).getTotal());
		result.setMsg("查询成功");
		return result;
	}

}
